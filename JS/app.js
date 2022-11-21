var app = (function (){

    var scores = [];
    var turno = 1;

    var cerrar = function (cant){
        $("#login"+cant).removeClass("active")
    }

    var playersCant = function (cant){
        localStorage.setItem("totalPlayers", cant);
        $("#login"+cant).addClass("active");
    }

    var iniciar = function (){
        var totalPlayers = localStorage.getItem("totalPlayers")
        for (let i=1; i<=totalPlayers;i++){
            localStorage.setItem("player"+i, document.getElementById(totalPlayers+"P"+i).value);
        }
        window.location="master.html"
    }

    var init = function (){
        $("#turno").empty();
        $("#turno").append("Turno de: "+ localStorage.getItem("player"+turno));
        var totalPlayers = localStorage.getItem("totalPlayers")
        for (let i=1; i<=4;i++){
            if(i <= totalPlayers){
                $("#nombreP"+i).empty();
                $("#nombreP"+i).append(localStorage.getItem("player"+i))
                scores.push(0);
            }else {
                document.getElementById("score"+i).hidden = true;
            }
        }
    }

    var sumarPuntos = function (puntos){
        scores[turno-1] += puntos;
        $("#scoreP"+turno).empty();
        $("#scoreP"+turno).append(scores[turno-1])

        $("#score"+turno).removeClass("turno");
        $("#score"+turno).addClass("noTurno");

        if(scores[turno-1]>=27){
            window.location="winner.html"
        }

        if(turno == localStorage.getItem("totalPlayers")){
            $("#score1").addClass("turno");
            $("#turno").empty();
            $("#turno").append("Turno de: "+ localStorage.getItem("player1"));
            turno = 1;
        }else {
            turno+=1;
            $("#turno").empty();
            $("#turno").append("Turno de: "+ localStorage.getItem("player"+turno));
            $("#score"+turno).addClass("turno")
        }
    }

    return {
        playersCant:playersCant,
        cerrar: cerrar,
        iniciar: iniciar,
        init: init,
        sumarPuntos: sumarPuntos
    }
})();
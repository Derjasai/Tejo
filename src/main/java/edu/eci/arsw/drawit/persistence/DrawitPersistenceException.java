package edu.eci.arsw.drawit.persistence;

public class DrawitPersistenceException extends Exception{

    public static final String NO_USER = "No se ha encontrado el usuario dentro de la partida";

    public DrawitPersistenceException(String message){
        super(message);
    }

    public DrawitPersistenceException(String message, Throwable cause){
        super(message,cause);
    }
}
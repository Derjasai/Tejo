package edu.eci.arsw.drawit.services;

import edu.eci.arsw.drawit.model.Pista;
import edu.eci.arsw.drawit.model.Point;
import edu.eci.arsw.drawit.model.User;
import edu.eci.arsw.drawit.persistence.DrawitPersistence;
import edu.eci.arsw.drawit.persistence.DrawitPersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class DrawitServices {

    @Autowired
    DrawitPersistence dip = null;

    public void addNewUser(User user){
        dip.saveUser(user);
    }

    public Set<User> getAllUsers(){
        return dip.getAllUsers();
    }

    public User getUser(String name) throws DrawitPersistenceException {
        return dip.getUser(name);
    }

    public ArrayList<Point> getPointsByUser(String name){
        return dip.getPointsByUser(name);
    }

    public void addPointToUser(User user){
        dip.addPointToUser(user);
    }

    public void delteAllPointsUser(String name){
        dip.delteAllPointsUser(name);
    }

    public User getMasterName(){
        return dip.getMasterName();
    }

    public User getGanador(){
        return dip.getGanador();
    }

    public void setGanador(String name){
        dip.setGanador(name);
    }

    public void deleteParticipantes(){dip.deleteParticipantes();}

    public void addNewPista(Pista pista) throws DrawitPersistenceException{
        dip.savePista(pista);
    }

    public String tomarPista(){
        return dip.tomarPista();
    }

}
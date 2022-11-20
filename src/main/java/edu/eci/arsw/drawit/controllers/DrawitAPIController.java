package edu.eci.arsw.drawit.controllers;

import com.google.gson.Gson;
import edu.eci.arsw.drawit.model.Pista;
import edu.eci.arsw.drawit.model.User;
import edu.eci.arsw.drawit.persistence.DrawitPersistenceException;
import edu.eci.arsw.drawit.services.DrawitServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value="/drawit")
public class DrawitAPIController {

    @Autowired
    DrawitServices ds = null;

    @RequestMapping(path = "/masterName/masterName" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getMasterName() {
        User master = null;
        try {
            master = ds.getMasterName();
        } catch (Exception e) {
            return new ResponseEntity<>("Error",HttpStatus.NOT_FOUND);
        }
        Gson gson = new Gson();
        return new ResponseEntity<>(gson.toJson(master), HttpStatus.ACCEPTED);

    }

    @RequestMapping(path = "/{name}" , method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> setGanador(@PathVariable String name) {
        try {
            ds.setGanador(name);
        } catch (Exception e) {
            return new ResponseEntity<>("Error",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @RequestMapping(path= "/clean", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteParticipantes() {
        try {
            ds.deleteParticipantes();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @RequestMapping(path = "/{name}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getBlueprintByAuthorName(@PathVariable String name) {
        User user = null;
        try {
            user = ds.getUser(name);
        } catch (DrawitPersistenceException e) {
            return new ResponseEntity<>("Error",HttpStatus.NOT_FOUND);
        }
        Gson gson = new Gson();
        return new ResponseEntity<>(gson.toJson(user), HttpStatus.ACCEPTED);

    }



    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postUser(@RequestBody User user){
        try {
            ds.addNewUser(user);
            //registrar dato
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            Logger.getLogger(DrawitAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("Error bla bla bla",HttpStatus.FORBIDDEN);
        }

    }

    @RequestMapping(path = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUsers() {
        try {
            Gson gson = new Gson();
            return new ResponseEntity<>(gson.toJson(ds.getAllUsers()), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(DrawitAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Error al buscar a los participantes", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/pista", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> guardarPista(@RequestBody Pista pista){
        try {
            ds.addNewPista(pista);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex){
            Logger.getLogger(DrawitAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>("No se ha podido crear la pista", HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(path = "/tomarpista", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> tomarPista() {
        try {
            Gson gson = new Gson();
            return new ResponseEntity<>(gson.toJson(ds.tomarPista()), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            Logger.getLogger(DrawitAPIController.class.getName()).log(Level.SEVERE, null, e);
            return new ResponseEntity<>("Error al buscar a los participantes", HttpStatus.NOT_FOUND);
        }
    }
}
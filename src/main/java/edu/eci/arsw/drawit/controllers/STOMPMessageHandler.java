package edu.eci.arsw.drawit.controllers;

import edu.eci.arsw.drawit.model.Point;
import edu.eci.arsw.drawit.model.User;
import edu.eci.arsw.drawit.services.DrawitServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

@Controller
public class STOMPMessageHandler {

    @Autowired
    SimpMessagingTemplate msgt;

    @Autowired
    DrawitServices ds = null;

    @MessageMapping("/{name}")
    public synchronized void handlePointEvent(Point point, @DestinationVariable String name) throws Exception{
        msgt.convertAndSend("/topic/"+name, point);
        ArrayList<Point> points = new ArrayList<>();
        points.add(point);
        User user = new User(name, points);
        ds.addPointToUser(user);
    }

    @MessageMapping("/delete.{name}")
    public synchronized void handleDeletePointsEvent(@DestinationVariable String name) throws Exception{
        msgt.convertAndSend("/topic/"+name,"delete");
        ds.delteAllPointsUser(name);
    }



}
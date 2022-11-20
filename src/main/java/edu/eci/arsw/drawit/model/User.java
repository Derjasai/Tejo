package edu.eci.arsw.drawit.model;

import java.util.ArrayList;

public class User {

    private String name;
    private ArrayList<Point> points = new ArrayList<>();
    private boolean isGanador = false;

    public User(String name, ArrayList<Point> points){
        this.name = name;
        this.points = points;
    }
    public User(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<Point> points) {
        this.points = points;
    }

    public void addPoint(Point point){
        this.points.add(point);
    }

    public void deletePoints(){
        this.points.clear();
    }

    public boolean isGanador() {
        return isGanador;
    }

    public void setGanador(boolean ganador) {
        isGanador = ganador;
    }
}
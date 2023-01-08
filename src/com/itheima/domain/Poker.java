package com.itheima.domain;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Poker extends JLabel implements MouseListener {
    //自己练习
    private String name; //name of a poker card
    private boolean up; //whether this card is up or not
    private boolean clicked = false; //whether this card is clicked
    private boolean canbeClicked = false;  //this card can be clicked or not

    public Poker(String name, boolean up){
        this.name = name;
        this.up = up;

        if(up){
            turnfront(); // note
        }else{
            turnrear();
        }
        this.setSize(71,96); //note
        this.setVisible(true);
        this.addMouseListener(this); //note
    }

    public void turnrear() { //note public
        this.setIcon(new ImageIcon("image/poker/rear.png")); //note whole command
        this.up = false; //note donot forget details
    }

    public void turnfront() {
        this.setIcon(new ImageIcon("image/poker/"+name+".png"));
        this.up = true;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if(canbeClicked) {
            int step = 0;
            if (clicked) {
                step = -20;
            } else {
                step = 20;
            }
            clicked = !clicked;  //note
            Point from = this.getLocation();
            Point to = new Point(from.x, from.y + step);
            this.getLocation(to);
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public boolean isCanbeClicked() {
        return canbeClicked;
    }

    public void setCanbeClicked(boolean canbeClicked) {
        this.canbeClicked = canbeClicked;
    }

    @Override
    public String toString() {
        return "Poker{" +
                "name='" + name + '\'' +
                ", up=" + up +
                '}';
    }
}

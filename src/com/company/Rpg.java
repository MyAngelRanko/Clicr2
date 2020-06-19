package com.company;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Rpg {
    public static void main(String []args) throws SlickException{
        AppGameContainer container = new AppGameContainer(new RpgFiles("Clicker"));
        container.setDisplayMode(1280,1000,false);
        container.start();
    }
}
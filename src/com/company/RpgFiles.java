package com.company;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;

public class RpgFiles extends BasicGame {
    Circle circle;
    Rectangle rectangle;
    public RpgFiles(String title){ super(title);}

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        gameContainer.setVSync(true);
        circle = new Circle(400, 400, 35);
        rectangle = new Rectangle(1000, 500, 40, 40);
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        if(circle.getCenterX() > gameContainer.getWidth()){
            circle.setCenterX(gameContainer.getWidth());
        }

        if (circle.getCenterY() > gameContainer.getHeight()) {
            circle.setCenterY(gameContainer.getHeight());
        }

        if (circle.getCenterY() == gameContainer.getHeight()){
            circle.setCenterY(gameContainer.getHeight());
        }

        if(gameContainer.getInput().isKeyDown(Input.KEY_A) == true) {
            circle.setCenterX(circle.getCenterX() - 8);
            rectangle.setCenterX(rectangle.getCenterX() - (i * 0.5f));
        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_W) == true) {
            circle.setCenterY(circle.getCenterY() - 8);
            rectangle.setCenterY(rectangle.getCenterY() - (i * 0.5f));
        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_D) == true) {
            circle.setCenterX(circle.getCenterX() + 8);
            rectangle.setCenterX(rectangle.getCenterX() + (i * 0.5f));
        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_S) == true) {
            circle.setCenterY(circle.getCenterY() + 8);
            rectangle.setCenterY(rectangle.getCenterY() + (i * 0.5f));
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.setColor(Color.cyan);
        graphics.fill(circle);

        graphics.setColor(Color.green);
        graphics.fill(rectangle);
    }
}
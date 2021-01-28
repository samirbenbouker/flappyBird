package com.mygdx.game.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import java.sql.Time;
import java.util.Timer;
import java.util.TimerTask;

public class Bird {

    private static final int GRAVITY = -15;
    private static final int MOVEMENT = 100;

    private static int POINTS = 0;

    private Vector3 position;
    private Vector3 velocity;
    private Rectangle bounds;
    private Animation birdAnimation;
    private Texture texture;

    private Texture bird;

    public Bird(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0,0,0);
        texture = new Texture("birdanimation.png");
        birdAnimation = new Animation(new TextureRegion(texture), 3, 0.5f);
        bounds = new Rectangle(x, y, texture.getWidth() / 3, texture.getHeight());

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println(POINTS);
                POINTS++;
            }
        };
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(timerTask, 6, 1000);
    }

    public void update(float dt) {

        birdAnimation.update(dt);

        if(position.y > 0) {
            velocity.add(0, GRAVITY, 0);
        }

        velocity.add(0, GRAVITY, 0);
        velocity.scl(dt);
        position.add(MOVEMENT * dt, velocity.y, 0);

        if(position.y < 0) {
            position.y = 0;
        }

        velocity.scl(1/dt);
        bounds.setPosition(position.x, position.y);
    }

    public Vector3 getPosition() {
        return  position;
    }

    public TextureRegion getBird() {
        return birdAnimation.getFrame();
    }

    public void jump() {

        velocity.y = 350;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public void dispose() {
        bird.dispose();
    }
}

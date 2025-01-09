package com.almondcoffee.objects.birds;

import com.almondcoffee.support.PhysicsExt;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Blue extends Birdie {

    public Blue(){
        bird = new Sprite(new Texture("birdblue.png"));
        bird.setSize(1,1);
        bird.setOrigin(bird.getWidth()/2,bird.getHeight()/2);
    }

    public Blue(float x, float y){
        bird = new Sprite(new Texture("birdblue.png"));
        bird.setSize(1,1);
        bird.setOrigin(bird.getWidth()/2,bird.getHeight()/2);
        bird.setPosition(x, y);
    }
}

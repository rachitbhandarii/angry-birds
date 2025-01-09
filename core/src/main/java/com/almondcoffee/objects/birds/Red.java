package com.almondcoffee.objects.birds;

import com.almondcoffee.support.PhysicsExt;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Red extends Birdie{

    public Red(){
        bird = new Sprite(new Texture("birdred.png"));
        bird.setSize(1,1);
        bird.setOrigin(bird.getWidth()/2,bird.getHeight()/2);
    }

    public Red(float x, float y){
        bird = new Sprite(new Texture("birdred.png"));
        bird.setSize(1,1);
        bird.setOrigin(bird.getWidth()/2,bird.getHeight()/2);
        bird.setPosition(x, y);
    }
}

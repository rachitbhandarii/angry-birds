package com.almondcoffee.angrybirds;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Red extends Birdie{

    public Red(){
        bird = new Sprite(new Texture("birdred.png"));
        bird.setSize(1.5f,1.5f);
    }

    public Red(float x, float y){
        bird = new Sprite(new Texture("birdred.png"));
        bird.setSize(1.5f,1);
        bird.setPosition(x, y);
    }
}

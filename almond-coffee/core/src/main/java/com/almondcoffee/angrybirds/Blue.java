package com.almondcoffee.angrybirds;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Blue extends Birdie {

    public Blue(){
        bird = new Sprite(new Texture("birdblue.png"));
        bird.setSize(1.5f,1.5f);
    }

    public Blue(float x, float y){
        bird = new Sprite(new Texture("birdblue.png"));
        bird.setSize(1,1);
        bird.setPosition(x, y);
    }
}

package com.almondcoffee.angrybirds;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Yellow extends Birdie {

    public Yellow(){
        bird = new Sprite(new Texture("birdyellow.png"));
        bird.setSize(1.5f,1.5f);
    }

    public Yellow(float x, float y){
        bird = new Sprite(new Texture("birdyellow.png"));
        bird.setSize(1.5f,1);
        bird.setPosition(x, y);
    }
}

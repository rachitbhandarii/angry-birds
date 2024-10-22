package com.almondcoffee.angrybirds;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Wood extends Material{

    public Wood(){
        material = new Sprite(new Texture("wood.png"));
        material.setSize(1,3);
    }

    public Wood(float x, float y){
        material = new Sprite(new Texture("wood.png"));
        material.setSize(0.7f,2);
        material.setPosition(x, y);
    }
}

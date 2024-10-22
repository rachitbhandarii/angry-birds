package com.almondcoffee.angrybirds;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Glass extends Material{

    public Glass(){
        material = new Sprite(new Texture("glass.png"));
        material.setSize(1,1);
    }

    public Glass(float x, float y){
        material = new Sprite(new Texture("glass.png"));
        material.setSize(0.7f,2);
        material.setPosition(x, y);
    }
}

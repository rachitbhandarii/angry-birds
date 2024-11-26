package com.almondcoffee.angrybirds;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Wood extends Material{

    public Wood(){
        material = new Sprite(new Texture("wood.png"));
        material.setSize(1,2.5f);
    }

    public Wood(float x, float y){
        material = new Sprite(new Texture("wood.png"));
        material.setSize(0.7f,2.5f);
        material.setCenter(x, y);
    }
}

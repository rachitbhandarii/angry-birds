package com.almondcoffee.angrybirds;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Stone extends Material{

    public Stone(){
        material = new Sprite(new Texture("stone.png"));
        material.setSize(1,1);
    }

    public Stone(float x, float y){
        material = new Sprite(new Texture("stone.png"));
        material.setSize(0.7f,2);
        material.setPosition(x, y);
    }
}

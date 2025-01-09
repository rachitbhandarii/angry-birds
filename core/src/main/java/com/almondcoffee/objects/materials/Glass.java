package com.almondcoffee.objects.materials;

import com.almondcoffee.support.PhysicsExt;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Glass extends Material{

    public Glass(){
        material = new Sprite(new Texture("glass.png"));
        material.setSize(0.7f,2.5f);
        material.setOrigin(material.getWidth()/2,material.getHeight()/2);
    }

    public Glass(float x, float y){
        material = new Sprite(new Texture("glass.png"));
        material.setSize(0.7f,2.5f);
        material.setOrigin(material.getWidth()/2,material.getHeight()/2);
        material.setPosition(x, y);
    }

    public Glass(float x, float y, boolean rotate){
        material = new Sprite(new Texture("glass.png"));
        material.setSize(0.7f,2.5f);
        material.setOrigin(material.getWidth()/2,material.getHeight()/2);
        material.setPosition(x, y);
        if (rotate) material.rotate(90);
    }
}

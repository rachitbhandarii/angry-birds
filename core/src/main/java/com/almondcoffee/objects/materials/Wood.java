package com.almondcoffee.objects.materials;

import com.almondcoffee.support.PhysicsExt;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Wood extends Material{

    public Wood(){
        material = new Sprite(new Texture("wood.png"));
        material.setSize(0.7f,2.5f);
        material.setOrigin(material.getWidth()/2,material.getHeight()/2);
    }

    public Wood(float x, float y){
        material = new Sprite(new Texture("wood.png"));
        material.setSize(0.7f,2.5f);
        material.setOrigin(material.getWidth()/2,material.getHeight()/2);
        material.setPosition(x, y);
    }
}

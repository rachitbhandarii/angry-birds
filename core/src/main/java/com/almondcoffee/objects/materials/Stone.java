package com.almondcoffee.objects.materials;

import com.almondcoffee.support.PhysicsExt;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Stone extends Material{

    public Stone(){
        material = new Sprite(new Texture("stone.png"));
        material.setSize(0.7f,2.5f);
        material.setOrigin(material.getWidth()/2,material.getHeight()/2);
    }

    public Stone(float x, float y){
        material = new Sprite(new Texture("stone.png"));
        material.setSize(0.7f,2.5f);
        material.setOrigin(material.getWidth()/2,material.getHeight()/2);
        material.setPosition(x, y);
    }
}

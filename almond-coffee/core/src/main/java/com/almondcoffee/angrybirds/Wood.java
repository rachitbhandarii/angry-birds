package com.almondcoffee.angrybirds;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Wood extends Material{

    public Wood(){
        material = new Sprite(new Texture("wood.png"));
    }
}

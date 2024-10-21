package com.almondcoffee.angrybirds;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Glass extends Material{

    public Glass(){
        material = new Sprite(new Texture("glass.png"));
    }
}

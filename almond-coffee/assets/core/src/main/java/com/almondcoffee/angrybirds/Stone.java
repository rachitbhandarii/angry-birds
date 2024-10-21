package com.almondcoffee.angrybirds;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Stone extends Material{

    public Stone(){
        material = new Sprite(new Texture("stone.png"));
    }
}

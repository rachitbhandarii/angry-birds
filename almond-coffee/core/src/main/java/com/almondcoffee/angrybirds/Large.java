package com.almondcoffee.angrybirds;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Large extends Piggie{

    public Large() {
        pig.setSize(2,2);
    }

    public Large(float x, float y) {
        pig.setSize(1,1);
        setPosition(x, y);
    }
}

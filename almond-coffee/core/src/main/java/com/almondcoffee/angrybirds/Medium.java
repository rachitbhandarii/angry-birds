package com.almondcoffee.angrybirds;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Medium extends Piggie{

    public Medium() {
        pig.setSize(1.75f,1.75f);
    }

    public Medium(float x, float y) {
        pig.setSize(0.8f,0.8f);
        setPosition(x, y);
    }
}

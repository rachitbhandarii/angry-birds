package com.almondcoffee.angrybirds;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Small extends Piggie {

    public Small() {
        pig.setSize(0.75f,0.75f);
    }

    public Small(float x, float y) {
        pig.setSize(0.6f,0.6f);
        setPosition(x, y);
    }
}

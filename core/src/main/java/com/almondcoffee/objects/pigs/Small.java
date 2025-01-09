package com.almondcoffee.objects.pigs;

import com.almondcoffee.support.PhysicsExt;

public class Small extends Piggie {

    public Small() {
        pig.setSize(0.75f,0.75f);
    }

    public Small(float x, float y) {
        pig.setSize(0.6f,0.6f);
        pig.setOrigin(pig.getWidth()/2,pig.getHeight()/2);
        pig.setPosition(x, y);
    }
}

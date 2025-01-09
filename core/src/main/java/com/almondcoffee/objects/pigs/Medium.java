package com.almondcoffee.objects.pigs;

public class Medium extends Piggie{

    public Medium() {
        pig.setSize(1.75f,1.75f);
    }

    public Medium(float x, float y) {
        pig.setSize(0.8f,0.8f);
        pig.setOrigin(pig.getWidth()/2,pig.getHeight()/2);
        pig.setPosition(x, y);
    }
}

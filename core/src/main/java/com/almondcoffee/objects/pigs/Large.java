package com.almondcoffee.objects.pigs;

public class Large extends Piggie{

    public Large() {
        pig.setSize(2,2);
    }

    public Large(float x, float y) {
        pig.setSize(1,1);
        pig.setOrigin(pig.getWidth()/2,pig.getHeight()/2);
        pig.setPosition(x, y);
    }
}

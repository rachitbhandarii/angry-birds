package com.almondcoffee.attack;

import java.io.Serializable;

public class Attack implements Serializable {
    private int impact;
    private AttackType type;

    public int getImpact() {
        return impact;
    }

    public void setImpact(int impact) {
        this.impact = impact;
    }

    public AttackType getType() {
        return type;
    }

    public void setType(AttackType type) {
        this.type = type;
    }


}

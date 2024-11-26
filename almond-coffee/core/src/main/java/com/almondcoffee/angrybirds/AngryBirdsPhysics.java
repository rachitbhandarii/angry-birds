package com.almondcoffee.angrybirds;

import com.badlogic.gdx.math.Vector2;

public class AngryBirdsPhysics {
    private Vector2 birdPosition;
    private Vector2 initialPosition;
    private Vector2 velocity;
    private float gravity;
    private float elapsedTime;

    public AngryBirdsPhysics(Vector2 initialPosition, Vector2 initialVelocity, float gravity) {
        this.initialPosition = new Vector2(initialPosition);
        this.birdPosition = new Vector2(initialPosition);
        this.velocity = new Vector2(initialVelocity);
        this.gravity = gravity;
        this.elapsedTime = 0;
    }

    public void update(float deltaTime) {
        elapsedTime += deltaTime;

        // Calculate the new position based on projectile motion equations
        float newX = initialPosition.x + velocity.x * elapsedTime;
        float newY = initialPosition.y + velocity.y * elapsedTime + 0.5f * gravity * elapsedTime * elapsedTime;

        // Update bird's position
        birdPosition.set(newX, newY);

        // Update vertical velocity due to gravity
        velocity.y += gravity * deltaTime;
    }

    public Vector2 getBirdPosition() {
        return birdPosition;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public void reset(Vector2 newInitialPosition, Vector2 newInitialVelocity) {
        initialPosition.set(newInitialPosition);
        birdPosition.set(newInitialPosition);
        velocity.set(newInitialVelocity);
        elapsedTime = 0;
    }
}


package com.Houts;

public class Human {

    private String name;
    private int health; // normally 100
    private int strength; // normally 20
    private int speed = 1;
    private int[] humanLocation = {0, 0};
    private int numberOfSwings;
    private int numberOfMisses;
    private boolean invincible = false;
    private int invincibleCount = 0;
    public HumanWeapon weapon;


    public Human(String name, int health, int strength) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.weapon = new HumanWeapon();
    }

    // Controls player movement. Human can port through the land.
    public void playerMove(String direction) {

        switch(direction) {
            // Move up
            case "w":
                if(humanLocation[1] == 0) humanLocation[1] = 9;
                else if(humanLocation[1] == 1 && speed == 2) humanLocation[1] = 9;
                else humanLocation[1] -= speed;
                break;

            // Move down
            case "s":
                if(humanLocation[1] == 9) humanLocation[1] = 0;
                else if(humanLocation[1] == 8 && speed == 2) humanLocation[1] = 0;
                else humanLocation[1] += speed;
                break;

            // Move left
            case "a":
                if(humanLocation[0] == 0) humanLocation[0] = 9;
                else if(humanLocation[0] == 1 && speed == 2) humanLocation[0] = 9;
                else humanLocation[0] -= speed;
                break;

            // Move right
            case "d":
                if(humanLocation[0] == 9) humanLocation[0] = 0;
                else if(humanLocation[0] == 8 && speed == 2) humanLocation[0] = 0;
                else humanLocation[0] += speed;

            default:
        }
    }

    public void resetBattleStats() {
        this.numberOfSwings = 0;
        this.numberOfMisses = 0;
    }

    public void regenerateHealth() {
        if(health <= 98) health += 2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getNumberOfSwings() {
        return numberOfSwings;
    }

    public void setNumberOfSwings(int numberOfSwings) {
        this.numberOfSwings = numberOfSwings;
    }

    public int getNumberOfMisses() {
        return numberOfMisses;
    }

    public void setNumberOfMisses(int numberOfMisses) {
        this.numberOfMisses = numberOfMisses;
    }

    public boolean isInvincible() {
        return invincible;
    }

    public void setInvincible(boolean invincible) {
        this.invincible = invincible;
    }

    public int getInvincibleCount() {
        return invincibleCount;
    }

    public void setInvincibleCount(int invincibleCount) {
        this.invincibleCount = invincibleCount;
    }

    public int[] getHumanLocation() {
        return humanLocation;
    }

    public int getHumanLocationY() {
        return humanLocation[1];
    }

    public void setHumanLocationY(int humanLocationY) {
        this.humanLocation[1] = humanLocationY;
    }

    public int getHumanLocationX() {
        return humanLocation[0];
    }

    public void setHumanLocationX(int humanLocationX) {
        this.humanLocation[0] = humanLocationX;
    }

    @Override
    public String toString() {
        return ":{";
    }
}

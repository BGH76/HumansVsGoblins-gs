package com.Houts;

public class Goblin {
    private int health; // normally 100
    private int strength; // normally 20
    private int numberOfSwings;
    private int numberOfMisses;
    private String[] drops;
    private int[] goblinLocation = {0, 0};
    private boolean alive;
    private String[] dropItems = {"Additional Health", "Speed Increase", "Power Up"};


    public Goblin(int health, int strength, String[] drops, int goblinLocationY, int goblinLocationX, boolean alive) {
        this.health = health;
        this.strength = strength;
        this.drops = drops;
        this.goblinLocation[1] = goblinLocationY;
        this.goblinLocation[0] = goblinLocationX;
        this.alive = alive;
    }

    // Controls all goblins movement. Goblins can move in 8 directions.
    public int[] goblinMove(int[] goblinLocation, int[] humanLocation) {
            // if both X values are the same and goblins Y direction > than the humans then goblin moves up
        if(goblinLocation[0] == humanLocation[0] && goblinLocation[1] > humanLocation[1]) {
            goblinLocation[1] -= 1;
        }
            // if both X values are the same and goblins Y direction < then the humans then goblin moves down
        else if(goblinLocation[0] == humanLocation[0] && goblinLocation[1] < humanLocation[1]) {
            goblinLocation[1] += 1;
        }
            // if both Y values are the same and goblins X direction is > then humans then goblin moves left
        else if(goblinLocation[1] == humanLocation[1] && goblinLocation[0] > humanLocation[0]) {
            goblinLocation[0] -= 1;
        }
            // if both Y values are the same and goblins X direction is < then humans then goblin moves right
        else if(goblinLocation[1] == humanLocation[1] && goblinLocation[0] < humanLocation[0]) {
            goblinLocation[0] += 1;
        }
            // if goblins X value is < then humans and Y value is < then humans then goblin moves right and down
        else if(goblinLocation[0] < humanLocation[0] && goblinLocation[1] < humanLocation[1]) {
            goblinLocation[0] += 1;
            goblinLocation[1] += 1;
        }
            // if goblins X value is < then humans and Y value is > then humans then goblin moves right and up
        else if(goblinLocation[0] < humanLocation[0] && goblinLocation[1] > humanLocation[1]) {
            goblinLocation[0] += 1;
            goblinLocation[1] -=1;
        }
            // if goblins X value is > then humans and Y value is < then humans then goblin moves left and down
        else if(goblinLocation[0] > humanLocation[0] && goblinLocation[1] < humanLocation[1]) {
            goblinLocation[0] -= 1;
            goblinLocation[1] +=1;
        }
            // if goblins X value is > then humans and Y value is > then humans then goblin moves left and up
        else if(goblinLocation[0] > humanLocation[0] && goblinLocation[1] > humanLocation[1]) {
            goblinLocation[0] -= 1;
            goblinLocation[1] -=1;
        }
        return goblinLocation;
    }


    public GoblinDrop goblinDrop() {
        int temp = (int) (Math.random() * (10) + 1);
        if(temp == 5) {
            int dropRandom = (int) (Math.random() * (dropItems.length));
            String item = dropItems[dropRandom];
            GoblinDrop goblinDrop = new GoblinDrop(goblinLocation[0], goblinLocation[1], item, true);
            return goblinDrop;
        }
        return null;
    }

    public void setGoblinLocation(int[] g) {
        this.goblinLocation = g;
    }

    public int[] getGoblinLocation() {
        return goblinLocation;
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

    public String[] getDrops() {
        return drops;
    }

    public void setDrops(String[] drops) {
        this.drops = drops;
    }

    public int getGoblinLocationY() {
        return goblinLocation[1];
    }

    public void setGoblinLocationY(int goblinLocationY) {
        this.goblinLocation[1] = goblinLocationY;
    }

    public int getGoblinLocationX() {
        return goblinLocation[0];
    }

    public void setGoblinLocationX(int goblinLocationX) {
        this.goblinLocation[0] = goblinLocationX;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public String toString() {
        return "# ";
    }

}

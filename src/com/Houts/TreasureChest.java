package com.Houts;

// Treasure Chest are dropped after each battle. The locations is random. Random locations are defined in the Main class.
public class TreasureChest {

    private int[] treasureLoc = {0, 0};
    private String[] treasureItems = {"Full Health", "Enhanced Strength", "Invincible"};
    private String dropItem;
    private boolean active;

    public TreasureChest(int locX, int locY, int item, boolean active) {
        treasureLoc[0] = locX;
        treasureLoc[1] = locY;
        this.dropItem = treasureItems[item];
        this.active = active;
    }

    public int[] getTreasureLoc() {
        return treasureLoc;
    }

    public int getLocationX() {
        return treasureLoc[0];
    }

    public int getLocationY() {
        return treasureLoc[1];
    }

    public void setTreasureLoc(int[] treasureLoc) {
        this.treasureLoc = treasureLoc;
    }

    public String getDropItem() {
        return dropItem;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "$ ";
    }
}

package com.Houts;

// Goblin drops are dropped at the goblins coordinates by chance.
// All drops will remain in place until picked up by a human.
public class GoblinDrop {

    private int[] dropLocation = {0, 0};
    private String dropItem;
    private boolean active;

    public GoblinDrop(int x, int y, String item, boolean active) {
        this.dropLocation[0] = x;
        this.dropLocation[1] = y;
        this.dropItem = item;
        this.active = active;
    }

    public String getDropItem() {
        return dropItem;
    }

    public int getDropLocationX() {
        return dropLocation[0];
    }

    public int getDropLocationY() {
        return dropLocation[1];
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        if(dropItem.equals("Additional Health")) return "& ";
        if(dropItem.equals("Speed Increase")) return "@ ";
        if(dropItem.equals("Power Up")) return "^ ";
        return null;
    }
}



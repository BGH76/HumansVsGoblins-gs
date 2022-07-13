package com.Houts;



public class Combat {

    int numberOfGoblinKills = 0;


    public int goblinAttacks(Human human, Goblin goblin) {
        return human.getHealth() - goblin.getStrength();
    }

    public int humanAttacks(int humanStrength, Goblin goblin) {
        return goblin.getHealth() - humanStrength;
    }

    // Returns the battle stats after each battle.
    public String battleStats(Human human, int weaponStreangth, Goblin goblin) {
        return "******** BATTLE STATS ********\n" +
                "       Player | Goblin\n" +
                "Hits:     " + human.getNumberOfSwings() + "   |   " + goblin.getNumberOfSwings() + "\n" +
                "Misses:   " + human.getNumberOfMisses() + "   |   " + goblin.getNumberOfMisses() +"\n" +
                "Health:   " + human.getHealth() + "   |   " + goblin.getHealth() + "\n" +
                "Strength: " + (human.getStrength() + weaponStreangth) + "   |   " + goblin.getStrength() +"\n" +
                "******************************\n";
    }

    public int getNumberOfGoblinKills() {
        return numberOfGoblinKills;
    }

    public void setNumberOfGoblinKills(int numberOfGoblinKills) {
        this.numberOfGoblinKills = numberOfGoblinKills;
    }
}

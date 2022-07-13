package com.Houts;

import java.util.ArrayList;

public class Land {
    private String[][] location = new String[10][10];

    // Displays the land and all humans, goblins, goblin drops, and treasure chest.
    public String displayLand (Human human, ArrayList<Goblin> goblins, ArrayList<GoblinDrop> goblinDrops, ArrayList<TreasureChest> treasureChest) {
        String land = "Health: " + human.getHealth() +"\nStrength: " + human.getStrength() + "\n" + "--------------------+\n";
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                location[i][j] = "  ";
                location[human.getHumanLocationY()][human.getHumanLocationX()] = human.toString();
                for (Goblin goblinTemp : goblins) {
                    location[goblinTemp.getGoblinLocationY()][goblinTemp.getGoblinLocationX()] = goblinTemp.toString();
                }
                for (GoblinDrop goblinDropTemp : goblinDrops) {
                    int goblinDropLocationXTemp = goblinDropTemp.getDropLocationX();
                    int goblinDropLocationYTemp = goblinDropTemp.getDropLocationY();
                    location[goblinDropLocationYTemp][goblinDropLocationXTemp] = goblinDropTemp.toString();
                }
                for(TreasureChest tc : treasureChest) {
                    location[tc.getTreasureLoc()[1]][tc.getTreasureLoc()[0]] = tc.toString();
                }
                if(j == 9) {
                    land += location[i][j] + "|\n";
                }
                else {
                    land += location[i][j];
                }
            }
        }
        land += "--------------------+";
        return land;
    }


}

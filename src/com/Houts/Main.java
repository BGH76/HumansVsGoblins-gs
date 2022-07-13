// Brian Houts
// Date: 7/13/2022
package com.Houts;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        Human human = new Human("Player", 100, 20);
        Combat combat = new Combat();
        Land land = new Land();
        ArrayList<Goblin> armyOfGoblins = new ArrayList<>();
        ArrayList<GoblinDrop> goblinDropsList = new ArrayList<>();
        ArrayList<TreasureChest> treasureChestList = new ArrayList<>();

        int numberOfRounds = 0;
        int additionalHealth = 0;
        int speedIncrease = 0;
        int powerUp = 0;
        boolean gameActive = true;

        System.out.println("\t\t\t\t\t=== Directions ===\n" +
                "Humans can move up, down, left, right by using the keys (w, s, a, d).\n" +
                "Goblins can move in eight directions up, down, left, right and diagonal\n" +
                "However, humans can port from one side of the map to the other and goblins cannot.\n" +
                "Goblins will always pursue humans. There can by multiple goblins active. Some goblins are" +
                "more powerful than others.\n" +
                "\n" +
                "Before each battle, the human can select a weapon. Caution: selecting some weapons can\n" +
                "cause a reduction in health if the player misses during an attack. During battle, the attacker\n" +
                "is chosen at random. During the attack, the attacker has a 1 in 3 chance of missing. After the attack\n" +
                "is played out, the next attacker is again, chosen at random. It's possible the goblin may attack you\n" +
                "multiple times in a row, or you may attack the goblin multiple times.\n" +
                "\n" +
                "Goblins will randomly drop enhancements on the map. Landing on the drop will grant a power up for a number\n" +
                "of rounds. After that number is up, the power enhancement will be removed. After a goblin is killed, a treasure chest\n" +
                "containing a random enhancement is dropped somewhere on the map. Collecting these treasures works the same as collecting\n" +
                "goblin drops. Some enhancements may simply restore  you health to full.\n" +
                "\n" +
                "After each battle, the Battle Stats are displayed which shows how many hits and misses there were in the battle, along\n" +
                "with health and strength. During the battle stats are also displayed in half second intervals. Goblin kills are recorded\n" +
                "and display after each game. The game is over when the  human (player) is killed by the goblins.\n" +
                "Good Luck and watch out for those Goblins!!!\n" +
                "Human = :{\n" +
                "Goblin = #" +
                "\n" +
                "<< Press Enter to Start >>");
        sc.nextLine();


        while(gameActive) {

            armyOfGoblins.removeIf(g -> !g.isAlive());
            goblinDropsList.removeIf(d -> !d.isActive());
            treasureChestList.removeIf(t -> !t.isActive());

            if(armyOfGoblins.size() < 1 || numberOfRounds == 10) {
                int[] health = {20, 50, 75, 100};
                int[] strength = {2, 10, 15, 20};
                int locationX = (int) (Math.random() * (9) + 1);
                int locationY = (int) (Math.random() * (9) + 1);
                int num = (int) (Math.random() * (4));
                armyOfGoblins.add(new Goblin(health[num], strength[num], null, locationY, locationX, true));
                numberOfRounds = 0;
            }

            System.out.println(land.displayLand(human, armyOfGoblins, goblinDropsList, treasureChestList));

            // ========== Player Move ==========
            System.out.println("Enter direction to move");
            try {
                String direction = sc.nextLine().toLowerCase();
                human.playerMove(direction);
            }catch(InputMismatchException i) {
                i.printStackTrace();
            }

            // ========== Decrement All Enhancements From Drops ==========
            if(additionalHealth > 0) {
                additionalHealth--;
                if(additionalHealth == 0) human.setHealth(100);
            }
            if(speedIncrease > 0) {
                speedIncrease--;
                if(speedIncrease == 0) human.setSpeed(1);
            }
            if(powerUp > 0) {
                powerUp--;
                if(powerUp == 0) human.setStrength(20);
            }
            if(human.getInvincibleCount() > 0) {
                human.setInvincibleCount(human.getInvincibleCount() - 1);;
                if(human.getInvincibleCount() == 0) human.setInvincible(false);
            }

            // ========== Goblin drops ==========
            if(goblinDropsList.size() < 2) {
                for(Goblin goblin : armyOfGoblins) {
                    GoblinDrop goblinDropTemp = goblin.goblinDrop();
                    if(goblinDropTemp != null) {
                        goblinDropsList.add((goblinDropTemp));
                    }
                }
            }

            // ========== Goblins move ==========
            for(Goblin g : armyOfGoblins) {
                g.setGoblinLocation(g.goblinMove(g.getGoblinLocation(), human.getHumanLocation()));
            }

            // ========== Goblin Drop PickUps ==========
            for(GoblinDrop item : goblinDropsList) {
                if(human.getHumanLocationX() == item.getDropLocationX() && human.getHumanLocationY() == item.getDropLocationY()) {
                    System.out.println("************************************ " + item.getDropItem());
                    item.setActive(false);
                    switch(item.getDropItem()) {
                        case "Additional Health":
                            if(additionalHealth == 0) {
                                additionalHealth = 10;
                                human.setHealth(human.getHealth() + 50);
                                break;
                            }
                        case "Speed Increase":
                            if(speedIncrease == 0) {
                                speedIncrease = 5;
                                human.setSpeed(2);
                                break;
                            }
                        case "Power Up":
                            if(powerUp == 0) {
                                powerUp = 3;
                                human.setStrength(human.getStrength() + 30);
                                break;
                            }
                    }
                }
            }

            // =========== Treasure Chest Pickups ==========
            for(TreasureChest tc : treasureChestList) {
                if(tc.getLocationX() == human.getHumanLocationX() && tc.getLocationY() == human.getHumanLocationY()) {
                    System.out.println("********************** You found some treasure (" + tc.getDropItem() + ") *********************************");
                    tc.setActive(false);
                    switch(tc.getDropItem()) {
                        case "Full Health":
                            human.setHealth(100);
                            tc.setActive(false);
                            break;
                        case "Enhanced Strength":
                            human.setStrength(human.getStrength() + 2);
                            tc.setActive(false);
                            break;
                        case "Invincible":
                            human.setInvincible(true);
                            human.setInvincibleCount(10);
                            tc.setActive(false);
                            break;
                    }
                }
            }

            // ========== Goblin and Human Collide -> Start Battle ==========
            for(Goblin goblinCurrent : armyOfGoblins) {
                if (goblinCurrent.getGoblinLocationX() == human.getHumanLocationX() && goblinCurrent.getGoblinLocationY() == human.getHumanLocationY() && goblinCurrent.isAlive()) {

                    // ========== Setup Human For Battle ==========
                    System.out.println("*************** Lets Battle ***************\n" +
                            human.weapon.getWeaponsList() + "\n" +
                            "Select your weapon");
                    try {
                        int weaponSelection;
                        do {
                            weaponSelection = sc.nextInt();
                        } while(weaponSelection != 1 && weaponSelection != 2 && weaponSelection != 3);
                        int humansFightingStrength = human.getStrength() + human.weapon.selectWeapon(weaponSelection);
                        sc.nextLine();

                        // ========== START BATTLE ==========
                        while (human.getHealth() > 0 || goblinCurrent.getHealth() > 0) {
                            // === human and goblin stats display ===
                            System.out.println("Human health: " + human.getHealth() + " | Goblin Health: " + goblinCurrent.getHealth());
                            System.out.println("Human strength: " + humansFightingStrength + " | Goblin strength: " + goblinCurrent.getStrength());
                            System.out.println("\n");

                            // ========== Who Is Attacking (50/50 chance) ==========
                            int whoIsAttacking = (int) (Math.random() * (2) + 1); // Should return 1 or 2
                            System.out.println(whoIsAttacking == 1 ? "Player is attacking" : "Goblin is attacking");

                            // ========== Chance For A Miss (1 in 3) ==========
                            int attackerMisses = (int) (Math.random() * 3 + 1);
                            if (attackerMisses == 2) {
                                System.out.println(whoIsAttacking == 1 ? "Player Misses" : "Goblin Misses");
                                if (whoIsAttacking == 1 && !human.isInvincible()) {
                                    human.setHealth(human.getHealth() - human.weapon.selectWeapon(weaponSelection));
                                    human.setNumberOfMisses(human.getNumberOfMisses() + 1);
                                } else {
                                    goblinCurrent.setNumberOfMisses(goblinCurrent.getNumberOfMisses() + 1);
                                }

                                // ========== Hit ==========
                            } else {
                                if (whoIsAttacking == 1) {
                                    goblinCurrent.setHealth(combat.humanAttacks(humansFightingStrength, goblinCurrent));
                                    human.setNumberOfSwings(human.getNumberOfSwings() + 1);
                                }
                                if (whoIsAttacking == 2 && !human.isInvincible()) {
                                    human.setHealth(combat.goblinAttacks(human, goblinCurrent));
                                    goblinCurrent.setNumberOfSwings(goblinCurrent.getNumberOfSwings() + 1);
                                }

                                // ========== CHECK FOR WIN ==========
                                if (human.getHealth() <= 0) {
                                    System.out.println("Goblin wins\n" +
                                            "Game Over!\n" +
                                            "You killed " + combat.getNumberOfGoblinKills() + " Goblins!");
                                    gameActive = false;
                                    break;
                                }
                                if (goblinCurrent.getHealth() <= 0) {
                                    System.out.println("Human wins");
                                    goblinCurrent.setAlive(false);
                                    combat.setNumberOfGoblinKills(combat.getNumberOfGoblinKills() + 1);
                                    // ========== Drop Treasure Chest After Win ==========
                                    int treasureLocX = (int) (Math.random() * 9 + 1);
                                    int treasureLocY = (int) (Math.random() * 9 + 1);
                                    int treasureItem = (int) (Math.random() * 3);
                                    treasureChestList.add(new TreasureChest(treasureLocX, treasureLocY, treasureItem, true));
                                    break;
                                }
                            }

                            Thread.sleep(500);
                        }
                        // ========== END BATTLE ==========

                        // ========== Display Battle Stats ==========
                        System.out.println(combat.battleStats(human, human.weapon.selectWeapon(weaponSelection), goblinCurrent));
                        human.resetBattleStats();
                    } catch (InputMismatchException i) {
                        System.out.println("Enter a valid number");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            human.regenerateHealth();
            numberOfRounds++;
        } // End of main game loop
    }
}

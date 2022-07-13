package com.Houts;

public class HumanWeapon {

    public HumanWeapon() {

    }

    public String getWeaponsList() {
        return "\t\t\t*** Weapons List ***\n" +
                "1) Fist -  Increases strength by 0 and reduces health by 0 for missed swings\n" +
                "2) Sword - Increases strength by 7 but reduces health by 7 for all missed swings\n" +
                "3) Axe - Increases strength by 9 but reduces health by 9 for all missed swings\n";
    }


    public int selectWeapon(int weapon) {
        switch(weapon) {
            case 1:
                return 0; // Fist
            case 2:
                return 7; // Sword
            case 3:
                return 9; // Axe
        }
        return 0;
    }


}

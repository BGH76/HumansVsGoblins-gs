package com.Houts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HumanWeaponTest {

    @Test
    void selectWeapon() {
        HumanWeapon hw = new HumanWeapon();

        assertEquals(0, hw.selectWeapon(1));
        assertEquals(7, hw.selectWeapon(2));
        assertEquals(9, hw.selectWeapon(3));
    }
}
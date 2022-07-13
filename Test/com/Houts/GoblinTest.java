package com.Houts;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class GoblinTest {

    Human human;
    Goblin goblin;

    @BeforeEach
    void setUp() {
        human = new Human("Player", 100, 20);
        goblin = new Goblin(100, 20, null, 1, 1, true);
    }

    @Test
    void goblinMoveUpAndLeft() {
        human.setHumanLocationX(0);
        human.setHumanLocationY(0);
        goblin.setGoblinLocationX(1);
        goblin.setGoblinLocationY(1);
        goblin.goblinMove(goblin.getGoblinLocation(), human.getHumanLocation());

        assertEquals(0, goblin.getGoblinLocationX());
        assertEquals(0, goblin.getGoblinLocationY());
    }

    @Test
    void goblinMoveUpAndRight() {
        human.setHumanLocationX(9);
        human.setHumanLocationY(0);
        goblin.setGoblinLocationX(0);
        goblin.setGoblinLocationY(9);
        goblin.goblinMove(goblin.getGoblinLocation(), human.getHumanLocation());

        assertEquals(1, goblin.getGoblinLocationX());
        assertEquals(8, goblin.getGoblinLocationY());
    }

    @Test
    void goblinMoveDownAndLeft() {
        human.setHumanLocationX(5);
        human.setHumanLocationY(5);
        goblin.setGoblinLocationX(6);
        goblin.setGoblinLocationY(4);
        goblin.goblinMove(goblin.getGoblinLocation(), human.getHumanLocation());

        assertEquals(5, goblin.getGoblinLocationX());
        assertEquals(5, goblin.getGoblinLocationY());
    }

    @Test
    void goblinMoveDownAndRight() {
        human.setHumanLocationX(5);
        human.setHumanLocationY(5);
        goblin.setGoblinLocationX(4);
        goblin.setGoblinLocationY(4);
        goblin.goblinMove(goblin.getGoblinLocation(), human.getHumanLocation());

        assertEquals(5, goblin.getGoblinLocationX());
        assertEquals(5, goblin.getGoblinLocationY());
    }

    @Test
    void goblinMoveUp() {
        human.setHumanLocationX(5);
        human.setHumanLocationY(5);
        goblin.setGoblinLocationX(5);
        goblin.setGoblinLocationY(6);
        goblin.goblinMove(goblin.getGoblinLocation(), human.getHumanLocation());

        assertEquals(5, goblin.getGoblinLocationX());
        assertEquals(5, goblin.getGoblinLocationY());
    }

    @Test
    void goblinMoveDown() {
        human.setHumanLocationX(5);
        human.setHumanLocationY(5);
        goblin.setGoblinLocationX(5);
        goblin.setGoblinLocationY(4);
        goblin.goblinMove(goblin.getGoblinLocation(), human.getHumanLocation());

        assertEquals(5, goblin.getGoblinLocationX());
        assertEquals(5, goblin.getGoblinLocationY());
    }

    @Test
    void goblinMoveLeft() {
        human.setHumanLocationX(5);
        human.setHumanLocationY(5);
        goblin.setGoblinLocationX(6);
        goblin.setGoblinLocationY(5);
        goblin.goblinMove(goblin.getGoblinLocation(), human.getHumanLocation());

        assertEquals(5, goblin.getGoblinLocationX());
        assertEquals(5, goblin.getGoblinLocationY());
    }

    @Test
    void goblinMoveRight() {
        human.setHumanLocationX(9);
        human.setHumanLocationY(5);
        goblin.setGoblinLocationX(3);
        goblin.setGoblinLocationY(5);
        goblin.goblinMove(goblin.getGoblinLocation(), human.getHumanLocation());

        assertEquals(4, goblin.getGoblinLocationX());
        assertEquals(5, goblin.getGoblinLocationY());
    }

}
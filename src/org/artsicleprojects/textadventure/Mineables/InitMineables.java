package org.artsicleprojects.textadventure.Mineables;

public class InitMineables {
    public static Rock ROCK;
    public InitMineables() {
        init();
        register();
    }

    private void init() {
        ROCK = new Rock();
    }
    private void register() {
        MineableRegistry.registerMineables(
                ROCK
        );
    }
}

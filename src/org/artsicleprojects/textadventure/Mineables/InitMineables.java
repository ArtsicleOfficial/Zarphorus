package org.artsicleprojects.textadventure.Mineables;

public class InitMineables {
    public static Rock ROCK;
    public static IronDeposit IRON_DEPOSIT;
    public static CopperDeposit COPPER_DEPOSIT;
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

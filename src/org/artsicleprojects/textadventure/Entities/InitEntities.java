package org.artsicleprojects.textadventure.Entities;



public class InitEntities
{
    public static Pig PIG;
    public static Cow COW;
    public static Chicken CHICKEN;
    public static Rabbit RABBIT;
    public static Goblin GOBLIN;
    public InitEntities() {
        init();
        register();
    }
    public void init() {
        PIG = new Pig();
        COW = new Cow();
        CHICKEN = new Chicken();
        RABBIT = new Rabbit();
        GOBLIN = new Goblin();
    }
    public void register() {
        EntityRegistry.registerEntities(
                PIG,
                COW,
                GOBLIN,
                CHICKEN,
                RABBIT
        );
    }
}

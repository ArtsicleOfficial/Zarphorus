package org.artsicleprojects.textadventure.Entities;



public class InitEntities
{
    public Pig pig;
    public Cow cow;
    public Chicken chicken;
    public Rabbit rabbit;
    public InitEntities() {
        init();
        register();
    }
    public void init() {
        pig = new Pig();
        cow = new Cow();
        chicken = new Chicken();
        rabbit = new Rabbit();
    }
    public void register() {
        EntityRegistry.registerEntities(
                pig,
                cow,
                chicken,
                rabbit
        );
    }
}

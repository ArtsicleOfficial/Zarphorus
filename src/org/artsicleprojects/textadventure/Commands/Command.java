package org.artsicleprojects.textadventure.Commands;

public interface Command
{
    public String[] getCommand();
    public boolean commandPerformed(String[] args);
    public String getCommandFailMessage();
    public String getHelpMessage();

    public boolean isGameInteractionCommand();
    public boolean canUseIfDead();
}

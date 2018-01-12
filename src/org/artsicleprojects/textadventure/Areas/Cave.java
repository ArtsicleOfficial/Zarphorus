package org.artsicleprojects.textadventure.Areas;

import org.artsicleprojects.textadventure.Commands.Game;
import org.artsicleprojects.textadventure.Enums.AreaClasses;
import org.artsicleprojects.textadventure.Enums.GameMessages;
import org.artsicleprojects.textadventure.Enums.ItemClasses;
import org.artsicleprojects.textadventure.Player;

public class Cave implements Area {
    @Override
    public String getName() {
        return "Cave";
    }

    @Override
    public AreaClasses getAreaClass() {
        return AreaClasses.CAVE;
    }

    @Override
    public void whenWalkedIn() {
        if(!Player.inventoryHasItem(ItemClasses.LANTERN)) {
            GameMessages.loseHealth.Reset();
            GameMessages.loseHealth.SetLoss(10f);
            GameMessages.loseHealth.PrintMessage();
            GameMessages.tooDark.Reset();
            GameMessages.tooDark.PrintMessage();
            Player.removePlayerHealth(10);
        }
    }

    @Override
    public boolean isDefault() {
        return false;
    }
}

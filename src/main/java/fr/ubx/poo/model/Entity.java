package fr.ubx.poo.model;

import fr.ubx.poo.game.Game;
import fr.ubx.poo.game.Position;
import fr.ubx.poo.model.go.character.Monster;
import fr.ubx.poo.model.go.character.Player;

public abstract class Entity {
    /**
     * @param player object player
     * @return true if player can walk on
     */
    public abstract boolean canWalkOn (Player player) ;
  
    /**
     * @param monster object monster
     * @return true if monster can walk on
     */
    public abstract boolean canWalkOn (Monster monster) ;
    /**
     * handles the effects of a player walking on a Entity
     * @param player
     * @param game
     * @param pos
     */
    public abstract void action (Player player, Game game, Position pos) ;
}

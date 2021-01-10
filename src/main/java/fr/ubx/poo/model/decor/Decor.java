/*
 * Copyright (c) 2020. Laurent Réveillère
 */

package fr.ubx.poo.model.decor;

import fr.ubx.poo.game.Game;
import fr.ubx.poo.game.Position;
import fr.ubx.poo.model.Entity;
import fr.ubx.poo.model.go.character.Monster;
import fr.ubx.poo.model.go.character.Player;

/***
 * A decor is an element that does not know its own position in the grid.
 */
public class Decor extends Entity {
    /**
     * @param player object player
     * @return true if player can walk on
     */
    public boolean canWalkOn (Player player){
        return false ;
    }

    /**
     * @param monster object monster
     * @return true if monster can walk on
     */
    public boolean canWalkOn (Monster monster){
        return false ;
    }

    /**
     * handles the effects of a player walking on decor elements
     * @param player
     * @param game
     * @param pos
     */
    public void action (Player player, Game game, Position pos) {}

    /**
     * handles the destruction of decor elements when close to a bomb
     * @param game
     * @param pos
     * @param level
     * @return true in case a decor element was destroyed
     */
    public boolean destroy (Game game,Position pos,int level) {return false ;}
}

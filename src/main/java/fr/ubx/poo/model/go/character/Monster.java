package fr.ubx.poo.model.go.character;

import fr.ubx.poo.game.Direction;
import fr.ubx.poo.game.Game;
import fr.ubx.poo.game.Position;
import fr.ubx.poo.model.Movable;
import fr.ubx.poo.model.decor.Decor;
import fr.ubx.poo.model.decor.DoorNextOpened;
import fr.ubx.poo.model.decor.DoorPrevOpened;
import fr.ubx.poo.model.go.GameObject;

public class Monster extends GameObject implements Movable {

    private long timer = 0;
    Direction direction;

    public Monster(Game game, Position position){
        super(game,position) ;
        this.direction = Direction.S;
    }

    public void action (Player player, Game game, Position pos){
        player.setLives (player.getLives() - 1);
    }

    public Direction getDirection() {
        return direction;
    }

    @Override
    public boolean canMove(Direction direction) {
        Position newPositon = direction.nextPosition(getPosition());
        if (newPositon.inside(this.game.getWorld().dimension)) {
            Decor decor = this.game.getWorld().get(newPositon);
            if (this.game.getMonsters().contains(new Monster(this.game, newPositon))) {
                    return false;
            } else if (decor == null) {
                return true;
            } else return decor.canWalkOn(this.game.getPlayer())
                    && !(decor instanceof DoorPrevOpened)
                    && !(decor instanceof DoorNextOpened);
        }
        return false;
    }

    @Override
    public void doMove(Direction direction) {
        if (canMove(direction)) {
            Position newPositon = direction.nextPosition(getPosition());
            this.setPosition(newPositon);
        }
    }

    public void update(long now) {
        if (this.canMove(Direction.S) ||
                this.canMove(Direction.N) ||
                this.canMove(Direction.E) ||
                this.canMove(Direction.W)) {
            if ((now - this.timer) >= Math.pow(10, 9) / (1 + this.game.getLevel())) {
                this.timer = now;
                do {
                    int dir = (int) (Math.random() * 4);
                    switch (dir) {
                        case 0 -> this.direction = Direction.S;
                        case 1 -> this.direction = Direction.N;
                        case 2 -> this.direction = Direction.E;
                        default -> this.direction = Direction.W;
                    }
                } while (!this.canMove(this.direction));
                this.doMove(this.direction);
                if (this.getPosition().equals(this.game.getPlayer().getPosition())) {
                    this.action(this.game.getPlayer(), this.game, this.getPosition());
                }
            }
        }
    }
}

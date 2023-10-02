package academy.pocu.comp2500.lab5;

import java.util.ArrayList;

public class Gladiator extends Barbarian {

    ArrayList<Move> moves;

    public Gladiator(String name, int hp, int attack, int defense) {
        super(name, hp, attack, defense);
        moves = new ArrayList<>();
    }

    public boolean addMove(Move move) {
        if (this.moves.size() == 4 || hasMove(move.getMoveName())) {
            return false;
        }

        moves.add(move);
        return true;
    }
    public boolean removeMove(String moveName) {
        int size = this.moves.size();
        for (int i = 0; i < size; ++i) {
            if (moves.get(i).getMoveName().equals(moveName)) {
                moves.remove(i);
                return true;
            }
        }
        return false;
    }

    public void attack(String moveName, Barbarian other) {
        if (!hasMove(moveName)) {
            return;
        }

        Move move = null;
        for (Move m : moves) {
            if (m.getMoveName().equals(moveName)) {
                move = m;
                break;
            }
        }
        assert (move != null);
        int damage = (int)(this.getAttack() / (double)(other.getDefense()) * move.getMovePower() / 2.0);
        damage = damage < 1 ? 1 : damage;

        calculateHp(other, damage);
    }

    public void rest() {
        this.hp += 10;
        for (Move m : moves) {
            m.recoverMoveCount();
        }
    }

    private boolean hasMove(String moveName) {
        for (Move m : moves) {
            if (m.getMoveName().equals(moveName)) {
                return true;
            }
        }
        return false;
    }
}
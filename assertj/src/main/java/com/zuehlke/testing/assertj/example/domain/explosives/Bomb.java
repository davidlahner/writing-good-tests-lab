package com.zuehlke.testing.assertj.example.domain.explosives;

public abstract class Bomb {


    public static Bomb create() {
        return new DisarmedBomb();
    }

    public abstract void shake();

    public abstract Bomb armed();

    public abstract Bomb disarmed();


    static class ArmedBomb extends Bomb {

        public void shake() {
            throw new BombExploded("Boom!", new OxyhydrogenExplosion());
        }

        public Bomb armed() {
            return this;
        }

        public Bomb disarmed() {
            return new DisarmedBomb();
        }

    }

    static class DisarmedBomb extends Bomb {

        public void shake() {
            // Don't explode, I'm disarmed.
        }

        public Bomb armed() {
            return new ArmedBomb();
        }

        public Bomb disarmed() {
            return this;
        }
    }
}

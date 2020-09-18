package com.zuehlke.testing.assertj.example.domain.explosives;

public class BombExploded extends RuntimeException {

    public BombExploded(String message, Throwable cause) {
        super(message, cause);
    }

    public BombExploded(String message) {
        this(message, null);
    }

    public String explosives() {
        if (getCause() != null && getCause() instanceof OxyhydrogenExplosion) {
            return "Oxyhydrogen";
        } else {
            return "Unknown";
        }
    }

}

package com.zuehlke.testing.assertj.example.testCapabilities.assertj.assertions;

import com.zuehlke.testing.assertj.example.domain.explosives.BombExploded;
import org.assertj.core.api.Condition;

public interface ExplosivesTestHabits {

    default Condition<? super Throwable> havingExplosives(String expected) {
        return new Condition<>(thrown -> ((BombExploded) thrown).explosives().equals(expected), "having explosives <%s>", expected);
    }
}

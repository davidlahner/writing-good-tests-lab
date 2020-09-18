package com.zuehlke.testing.assertj.example.testCapabilities.assertj.assertions;

import com.zuehlke.testing.assertj.example.domain.events.Event;
import org.assertj.core.api.Condition;

public interface EventTestHabits {


    default Condition<Event> eventOfType(Class<? extends Event> expectedType) {
        return new Condition<>((Event anEvent) -> expectedType.isAssignableFrom(anEvent.getClass()),
                "event of type <%s>", expectedType.getSimpleName());
    }

}

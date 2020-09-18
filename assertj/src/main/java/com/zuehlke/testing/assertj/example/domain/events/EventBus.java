package com.zuehlke.testing.assertj.example.domain.events;

import java.util.Collections;
import java.util.List;

public class EventBus {

    public void send(Event anEvent) {
    }

    public List<Event> events() {
        return Collections.singletonList(new SomethingGoodHappened());
    }
}

package com.zuehlke.testing.junit5.exercises;

public class FruitMapper {

    public ServerFruit mapToServer(ClientFruit clientFruit) {
        return ServerFruit.valueOf(clientFruit.name());
    }
}

package com.zuehlke.testing.junit5;

public class FlavorMapper {

    public ServerFlavor mapToServer(final ClientFlavor clientFlavor) {
        return ServerFlavor.valueOf(clientFlavor.name());
    }
}

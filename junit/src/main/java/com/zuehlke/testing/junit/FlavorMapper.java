package com.zuehlke.testing.junit;

public class FlavorMapper {

    public ServerFlavor mapToServer(final ClientFlavor clientFlavor) {
        return ServerFlavor.valueOf(clientFlavor.name());
    }
}

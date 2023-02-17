package com.zuehlke.testing.junit5.examples.dynamic;

import com.zuehlke.testing.junit5.ClientFlavor;
import com.zuehlke.testing.junit5.FlavorMapper;
import com.zuehlke.testing.junit5.ServerFlavor;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class FlavorMapperTest {

    @TestFactory
    Stream<DynamicTest> testCases() {
        final FlavorMapper testee = new FlavorMapper();
        final Set<ServerFlavor> targetFlavors = new HashSet<>(Arrays.asList(ServerFlavor.values()));

        return Stream.concat(Arrays.stream(ClientFlavor.values())
                .map(clientFlavor -> dynamicTest(format("GIVEN %s WHEN map THEN map to same value", clientFlavor),
                        () -> {
                    final ServerFlavor actual = testee.mapToServer(clientFlavor);
                    assertThat(targetFlavors.remove(actual)).isTrue();
                        })
                ),
                Stream.of(dynamicTest("Assert every flavor has been mapped once",
                        () -> assertThat(targetFlavors).isEmpty()))
                );
    }
}
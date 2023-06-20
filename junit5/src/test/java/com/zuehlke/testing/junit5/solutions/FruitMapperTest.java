package com.zuehlke.testing.junit5.solutions;

import com.zuehlke.testing.junit5.exercises.ClientFruit;
import com.zuehlke.testing.junit5.exercises.FruitMapper;
import com.zuehlke.testing.junit5.exercises.ServerFruit;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class FruitMapperTest {

    @TestFactory
    Stream<DynamicTest> testCases() {
        final FruitMapper testee = new FruitMapper();
        final Set<ServerFruit> targetFruits = new HashSet<>(Arrays.asList(ServerFruit.values()));

        return Stream.concat(Arrays.stream(ClientFruit.values())
                        .map(clientFruit -> dynamicTest(format("GIVEN %s WHEN map THEN map to same value", clientFruit),
                                () -> {
                                    final ServerFruit actual = testee.mapToServer(clientFruit);
                                    assertThat(targetFruits.remove(actual)).isTrue();
                                })
                        ),
                Stream.of(dynamicTest("Assert every Fruit has been mapped once",
                        () -> assertThat(targetFruits).isEmpty()))
        );
    }

}
package com.zuehlke.testing.coverage.solution;

import com.zuehlke.testing.coverage.example.CoverageExampleFromSlide;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class CoverageExampleFromSlideMultipleConditionCoverageTest {

    private CoverageExampleFromSlide testee = new CoverageExampleFromSlide();

    @Test
    void testIsShopOpen_9amVip_open() {
        // act
        boolean result = testee.isShopOpen(LocalTime.of(9, 00), true);

        // assert
        assertThat(result, is(true));
    }

    @Test
    void testIsShopOpen_8amNotVip_notOpen() {
        // act
        boolean result = testee.isShopOpen(LocalTime.of(8, 00), false);

        // assert
        assertThat(result, is(false));
    }

    @Test
    void testIsShopOpen_8amVip_open() {
        // act
        boolean result = testee.isShopOpen(LocalTime.of(8, 00), true);

        // assert
        assertThat(result, is(true));
    }

    @Test
    void testIsShopOpen_7pmNotVip_notOpen() {
        // act
        boolean result = testee.isShopOpen(LocalTime.of(19, 00), false);

        // assert
        assertThat(result, is(false));
    }
}

package com.zuehlke.testing.coverage.solution;

import com.zuehlke.testing.coverage.example.CoverageExampleFromSlide;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

class CoverageExampleFromSlideBranchCoverageTest {

    private final CoverageExampleFromSlide testee = new CoverageExampleFromSlide();

    @Test
    void testIsShopOpen_vip_open() {
        // act
        boolean result = testee.isShopOpen(LocalTime.of(9, 00), true);

        // assert
        assertThat(result).isTrue();
    }

    @Test
    void testIsShopOpen_8am_notOpen() {
        // act
        boolean result = testee.isShopOpen(LocalTime.of(8, 00), false);

        // assert
        assertThat(result).isFalse();
    }

}

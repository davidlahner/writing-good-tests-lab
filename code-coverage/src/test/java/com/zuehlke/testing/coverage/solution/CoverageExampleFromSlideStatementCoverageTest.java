package com.zuehlke.testing.coverage.solution;

import com.zuehlke.testing.coverage.example.CoverageExampleFromSlide;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.assertj.core.api.Assertions.assertThat;

class CoverageExampleFromSlideStatementCoverageTest {

    private CoverageExampleFromSlide testee = new CoverageExampleFromSlide();

    @Test
        // Achieves 100% statement coverage
    void testIsShopOpen_vip_open() {
        // act
        boolean result = testee.isShopOpen(LocalTime.of(9, 00), true);

        // assert
        assertThat(result).isTrue();
    }
}

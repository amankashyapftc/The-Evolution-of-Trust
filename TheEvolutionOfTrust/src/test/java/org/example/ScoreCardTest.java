package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreCardTest {
    @Test
    public void testAbleToCreateANewScoreCard(){
        assertDoesNotThrow(()->new ScoreCard());
    }
}
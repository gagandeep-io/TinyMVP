package com.android.g19.tinymvp.sample.data;

import java.util.Random;

/**
 * Created by gagandeep on 30/6/16.
 */

public final class PuzzleGenerator {

    private Random mExpectedResultRandom;
    private Random mFirstRandom;

    public PuzzleGenerator() {
        mExpectedResultRandom = new Random(100);
    }

    public void generate(int[] result) {
        if (result == null || result.length <= 1) {
            throw new IllegalStateException("No appropriate array size");
        }

        int expectedResult = mExpectedResultRandom.nextInt();
        if (mFirstRandom == null) {
            mFirstRandom = new Random(expectedResult);
        }

        int first = mFirstRandom.nextInt();
        result[0] = 5;
        result[1] = 8;
    }
}

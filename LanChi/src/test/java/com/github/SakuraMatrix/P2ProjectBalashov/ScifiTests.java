package com.github.SakuraMatrix.P2ProjectBalashov;

import com.intuit.karate.junit5.Karate;

class ScifiTests {
    @Karate.Test
    Karate testAll() {
        return Karate.run().relativeTo(getClass());
    }

}

package com.github.SakuraMatrix.P2ProjectBalashov.karate;

import com.intuit.karate.junit5.Karate;

public class ScifiRunner {
    @Karate.Test
    Karate runDojos(){
        return Karate.run().relativeTo(getClass());
    }
}
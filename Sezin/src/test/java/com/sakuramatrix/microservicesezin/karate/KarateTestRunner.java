package com.sakuramatrix.microservicesezin.karate;

import com.intuit.karate.junit5.Karate;

public class KarateTestRunner {
    @Karate.Test
    Karate runKarateTest(){
        return Karate.run().relativeTo(getClass());
    }
}
package com.github.Balashov.Lane.service;

import com.intuit.karate.junit5.Karate;

public class ItemServiceRunner {
    @Karate.Test
    Karate testAll(){
        return Karate.run().relativeTo(getClass());
    }
}
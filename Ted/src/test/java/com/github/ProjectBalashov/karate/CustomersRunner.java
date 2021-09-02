package com.github.ProjectBalashov.karate;

import com.intuit.karate.junit5.Karate;

public class CustomersRunner {
    @Karate.Test
    Karate runDojos(){
        return Karate.run().relativeTo(getClass());
    }
}
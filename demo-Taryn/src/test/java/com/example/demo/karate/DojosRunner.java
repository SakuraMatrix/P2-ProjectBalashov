package com.example.demo.karate;

import com.intuit.karate.junit5.Karate;

public class DojosRunner {
    @Karate.Test
    Karate runDojos(){
        return Karate.run().relativeTo(getClass());
    }
}
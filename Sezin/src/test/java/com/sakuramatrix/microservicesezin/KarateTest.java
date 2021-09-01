package com.sakuramatrix.microservicesezin;

import com.intuit.karate.junit5.Karate;

public class KarateTest {
  //karatetest.feature file runs good by itself but when I run it within this class it can`t find the .feature file.A bug to fix later.
 @Karate.Test
    Karate testAll(){return Karate.run().relativeTo(getClass()); }
}

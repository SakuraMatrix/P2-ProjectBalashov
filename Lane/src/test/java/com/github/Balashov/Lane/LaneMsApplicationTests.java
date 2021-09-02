package com.github.Balashov.Lane;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.intuit.karate.junit5.Karate;

//@SpringBootTest
class LaneMsApplicationTests {

/*    @Test
    void contextLoads() {
    }*/

    @Karate.Test
    Karate testAll() {
        return Karate.run().relativeTo(getClass());
    }

}

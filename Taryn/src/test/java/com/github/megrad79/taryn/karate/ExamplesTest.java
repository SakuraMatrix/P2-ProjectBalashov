package com.github.megrad79.taryn.karate;

import com.intuit.karate.junit5.Karate;

public class ExamplesTest {

    @Karate.Test
    Karate testAll() {
        return Karate.run().relativeTo(getClass());
    }

   /* @Karate.Test
    Karate testTags() {
        return Karate.run("tags").tags("@second").relativeTo(getClass());
    }

    @Karate.Test
    Karate testSystemProperty(){
        return Karate.run("classpath:karate/users.feature")
                .tags("@second").karateEnv("e2e").systemProperty("foo","bar");
    }*/
}

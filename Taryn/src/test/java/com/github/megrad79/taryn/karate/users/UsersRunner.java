package com.github.megrad79.taryn.karate.users;

import com.intuit.karate.junit5.Karate;

public class UsersRunner {
    @Karate.Test
    Karate runUsers(){
        return Karate.run().relativeTo(getClass());
    }
}
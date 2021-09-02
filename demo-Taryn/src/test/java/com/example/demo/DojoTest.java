package com.example.demo;

import com.intuit.karate.junit5.Karate;

class DojoTest {

	@Karate.Test
	Karate testAll() {
		return Karate.run().relativeTo(getClass());
	}

}

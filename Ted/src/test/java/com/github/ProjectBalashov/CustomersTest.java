package com.github.ProjectBalashov;

import com.intuit.karate.junit5.Karate;

class CustomersTest {

	@Karate.Test
	Karate testAll() {
		return Karate.run().relativeTo(getClass());
	}

}

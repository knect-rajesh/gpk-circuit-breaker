/**
 * 
 */
package com.gpk.rajesh.spring.bookstore;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * 
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookstoreApplicationTest {

	@Autowired
	private WebTestClient webTestClient;

	/**
	 * Test method for
	 * {@link com.gpk.rajesh.spring.bookstore.BookstoreApplication#readingList()}.
	 */
	@Test
	void testReadingList() {
		webTestClient.get().uri("/recommended").exchange().expectStatus().isOk().expectBody(String.class).value(m -> m
				.equals("Spring in Action (Manning), Cloud Native Java (O'Reilly), Learning Spring Boot (Packt)"));
	}

}

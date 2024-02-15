package com.gpk.rajesh.spring.bookstore.reading;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

@Ignore
@RunWith(SpringRunner.class)
@RestClientTest(BookService.class)
class BookServiceTests {

	@Autowired
	private BookService bookService;

	@Autowired
	private MockRestServiceServer server;

	@Test
	void testReadingList() {
		this.server.expect(requestTo("http://localhost:8090/recommended"))
				.andRespond(withSuccess("books", MediaType.TEXT_PLAIN));
		assertThat(bookService.readingList()).isEqualTo("books");
	}

}

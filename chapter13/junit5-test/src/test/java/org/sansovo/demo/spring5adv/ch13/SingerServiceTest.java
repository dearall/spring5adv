package org.sansovo.demo.spring5adv.ch13;

import org.junit.jupiter.api.*;
import org.sansovo.demo.spring5adv.ch13.config.DataConfig;
import org.sansovo.demo.spring5adv.ch13.config.ServiceConfig;
import org.sansovo.demo.spring5adv.ch13.config.SimpleTestConfig;
import org.sansovo.demo.spring5adv.ch13.entities.Singer;
import org.sansovo.demo.spring5adv.ch13.services.SingerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Created by iuliana.cosmina on 6/25/17.
 */
@SpringJUnitConfig(classes = {SimpleTestConfig.class, ServiceConfig.class, DataConfig.class})
@DisplayName("Integration SingerService Test")
@ActiveProfiles("test")
public class SingerServiceTest {

	private static Logger logger = LoggerFactory.getLogger(SingerServiceTest.class);

	@Autowired
	SingerService singerService;

	@BeforeAll
	static void setUp() {
		logger.info("--> @BeforeAll - executes before executing all test methods in this class");
	}

	@AfterAll
	static void tearDown(){
		logger.info("--> @AfterAll - executes before executing all test methods in this class");
	}

	@BeforeEach
	void init() {
		logger.info("--> @BeforeEach - executes before each test method in this class");
	}

	@AfterEach
	void dispose() {
		logger.info("--> @AfterEach - executes after each test method in this class");
	}

	@Test
	@DisplayName("should return all singers")
	@SqlGroup({
			@Sql(value = "classpath:db/test-data.sql",
					config = @SqlConfig(encoding = "utf-8", separator = ";", commentPrefix = "--"),
					executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
			@Sql(value = "classpath:db/clean-up.sql",
					config = @SqlConfig(encoding = "utf-8", separator = ";", commentPrefix = "--"),
					executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD),
	})
	public void testFindAll() {
		List<Singer> result = singerService.findAll();
		assertNotNull(result);
		assertEquals(1, result.size());
	}

	@Test
	@DisplayName("should return singer 'John Mayer'")
	@SqlGroup({
			@Sql(value = "classpath:db/test-data.sql",
					config = @SqlConfig(encoding = "utf-8", separator = ";", commentPrefix = "--"),
					executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
			@Sql(value = "classpath:db/clean-up.sql",
					config = @SqlConfig(encoding = "utf-8", separator = ";", commentPrefix = "--"),
					executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD),
	})
	public void testFindByFirstNameAndLastNameOne() throws Exception {
		System.out.println("singerService: " + singerService);
		Singer result = singerService.findByFirstNameAndLastName("John", "Mayer");
		assertNotNull(result);
	}
}

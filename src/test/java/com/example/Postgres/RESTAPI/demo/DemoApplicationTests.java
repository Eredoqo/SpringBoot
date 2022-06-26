package com.example.Postgres.RESTAPI.demo;

import com.example.Postgres.RESTAPI.demo.entities.Spid;
import com.example.Postgres.RESTAPI.demo.entities.User;
import com.example.Postgres.RESTAPI.demo.service.SpidService;
import com.example.Postgres.RESTAPI.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {PostgresRestApiApplication.class})
class SpringBootDemoApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private SpidService spidService;

	@Test
	void test() {
		try {
			System.out.println(userService.getUserById(1L));
			User user = userService.updateUser(new User(), 1L);
			System.out.println(userService.getUserById(1L));

			Spid spid = spidService.createSpid(new Spid());
			System.out.println(spidService.findSpidById(user.getId()));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
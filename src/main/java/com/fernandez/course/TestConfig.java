package com.fernandez.course;


import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.fernandez.course.entities.Order;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	

	@Override
	public void run(String... args) throws Exception {
		User  u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888898", "123456");
		User  u2 = new User(null, "Alex Green", "alex@gmail.com", "999998888", "654321");
		
		
		Order o1 = new Order(null, Instant.parse("2026-01-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2025-09-20T09:53:07Z"), u2);
		Order o3 = new Order(null, Instant.parse("2024-11-20T19:58:07Z"), u1);
		
	    userRepository.saveAll(Arrays.asList(u1, u2));
	    orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}

	
	
}

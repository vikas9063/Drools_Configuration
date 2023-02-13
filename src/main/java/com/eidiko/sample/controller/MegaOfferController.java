package com.eidiko.sample.controller;

import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eidiko.sample.modal.Order;

@RestController

public class MegaOfferController {

	@Autowired
	private KieSession kieSession;

	@PostMapping("/order")
	public ResponseEntity<Order> orderNow(@RequestBody Order order) {

		kieSession.insert(order);
		kieSession.fireAllRules();

		return ResponseEntity.ok().body(order);
	}

}

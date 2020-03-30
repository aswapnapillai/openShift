package com.stackroute.bookrecommendationservice.rabbitmq.domain;

import java.util.List;



public class UserDTO {

	private Long id;

	private String user;

	private String bookUrl;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}

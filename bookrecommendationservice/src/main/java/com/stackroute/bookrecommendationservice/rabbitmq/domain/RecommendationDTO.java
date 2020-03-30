package com.stackroute.bookrecommendationservice.rabbitmq.domain;

public class RecommendationDTO {
	private Long id;


	private String bookUrl;

	private int count;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}

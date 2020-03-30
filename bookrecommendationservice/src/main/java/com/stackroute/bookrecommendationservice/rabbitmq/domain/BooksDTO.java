package com.stackroute.bookrecommendationservice.rabbitmq.domain;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;

public class BooksDTO {
	private Long id;

	private String subtitle;

	private String title;

	private String url;

	private String notes;

	private String publishDate;

	private int count;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}

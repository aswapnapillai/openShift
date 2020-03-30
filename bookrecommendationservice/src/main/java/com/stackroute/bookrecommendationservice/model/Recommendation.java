package com.stackroute.bookrecommendationservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recommendation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;


	private String bookUrl;

	private int count;


	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getBookUrl() {
		return bookUrl;
	}

	public void setBookUrl(String bookUrl) {
		this.bookUrl = bookUrl;
	}


	public Recommendation(String bookUrl, int count) {
		super();
		this.bookUrl = bookUrl;
		this.count=count;
	}

	public Recommendation() {
		super();
	}

	

}
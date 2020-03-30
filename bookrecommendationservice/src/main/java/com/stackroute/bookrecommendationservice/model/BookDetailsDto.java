package com.stackroute.bookrecommendationservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDetailsDto implements Serializable {

	private static final long serialVersionUID = 4840908087662597009L;
	@JsonProperty("subtitle")
	private String subtitle;
	@JsonProperty("title")
	private String title;
	@JsonProperty("url")
	private String url;
	@JsonProperty("notes")
	private String notes;
	@JsonProperty("publish_date")
	private String publishDate;

	@Column(length = 100)
	@JsonProperty("count")
	private int count;

	@JsonProperty("subtitle")
	public String getSubtitle() {
		return subtitle;
	}

	@JsonProperty("subtitle")
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	@JsonProperty("title")
	public String getTitle() {
		return title;
	}

	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
	}

	@JsonProperty("notes")
	public String getNotes() {
		return notes;
	}

	@JsonProperty("notes")
	public void setNotes(String notes) {
		this.notes = notes;
	}

	@JsonProperty("publish_date")
	public String getPublishDate() {
		return publishDate;
	}

	@JsonProperty("publish_date")
	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}


	@JsonProperty("count")
	public void setCount(int count) {
		this.count=count;
	}

	@JsonProperty("count")
	public int getcount() {
		return count;
	}

}
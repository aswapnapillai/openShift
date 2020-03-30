package com.stackroute.bookrecommendationservice.dao;

import org.springframework.data.repository.CrudRepository;


public interface BookDao extends CrudRepository<BookDetails, Integer> {
	BookDetails findByUrl(String url);
}

package com.stackroute.favouriteservice.dao;

import com.stackroute.favouriteservice.model.BookDetails;
import org.springframework.data.repository.CrudRepository;


public interface BookDao extends CrudRepository<BookDetails, Integer> {
	BookDetails findByUrl(String url);
}

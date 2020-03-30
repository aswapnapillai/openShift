package com.stackroute.bookrecommendationservice.dao;

import com.stackroute.bookrecommendationservice.model.Recommendation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecommendationDao extends CrudRepository<Recommendation, Integer>  {
	public Recommendation findByBookUrl(String bookUrl);



}
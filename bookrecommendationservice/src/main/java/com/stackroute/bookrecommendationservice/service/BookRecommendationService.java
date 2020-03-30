package com.stackroute.bookrecommendationservice.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.bookrecommendationservice.dao.BookDao;
import com.stackroute.bookrecommendationservice.dao.BookDetails;
import com.stackroute.bookrecommendationservice.dao.RecommendationDao;
import com.stackroute.bookrecommendationservice.dao.UserFavoriteDao;
import com.stackroute.bookrecommendationservice.model.BookDetailsDto;
import com.stackroute.bookrecommendationservice.model.Recommendation;
import com.stackroute.bookrecommendationservice.model.UserFavorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookRecommendationService {

	@Autowired
	private BookDao bookDao;
	
	@Autowired
	private RecommendationDao recommendationDao;

	@Autowired
	private UserFavoriteDao userFavDao;
	
	public void saveRecommendation(BookDetails bookdetails, String user) {
		Recommendation recList = recommendationDao.findByBookUrl(bookdetails.getUrl());
		String out="Not Found";

		if(recList==null) {
			Recommendation newData= new Recommendation(bookdetails.getUrl(),0);
			recommendationDao.save(newData);
		}else{
			recList.setCount(recList.getCount() + 1);
			recommendationDao.save(recList);
		}

	}
	public 	Recommendation getAllBooksbyUrl(String url) {
		Recommendation recList = recommendationDao.findByBookUrl(url);

		return recList;
		
	}


	public 	List<BookDetails> getAllBooksbyuser(String user) {
		List<UserFavorite> userList = userFavDao.findByUser(user);
		List<BookDetails> bd =  new ArrayList<BookDetails>();
		if(userList.size() > 0) {
			userList.forEach(usrFav -> {
				BookDetails bookdeatils = bookDao.findByUrl(usrFav.getBookUrl());
				Recommendation recList = getAllBooksbyUrl(usrFav.getBookUrl());
				if (recList != null) {
					bookdeatils.setCount(recList.getCount());
				}
				bd.add(bookdeatils);
			});
		}

		return bd;

	}
	
}

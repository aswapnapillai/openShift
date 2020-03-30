package com.stackroute.bookrecommendationservice.controller;
import com.stackroute.bookrecommendationservice.dao.BookDao;
import com.stackroute.bookrecommendationservice.dao.BookDetails;
import com.stackroute.bookrecommendationservice.model.BookDetailsDto;
import com.stackroute.bookrecommendationservice.model.Recommendation;
import com.stackroute.bookrecommendationservice.service.BookRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BooksRecommendationController {
	@Autowired
	private BookDao bookDao;

	@Autowired
	private BookRecommendationService bookKeeperService;
	
	@PostMapping("/saveRec")
	public void SaveBook(@RequestBody BookDetails bookdetails, @RequestParam String user) {
		bookKeeperService.saveRecommendation(bookdetails, user);
	}
	@GetMapping("/getRec")
	public List<BookDetails> getRecBook(@RequestParam String user) {
		boolean isFavorite = false;
		List<BookDetails>  bookDetails = bookKeeperService.getAllBooksbyuser(user);
		return bookDetails;
	}

}
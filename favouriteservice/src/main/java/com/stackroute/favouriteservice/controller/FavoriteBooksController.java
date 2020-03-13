package com.stackroute.favouriteservice.controller;

import com.stackroute.favouriteservice.model.BookDetails;
import com.stackroute.favouriteservice.model.BookDetailsDto;
import com.stackroute.favouriteservice.service.BookKeeperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FavoriteBooksController {
	@Autowired
	private BookKeeperService bookKeeperService;
	
	@PostMapping("/save")
	public BookDetailsDto SaveBook(@RequestBody BookDetailsDto bookdetails, @RequestParam String user) {
		bookKeeperService.saveBook(bookdetails, user);
		return bookdetails;		
	}
	@GetMapping("/isFavorite")
	public boolean isFavoriteBook(@RequestParam String url, @RequestParam String user) {
		boolean isFavorite = false;
		isFavorite = bookKeeperService.isFavorite(url, user);
		return isFavorite;	
	}
	
	@GetMapping("/list")
	public List<BookDetails> getAllBook(@RequestParam String user) {
		return bookKeeperService.getAllBooks(user);		
	}
	@DeleteMapping("/delete")
	public String deleteBook(@RequestParam String url, @RequestParam String user) {
		
		return bookKeeperService.deleteBook(url, user);		
	}

}
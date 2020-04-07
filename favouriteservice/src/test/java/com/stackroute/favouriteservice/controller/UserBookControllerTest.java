package com.stackroute.favouriteservice.controller;

import java.util.ArrayList;
import java.util.List;

import com.stackroute.favouriteservice.dao.UserFavoriteDao;
import com.stackroute.favouriteservice.model.BookDetails;
import com.stackroute.favouriteservice.model.BookDetailsDto;
import com.stackroute.favouriteservice.model.UserFavorite;
import com.stackroute.favouriteservice.service.BookKeeperService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@RunWith(SpringRunner.class)
@WebMvcTest(UserBookControllerTest.class)
public class UserBookControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BookKeeperService favBookService;
	
	@InjectMocks
    private FavoriteBooksController favouriteBooksController;


	HttpHeaders httpHeaders;
	
	 private List<BookDetails> booksList;
	

	String userId="swara22";
	BookDetails book;
	BookDetailsDto bookdto;
	@Before
	public void setUp()
	{
		 MockitoAnnotations.initMocks(this);
		 mockMvc = MockMvcBuilders.standaloneSetup(favouriteBooksController).build();
		 List<BookDetails> booksList = new ArrayList<>();
		 //book = new Docs("1", "258027", "true", "abd", "The Lord of the Rings", "1954", "8434332", "true", "Jhon123");
		bookdto=new BookDetailsDto();
		book= new BookDetails();
		book.setPublishDate("1/1/2002");
		bookdto.setPublishDate("1/1/2002");
		book.setUrl("http:/test");
		bookdto.setUrl("http:/test");
		book.setSubtitle("test");
		bookdto.setSubtitle("test");
		booksList.add(book);

		favBookService.saveBook(bookdto,userId);

	}
	@After
	public void tearDown()
	{
		
		book=null;
		booksList= null;
		bookdto=null;

		userId=null;
		
	}
	
	
	 @Test
	 public void testGetFavourites() throws Exception {
		 List<BookDetails> list = null;
	        Mockito.when(favBookService.getAllBooks(userId)).thenReturn(list);
	        mockMvc.perform(MockMvcRequestBuilders.get("/list?user=swara22").contentType(MediaType.APPLICATION_JSON))
	                .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
	    }
	

	 
	 @Test
	 public void deleteBook() throws Exception {
	        Mockito.when(favBookService.deleteBook(userId, book.getUrl())).thenReturn("deleted");
	        mockMvc.perform(MockMvcRequestBuilders.delete("/delete?url=" + book.getUrl() + "&user=" + userId).contentType(MediaType.APPLICATION_JSON))
	                .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
	    }
	 


}

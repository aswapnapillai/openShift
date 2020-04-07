package com.stackroute.favouriteservice.service;

import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.stackroute.favouriteservice.controller.FavoriteBooksController;
import com.stackroute.favouriteservice.controller.UserBookControllerTest;
import com.stackroute.favouriteservice.dao.BookDao;
import com.stackroute.favouriteservice.dao.UserFavoriteDao;
import com.stackroute.favouriteservice.model.BookDetails;
import com.stackroute.favouriteservice.model.BookDetailsDto;
import com.stackroute.favouriteservice.model.UserFavorite;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Mockito;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(UserBookServiceTest.class)

public class UserBookServiceTest {
	@Autowired
	private MockMvc mockMvc;


	@InjectMocks
	private BookKeeperService favBookService;


	@Mock
	private UserFavoriteDao userBookRepository;

	@Mock
	private BookDao bookDao;


	HttpHeaders httpHeaders;

	private List<BookDetails> booksList;


	String userId="swara22";
	BookDetails book;
	BookDetailsDto bookdto;
	UserFavorite userFavorite;
	UserFavorite userFavoritenew;

	@InjectMocks
	private FavoriteBooksController favouriteBooksController;
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
		userFavoritenew=new UserFavorite(userId,bookdto.getUrl());
		userFavorite = new UserFavorite(userId,bookdto.getUrl());

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
	public void testSaveUserBookSuccess()  {
		List<UserFavorite> list = null;

		Mockito.when(userBookRepository.findByBookUrl(book.getUrl())).thenReturn(list);
		doNothing().when(userBookRepository).delete(userFavoritenew);
//		favBookService.saveBook(bookdto,userId);
		boolean flag = favBookService.getAllBooks(userId).isEmpty();
		Assert.assertEquals(true, flag);
//
	}


	@Test
	public void testDeleteBooksSuccess() {
		List<UserFavorite> list = null;
		Mockito.when(userBookRepository.findByBookUrl(book.getUrl())).thenReturn(list);
		Mockito.when(userBookRepository.save(userFavorite)).thenReturn(userFavorite);
		String val = favBookService.deleteBook(book.getUrl(),userId);Assert.assertEquals("deleted", val); }


	@Test
	public void testGetBooksSuccess() {

		List<BookDetails> dbBooks = favBookService.getAllBooks(userId);

		Assert.assertEquals(0, dbBooks.size());
	}

}

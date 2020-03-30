package com.stackroute.bookrecommendationservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.CONFLICT,reason="Book not added")
public class BookRecommendationNotAddedException extends Exception {

}

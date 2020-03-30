package com.stackroute.bookrecommendationservice.config;

import ch.qos.logback.classic.pattern.MessageConverter;
import com.stackroute.bookrecommendationservice.dao.BookDetails;
import com.stackroute.bookrecommendationservice.exception.BookRecommendationNotAddedException;
import com.stackroute.bookrecommendationservice.service.BookRecommendationService;
import com.stackroute.bookrecommendationservice.rabbitmq.domain.UserDTO;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Consumer {


    @Autowired
    private BookRecommendationService bookRecommendationServiceImpl;

    @RabbitListener(queues = "user_fav_ book_queue")
   public void getUserDtoFromRabbitMq(BookDetails bookDetails, String user) throws BookRecommendationNotAddedException{
    	 bookRecommendationServiceImpl.saveRecommendation(bookDetails,user);

    }
}

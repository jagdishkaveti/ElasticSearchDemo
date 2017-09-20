package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@SpringBootApplication
public class ElasticSearchDemoApplication implements CommandLineRunner {
	
	@Autowired
	private ElasticsearchOperations esOperations;
	
	@Autowired
	private BookService	bookService;
	
	public static void main(String[] args) {
		SpringApplication.run(ElasticSearchDemoApplication.class, args); 
	}
	
	@Override
	public void run(String... arg0) throws Exception {
		
		bookService.save(new Book("1001", "Father", "Jagadeeshwar", "ZZ-Sept-1981"));
        bookService.save(new Book("1002", "Daughter", "Saanvi", "YY-Apr-2010"));
        bookService.save(new Book("1003", "Son", "Vishnu", "XX-Dec-2013"));
        
//        Page<Book> books = bookService.findByAuthor("Jagadeeshwar", new PageRequest(0, 10));
        System.out.println(bookService.findOne("1001"));
		
	}

}

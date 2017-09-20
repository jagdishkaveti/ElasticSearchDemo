package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.example.demo.model.Book;

public interface BookService {

	Book save(Book book);

	void delete(Book book);

	Book findOne(String id);

	Iterable<Book> findAll();

	Page<Book> findByAuthor(String author, PageRequest pageRequest);

	List<Book> findByTitle(String title);

}

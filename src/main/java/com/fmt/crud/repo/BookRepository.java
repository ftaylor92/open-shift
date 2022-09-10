package com.fmt.crud.repo;

import org.springframework.data.repository.CrudRepository;

import com.fmt.crud.beans.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}

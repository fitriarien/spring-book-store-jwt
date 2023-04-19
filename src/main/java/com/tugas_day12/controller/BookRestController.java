package com.tugas_day12.controller;

import com.tugas_day12.model.dao.BookDAO;
import com.tugas_day12.model.dto.BookDTO;
import com.tugas_day12.repository.BookRepo;
import com.tugas_day12.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class BookRestController {
    public static final Logger logger = LoggerFactory.getLogger(BookRestController.class);

    @Autowired private BookRepo bookRepo;

    // CREATE
    @RequestMapping(value = "/bookrepo/", method = RequestMethod.POST, produces="application/json")
    public ResponseEntity<?> createBookNew(@RequestBody BookDAO book) throws SQLException, ClassNotFoundException {
        logger.info("Creating Book : {}", book);
        bookRepo.save(book);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }

    // READ ALL BOOKS
    @RequestMapping(value = "/bookrepo/", method = RequestMethod.GET, produces="application/json")
    public ResponseEntity<List<BookDAO>> listAllBooks() throws SQLException, ClassNotFoundException {

        List<BookDAO> books = bookRepo.findAll();
        if (books.isEmpty()) {
            return new ResponseEntity<>(books, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    // READ SINGLE BOOK
    @RequestMapping(value = "/bookrepo/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getBook(@PathVariable("id") long id) throws SQLException, ClassNotFoundException {
        logger.info("Fetching Book with id {}", id);
        BookDAO book = bookRepo.findById(id).orElse(null);
        if (book == null) {
            logger.error("Book with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Book with id " + id  + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    // UPDATE A BOOK
    @RequestMapping(value = "/bookrepo/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateBook(@PathVariable("id") long id, @RequestBody BookDTO book) throws SQLException, ClassNotFoundException {
        logger.info("Updating Book with id {}", id);
        BookDAO currentBook = bookRepo.findById(id).orElse(null);
        if (currentBook == null) {
            logger.error("Unable to update. Book with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Unable to update. Book with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        currentBook.setTitle(book.getTitle());
        currentBook.setAuthor(book.getAuthor());
        currentBook.setDescriptions(book.getDescriptions());
        currentBook.setPrice(book.getPrice());
        currentBook.setStocks(book.getStocks());

        bookRepo.save(currentBook);
        return new ResponseEntity<>(currentBook, HttpStatus.OK);
    }

    // DELETE A BOOK
    @RequestMapping(value = "/bookrepo/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBook(@PathVariable("id") long id) throws SQLException, ClassNotFoundException {
        logger.info("Fetching & Deleting Book with id {}", id);
        BookDAO book = bookRepo.findById(id).orElse(null);
        if (book == null) {
            logger.error("Unable to delete. Book with id {} not found.", id);
            return new ResponseEntity<>(new CustomErrorType("Unable to delete. Book with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        bookRepo.deleteById(id);
        return new ResponseEntity<BookDAO>(HttpStatus.NO_CONTENT);
    }

    // DELETE ALL BOOKS
    @RequestMapping(value = "/bookrepo/", method = RequestMethod.DELETE)
    public ResponseEntity<BookDAO> deleteAllBooks() throws SQLException {
        logger.info("Deleting All Books");
        bookRepo.deleteAll();
        return new ResponseEntity<BookDAO>(HttpStatus.NO_CONTENT);
    }
}

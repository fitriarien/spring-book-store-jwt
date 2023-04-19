package com.tugas_day12.repository;

import com.tugas_day12.model.dao.BookDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepo extends JpaRepository<BookDAO, Long> {
}

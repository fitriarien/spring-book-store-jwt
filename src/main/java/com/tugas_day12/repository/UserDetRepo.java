package com.tugas_day12.repository;

import com.tugas_day12.model.dao.UserDAO;
import com.tugas_day12.model.dao.UserDetDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetRepo extends JpaRepository<UserDetDAO, Long> {
    UserDetDAO findByUserDAO(UserDAO userDAO);
}

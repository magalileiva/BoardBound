package com.ramz.boardbound.BoardBound.repository;

import com.ramz.boardbound.BoardBound.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByEmail(String name);

}

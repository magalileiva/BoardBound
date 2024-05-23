package com.ramz.boardbound.BoardBound.repository;

import com.ramz.boardbound.BoardBound.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Aquí puedes agregar métodos personalizados si los necesitas
}

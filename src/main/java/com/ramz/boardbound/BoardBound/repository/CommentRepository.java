package com.ramz.boardbound.BoardBound.repository;

import com.ramz.boardbound.BoardBound.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    // Aquí puedes agregar métodos personalizados si los necesitas
}


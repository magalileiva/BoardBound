package com.ramz.boardbound.BoardBound.service;

import com.ramz.boardbound.BoardBound.model.BoardGamePublisher;
import com.ramz.boardbound.BoardBound.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PublisherService {
    @Autowired
    PublisherRepository publisherRepository;

    public BoardGamePublisher saveOrUpdatePublisher(BoardGamePublisher boardGamePublisher){
        return publisherRepository.save(boardGamePublisher);
    }
    public List<BoardGamePublisher> getBoardGamesPublisher(){
        return publisherRepository.findAll();
    }
    public Optional<BoardGamePublisher> getBoardGamePublisherById(Long id){
        return publisherRepository.findById(id);
    }

    public List<BoardGamePublisher> getBoardGamePublisherByName(String name){
        return publisherRepository.findBoardGamePublisherByName(name);
    }
    public void deleteBoardGamePublisher(Long id){publisherRepository.deleteById(id);}

}

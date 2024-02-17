package com.ramz.boardbound.BoardBound.controller;

import com.ramz.boardbound.BoardBound.model.BoardGamePublisher;
import com.ramz.boardbound.BoardBound.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("api/v1/boardBound/publisher")
public class PublisherController {

    private final PublisherService publisherService;
    @Autowired
    public PublisherController(PublisherService publisherService){this.publisherService = publisherService;}

    @GetMapping
    public ResponseEntity<List<BoardGamePublisher>> getAll(){
        List<BoardGamePublisher> publisher = publisherService.getBoardGamesPublisher();
        return ResponseEntity.ok(publisher);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<BoardGamePublisher>> getPublisherById(@PathVariable Long id){
        Optional<BoardGamePublisher> publisher = publisherService.getBoardGamePublisherById(id);
        return ResponseEntity.ok(publisher);
    }
    @GetMapping("/name")
    public ResponseEntity<List<BoardGamePublisher>> getPublisherByName(@RequestParam String name){
        List<BoardGamePublisher> publisher = publisherService.getBoardGamePublisherByName(name);
        return ResponseEntity.ok(publisher);
    }
    @PostMapping
    public ResponseEntity<BoardGamePublisher> savePublisher(@RequestBody BoardGamePublisher publisher){
        BoardGamePublisher newPublisher = publisherService.saveOrUpdatePublisher(publisher);
        return ResponseEntity.ok(newPublisher);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePublisherById(@PathVariable Long id){
        publisherService.deleteBoardGamePublisher(id);
        return ResponseEntity.noContent().build();
    }
}


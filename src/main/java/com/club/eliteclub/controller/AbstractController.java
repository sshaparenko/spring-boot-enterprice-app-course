package com.club.eliteclub.controller;

import com.club.eliteclub.model.Player;
import com.club.eliteclub.service.AbstractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class AbstractController {
    @Autowired
    AbstractionService service;
    @GetMapping("/player/{id}")
    public ResponseEntity<String> getPlayerById(@PathVariable Long id) {
        Optional<Player> playerOptional = service.getPlayerById(id);
        return playerOptional.map(player -> new ResponseEntity<>(player.toString(), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>("Here is no player with such ID", HttpStatus.NOT_FOUND));
    }
}

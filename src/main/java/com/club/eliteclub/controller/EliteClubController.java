package com.club.eliteclub.controller;

import com.club.eliteclub.model.ClubDto;
import com.club.eliteclub.service.EliteClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EliteClubController {
    @Autowired
    EliteClubService service;
    @GetMapping(value = "/clubs", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClubDto> clubs() {
        return service.getAll();
    }
}

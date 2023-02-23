package com.club.eliteclub.service;

import com.club.eliteclub.entity.EliteClub;
import com.club.eliteclub.model.ClubDto;
import com.club.eliteclub.repo.EliteClubRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EliteClubService {
    @Autowired
    EliteClubRepository repository;
    private Logger logger = LoggerFactory.getLogger(EliteClubService.class);
    public List<ClubDto> getAll() {
        return repository.findAll().stream().map(c -> new ClubDto(c.getClubName())).collect(Collectors.toList());
    }

    public void addClub(String... clubNames) {
        for (String clubName : clubNames) {
            EliteClub eliteClub = new EliteClub();
            eliteClub.setClubName(clubName);
            repository.save(eliteClub);
        }
    }
    public List<ClubDto> searchClub(String searchTerm) {
        logger.info("Searching term {}", searchTerm);
        List<ClubDto> result = repository.findClubs(buildLikePattern(searchTerm), PageRequest.of(0, 10)).stream().map(c -> new ClubDto(c.getClubName())).collect(Collectors.toList());
        logger.info("Searching result {}", result);
        return result;
    }
    private String buildLikePattern(String searchTerm) {
        return searchTerm.toLowerCase() + "%";
    }
}

package com.club.eliteclub;

import com.club.eliteclub.model.ClubDto;
import com.club.eliteclub.service.EliteClubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class EliteClubApplication implements ApplicationRunner {
	@Autowired
	private EliteClubService service;
	private Logger logger = LoggerFactory.getLogger(EliteClubApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(EliteClubApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		service.addClub("Billionaire", "Environmentalist", "Poker", "bir1", "bir2", "bir3", "bir4", "bir5", "bir6", "bir7", "bir8", "bir9", "bir10", "bir11");
		System.out.println(service.getAll());
		List<ClubDto> result = service.searchClub("bi");
		logger.info("Search result {}", result);
		logger.info("Result length {}", result.size());

	}
}

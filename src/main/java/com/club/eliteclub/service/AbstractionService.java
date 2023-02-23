package com.club.eliteclub.service;

import com.club.eliteclub.dao.GenericJpaDao;
import com.club.eliteclub.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class AbstractionService {
    GenericJpaDao<Player> playerDao;
    @Autowired
    public AbstractionService(GenericJpaDao<Player> playerDao) {
        this.playerDao = playerDao;
        this.playerDao.setClazz(Player.class);
    }
    public Optional<Player> getPlayerById(Long id) {
        return Optional.ofNullable(playerDao.findOne(id));
    }
}

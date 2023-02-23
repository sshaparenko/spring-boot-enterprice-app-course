package com.club.eliteclub.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Player implements Serializable {
    @Id
    private Long id;
    private String name;
}

package com.club.eliteclub.model;

public class ClubDto {
    private Long id;
    private String name;

    @Override
    public String toString() {
        return "ClubDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public ClubDto(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package com.example.petadmin.dto;

import com.example.petadmin.entity.Animal;
import com.example.petadmin.enums.AnimalStatus;

import java.time.OffsetDateTime;

public class AnimalDetailDto {

    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private String category;
    private OffsetDateTime birthDate;
    private int age;
    private AnimalStatus status;

    public AnimalDetailDto() {}

    public AnimalDetailDto(Animal animal) {
        this.id = animal.getId();
        this.name = animal.getName();
        this.description = animal.getDescription();
        this.imageUrl = animal.getImageUrl();
        this.category = animal.getCategory();
        this.birthDate = animal.getBirthdate();
        this.age = animal.getAge();
        this.status = animal.getStatus();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCategory() {
        return category;
    }

    public OffsetDateTime getBirthDate() {
        return birthDate;
    }

    public int getAge() {
        return age;
    }

    public AnimalStatus getStatus() {
        return status;
    }

    public void setStatus(AnimalStatus status) {
        this.status = status;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBirthDate(OffsetDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }
}

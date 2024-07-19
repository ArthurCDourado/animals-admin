package com.example.petadmin;

import com.example.petadmin.dto.AnimalCreateDto;
import com.example.petadmin.entity.Animal;
import com.example.petadmin.enums.AnimalStatus;
import com.example.petadmin.repository.AnimalRepository;
import com.example.petadmin.service.AnimalService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TestAnimal extends PetAdminApplicationTests {

    @MockBean
    private AnimalRepository repository;

    @Autowired
    private AnimalService service;

    @Test
    public void itShouldCreateAnimal() {
        Animal animal = new Animal();

        AnimalCreateDto animalToCreate = new AnimalCreateDto();
        animalToCreate.setName("Test Name");
        animalToCreate.setDescription("Test Description");
        animalToCreate.setImageUrl("http://test.com/image.jpg");
        animalToCreate.setCategory("Test Category");
        animalToCreate.setBirthDate(OffsetDateTime.now(ZoneOffset.UTC));

        when(repository.save(animal)).thenReturn(animal);

        assertEquals(animal, service.createAnimal(animalToCreate));
    }

    @Test
    public void itShouldGetAllAnimals() {
        when(repository.findAll()).thenReturn(Stream.of(
                new Animal(),
                new Animal()).collect(Collectors.toList()));

        assertEquals(2, service.getAllAnimals().size());
    }

    @Test
    public void itShouldChangeAnimalStatus() {
        Animal animal = new Animal();

        when(repository.save(animal)).thenReturn(animal);
        when(repository.findById(1L)).thenReturn(Optional.of(animal));

        assertEquals(animal, service.changeStatus(1L, AnimalStatus.valueOf("Available")));
    }

}

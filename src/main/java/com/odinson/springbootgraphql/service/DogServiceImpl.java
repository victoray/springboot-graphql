package com.odinson.springbootgraphql.service;


import com.odinson.springbootgraphql.entity.Dog;
import com.odinson.springbootgraphql.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogServiceImpl implements DogService {

    @Autowired
    DogRepository dogRepository;

    @Override
    public List<Dog> retrieveAllDogs() {
        return (List<Dog>) dogRepository.findAll();
    }

    @Override
    public List<String> retrieveDogBreed() {

        return dogRepository.getAllBreeds();
    }

    @Override
    public String retrieveDogBreedById(Long id) {

        return dogRepository.getBreedById(id);
    }

    @Override
    public List<String> retrieveDogNames() {
        return dogRepository.getDogNames();
    }
}

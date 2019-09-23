package com.odinson.springbootgraphql.service;



import com.odinson.springbootgraphql.entity.Dog;

import java.util.List;

public interface DogService {

    List<Dog> retrieveAllDogs();
    List<String> retrieveDogBreed();
    String retrieveDogBreedById(Long id);
    List<String> retrieveDogNames();


}

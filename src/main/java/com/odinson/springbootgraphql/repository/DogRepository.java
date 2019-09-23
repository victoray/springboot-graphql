package com.odinson.springbootgraphql.repository;

import com.odinson.springbootgraphql.entity.Dog;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface DogRepository extends CrudRepository<Dog, Long> {

    @Query(value = "SELECT breed FROM dog", nativeQuery = true)
    List<String> getAllBreeds();

    @Query(value = "SELECT breed from dog WHERE dog.id = ?1", nativeQuery = true)
    String getBreedById(Long id);

    @Query(value = "SELECT name from dog", nativeQuery = true)
    List<String> getDogNames();

    @Query(value = "DELETE * FROM dog WHERE dog.breed = ?1", nativeQuery = true)
    boolean deleteDogBreed(String breed);

}

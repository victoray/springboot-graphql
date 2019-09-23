package com.odinson.springbootgraphql.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.odinson.springbootgraphql.entity.Dog;
import com.odinson.springbootgraphql.exception.BreedNotFoundException;
import com.odinson.springbootgraphql.exception.DogNotFoundException;
import com.odinson.springbootgraphql.repository.DogRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {

    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }


    public Dog updateDogName(String name, Long id) throws Exception {
        Optional<Dog> optDog = dogRepository.findById(id);
        if (optDog.isPresent()){
            Dog dog = optDog.get();
            dog.setName(name);
            dogRepository.save(dog);
            return dog;
        } else {
            throw new DogNotFoundException("Dog not found!!", id);
        }

    }

    public boolean deleteDogBreed(String breed){
        dogRepository.deleteDogBreed(breed);
        return true;
    }



}

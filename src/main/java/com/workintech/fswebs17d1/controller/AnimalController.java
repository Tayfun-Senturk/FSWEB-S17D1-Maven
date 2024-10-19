package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AnimalController {
    Map<Integer, Animal> animals = new HashMap<>();
    @GetMapping("/workintech/animal")
    public List<Animal> getAnimals() {
        return animals.values().stream().toList();
    }

    @GetMapping("/workintech/animal/{id}")
    public Animal getAnimal(@PathVariable Integer id) {
        if(animals.get(id)!=null) {
            return animals.get(id);
        }
        return null;
    }

    @PostMapping("/workintech/animal")
    public Animal addAnimal(@RequestBody Animal animal) {
        animals.put(animal.getId(),animal);
        return animal;
    }

    @PutMapping("/workintech/animal/{id}")
    public Animal updateAnimal(@PathVariable Integer id,@RequestBody Animal animal){
        animals.put(id,animal);
        return animal;
    }

    @DeleteMapping("/workintech/animal/{id}")
    public Animal deleteAnimal(@PathVariable Integer id){
        Animal s = animals.get(id);
        animals.remove(id);
        return s;
    }
}

package com.example.demo.Petstore.pet.repository;


import com.example.demo.Petstore.pet.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag,Integer> {
}

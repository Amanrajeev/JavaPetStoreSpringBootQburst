package com.example.demo.Petstore.pet.repository;


import com.example.demo.Petstore.pet.model.PhotoUrls;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoUrlsRepository extends JpaRepository<PhotoUrls,Integer> {
}

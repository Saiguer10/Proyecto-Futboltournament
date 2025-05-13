package com.example.demo.repositories;

import com.example.demo.models.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
}

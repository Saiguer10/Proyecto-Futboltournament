package com.example.demo.services;

import com.example.demo.models.Organizer;
import com.example.demo.repositories.OrganizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizerService {

    @Autowired
    private OrganizerRepository organizerRepository;

    public List<Organizer> getAllOrganizers() {
        return organizerRepository.findAll();
    }

    public Optional<Organizer> getOrganizerById(Long id) {
        return organizerRepository.findById(id);
    }

    public Organizer createOrganizer(Organizer organizer) {
        return organizerRepository.save(organizer);
    }

    public Organizer updateOrganizer(Long id, Organizer organizer) {
        if (organizerRepository.existsById(id)) {
            organizer.setId(id);
            return organizerRepository.save(organizer);
        }
        return null;
    }

    public boolean deleteOrganizer(Long id) {
        if (organizerRepository.existsById(id)) {
            organizerRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

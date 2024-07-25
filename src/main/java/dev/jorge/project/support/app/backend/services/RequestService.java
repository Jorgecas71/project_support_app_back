package dev.jorge.project.support.app.backend.services;

import dev.jorge.project.support.app.backend.models.Request;
import dev.jorge.project.support.app.backend.repositories.RequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    private final RequestRepository repository;

    public RequestService(RequestRepository repository) {
        this.repository = repository;
    }

    public List<Request> getAll() {
        return repository.findAll();
    }
}


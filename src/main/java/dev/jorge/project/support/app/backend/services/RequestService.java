package dev.jorge.project.support.app.backend.services;

import dev.jorge.project.support.app.backend.models.Request;
import dev.jorge.project.support.app.backend.repositories.RequestRepository;
import dev.jorge.project.support.app.backend.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    public Request createRequest(Request request) {
        return requestRepository.save(request);
    }

    public Request updateRequest(Long id, Request request) {
        Request existingRequest = requestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found"));
        existingRequest.setRequesterName(request.getRequesterName());
        existingRequest.setRequesterName(request.getRequesterName());
        existingRequest.setSubject(request.getSubject());
        existingRequest.setDescription(request.getDescription());
        return requestRepository.save(existingRequest);
    }

    public Request markAsCompleted(Long id) {
        Request existingRequest = requestRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Request not found"));
        existingRequest.setStatus("Completed");
        return requestRepository.save(existingRequest);
    }

    public Object getAll() {
         
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
}

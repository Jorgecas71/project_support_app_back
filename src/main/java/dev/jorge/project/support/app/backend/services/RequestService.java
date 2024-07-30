package dev.jorge.project.support.app.backend.services;

import dev.jorge.project.support.app.backend.models.Request;
import dev.jorge.project.support.app.backend.repositories.RequestRepository;
//import dev.jorge.project.support.app.backend.exceptions.ResourceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestService {

   @Autowired
private RequestRepository requestRepository;

public List<Request> getAllRequest() {
    return requestRepository.findAll();
}

public Request getRequestById(Long idRequest) {
    return requestRepository.findById(idRequest).orElse(null);
}

public Request createRequest(Request request) {
    return requestRepository.save(request);
}

public Request updateRequest(Request request) {
    return requestRepository.save(request);
}

public void deleteRequestById(Long idRequest) {
   requestRepository.deleteById(idRequest);
}
}

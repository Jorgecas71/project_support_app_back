package dev.jorge.project.support.app.backend.controller;

import dev.jorge.project.support.app.backend.models.Request;
import dev.jorge.project.support.app.backend.services.RequestService;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class RequestController {

    private final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping
    public List<Request> getAllRequests() {
        return requestService.getAllRequests();
    }

    @PostMapping
    public Request createRequest(@RequestBody Request request) {
        return requestService.createRequest(request);
    }

    @PutMapping("/{id}")
    public Request updateRequest(@PathVariable Long id, @RequestBody Request request) {
        return requestService.updateRequest(id, request);
    }

    @PutMapping("/{id}/complete")
    public Request markAsCompleted(@PathVariable Long id) {
        return requestService.markAsCompleted(id);
    }

    @GetMapping("/index")
    public List<Request> index() {
        return requestService.getAllRequests();
    }
}

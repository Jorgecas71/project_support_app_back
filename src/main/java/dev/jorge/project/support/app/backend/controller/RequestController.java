package dev.jorge.project.support.app.backend.controller;

import dev.jorge.project.support.app.backend.controller.RequestController;
import dev.jorge.project.support.app.backend.models.Request;
import dev.jorge.project.support.app.backend.services.RequestService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class RequestController {

    private RequestService services;

    public RequestController(RequestService services) {
        this.services = services;
    }

    @GetMapping("/request")
    public List<Request> index() {
        return services.getAll();
    }
}



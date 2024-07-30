package dev.jorge.project.support.app.backend.controller;

import dev.jorge.project.support.app.backend.models.Request;
import dev.jorge.project.support.app.backend.services.RequestService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

   
   @GetMapping("/all")
    public ResponseEntity<List<Request>> getAllRequest() {
        List<Request> request = requestService.getAllRequest();
        return ResponseEntity.ok(request);
    }
    @GetMapping("/{idConsult}")
    public ResponseEntity<Request> getRequesttById(@PathVariable Long idRequest) {
        Request request = requestService.getRequestById(idRequest);
        if (request != null) {
            return ResponseEntity.ok(request);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
   @PostMapping
    public ResponseEntity<Request> createRequest(@RequestBody Request request) {
        Request createdRequest = requestService.createRequest(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdRequest);
    }
  @PutMapping("/{idRequest}")
    public ResponseEntity<Request> updateRequest(@RequestBody Request request, @PathVariable Long idRequest) {
       request.setId(idRequest);
        Request updatedRequest = requestService.updateRequest(request);
        return ResponseEntity.ok(updatedRequest);
    }
    @DeleteMapping("/{idRequest}")
    public ResponseEntity<Void> deleteRequestById(@PathVariable Long idRequest) {
       requestService.deleteRequestById(idRequest);
        return ResponseEntity.noContent().build();
    }
}

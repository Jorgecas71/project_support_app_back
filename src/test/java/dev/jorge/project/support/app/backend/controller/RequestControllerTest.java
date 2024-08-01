package dev.jorge.project.support.app.backend.controller;

import dev.jorge.project.support.app.backend.models.Request;
import dev.jorge.project.support.app.backend.services.RequestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RequestControllerTest {

    @Mock
    private RequestService requestService;

    @InjectMocks
    private RequestController requestController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllRequest() {
        Request request1 = new Request();
        Request request2 = new Request();
        List<Request> requests = Arrays.asList(request1, request2);

        when(requestService.getAllRequest()).thenReturn(requests);

        ResponseEntity<List<Request>> response = requestController.getAllRequest();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(requests, response.getBody());
    }

    @Test
    void testGetRequestById() {
        Request request = new Request();
        when(requestService.getRequestById(1L)).thenReturn(request);

        ResponseEntity<Request> response = requestController.getRequesttById(1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(request, response.getBody());
    }

    @Test
    void testGetRequestByIdNotFound() {
        when(requestService.getRequestById(1L)).thenReturn(null);

        ResponseEntity<Request> response = requestController.getRequesttById(1L);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testCreateRequest() {
        Request request = new Request();
        when(requestService.createRequest(request)).thenReturn(request);

        ResponseEntity<Request> response = requestController.createRequest(request);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(request, response.getBody());
    }

    @Test
    void testUpdateRequest() {
        Request request = new Request();
        when(requestService.updateRequest(request)).thenReturn(request);

        ResponseEntity<Request> response = requestController.updateRequest(request, 1L);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(request, response.getBody());
    }

    @Test
    void testDeleteRequestById() {
        doNothing().when(requestService).deleteRequestById(1L);

        ResponseEntity<Void> response = requestController.deleteRequestById(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(requestService, times(1)).deleteRequestById(1L);
    }
}

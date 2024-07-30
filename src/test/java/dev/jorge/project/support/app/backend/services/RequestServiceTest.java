package dev.jorge.project.support.app.backend.services;

import dev.jorge.project.support.app.backend.models.Request;
import dev.jorge.project.support.app.backend.repositories.RequestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RequestServiceTest {

    @Mock
    private RequestRepository requestRepository;

    @InjectMocks
    private RequestService requestService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllRequest() {
        Request request1 = new Request();
        Request request2 = new Request();
        List<Request> requests = Arrays.asList(request1, request2);

        when(requestRepository.findAll()).thenReturn(requests);

        List<Request> result = requestService.getAllRequest();

        assertEquals(requests, result);
    }

    @Test
    void testGetRequestById() {
        Long id = 1L;
        Request request = new Request();
        when(requestRepository.findById(id)).thenReturn(Optional.of(request));

        Request result = requestService.getRequestById(id);

        assertEquals(request, result);
    }

    @Test
    void testGetRequestByIdNotFound() {
        Long id = 1L;
        when(requestRepository.findById(id)).thenReturn(Optional.empty());

        Request result = requestService.getRequestById(id);

        assertEquals(null, result);
    }

    @Test
    void testCreateRequest() {
        Request request = new Request();
        when(requestRepository.save(request)).thenReturn(request);

        Request result = requestService.createRequest(request);

        assertEquals(request, result);
    }

    @Test
    void testUpdateRequest() {
        Request request = new Request();
        when(requestRepository.save(request)).thenReturn(request);

        Request result = requestService.updateRequest(request);

        assertEquals(request, result);
    }

    @Test
    void testDeleteRequestById() {
        Long id = 1L;
        doNothing().when(requestRepository).deleteById(id);

        requestService.deleteRequestById(id);

        verify(requestRepository, times(1)).deleteById(id);
    }
}

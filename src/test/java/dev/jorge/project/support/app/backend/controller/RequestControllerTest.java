package dev.jorge.project.support.app.backend.controller;

import dev.jorge.project.support.app.backend.models.Request;
import dev.jorge.project.support.app.backend.services.RequestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class RequestControllerTest {

    @Autowired
    private RequestController controller;

    @MockBean
    private RequestService service;

    @Test
    public void indexTest() {
        when(service.getAllRequests()).thenReturn(Arrays.asList(
                new Request(1L, "Request 1"),
                new Request(2L, "Request 2")));

        List<Request> result = controller.index();

        assertEquals(2, result.size());
        verify(service, times(1)).getAllRequests();
    }

    @Test
    public void createRequestTest() {
        Request request = new Request(1L, "New Request");
        when(service.createRequest(request)).thenReturn(request);

        Request result = controller.createRequest(request);

        assertEquals(request, result);
        verify(service, times(1)).createRequest(request);
    }

    @Test
    public void updateRequestTest() {
        Request request = new Request(1L, "Updated Request");
        when(service.updateRequest(1L, request)).thenReturn(request);

        Request result = controller.updateRequest(1L, request);

        assertEquals(request, result);
        verify(service, times(1)).updateRequest(1L, request);
    }

    @Test
    public void markAsCompletedTest() {
        Request request = new Request(1L, "Completed Request");
        when(service.markAsCompleted(1L)).thenReturn(request);

        Request result = controller.markAsCompleted(1L);

        assertEquals(request, result);
        verify(service, times(1)).markAsCompleted(1L);
        
    }
}

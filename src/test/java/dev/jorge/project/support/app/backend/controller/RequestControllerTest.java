package dev.jorge.project.support.app.backend.controller;

import dev.jorge.project.support.app.backend.controller.RequestController;
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

@SuppressWarnings("unused")
@SpringBootTest
public class RequestControllerTest {

    @Autowired
    private RequestController controller;

    @MockBean
    private RequestService service;

    @Test
    public void indexTest() {
        when(service.getAll()).thenReturn(Arrays.asList(
                new Request(1L, "Request 1"),
                new Request(2L, "Request 2")));

        List<Request> result = controller.index();

        assertEquals(2, result.size());
        verify(service, times(1)).getAll();
    }
}


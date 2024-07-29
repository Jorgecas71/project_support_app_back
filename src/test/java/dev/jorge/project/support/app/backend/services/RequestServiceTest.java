package dev.jorge.project.support.app.backend.services;

import dev.jorge.project.support.app.backend.models.Request;
import dev.jorge.project.support.app.backend.repositories.RequestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class RequestServiceTest {

    @Autowired
    private RequestService service;

    @MockBean
    private RequestRepository repository;

    @Test
    public void getAllTest() {
        when(repository.findAll()).thenReturn(Arrays.asList(
                new Request(1L, "Request 1", null, null, null, null),
                new Request(2L, "Request 2", null, null, null, null)));

        @SuppressWarnings("unchecked")
        List<Request> result = (List<Request>) service.getAll();

        assertEquals(2, result.size());
        verify(repository, times(1)).findAll();
    }
}

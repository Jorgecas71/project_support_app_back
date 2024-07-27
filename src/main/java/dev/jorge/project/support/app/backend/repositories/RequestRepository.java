package dev.jorge.project.support.app.backend.repositories;

import dev.jorge.project.support.app.backend.models.*; 
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
}

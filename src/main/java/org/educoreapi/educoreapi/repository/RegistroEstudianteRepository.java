package org.educoreapi.educoreapi.repository;

import org.educoreapi.educoreapi.model.RegistroEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroEstudianteRepository extends JpaRepository<RegistroEstudiante, Integer> {
}

package org.educoreapi.educoreapi.repository;

import org.educoreapi.educoreapi.model.RegistroEstudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegistroEstudianteRepository extends JpaRepository<RegistroEstudiante, Integer> {

    public List<RegistroEstudiante> findAllByCursoIgnoreCase(String curso);
}
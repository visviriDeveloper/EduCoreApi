package org.educoreapi.educoreapi.service;

import org.educoreapi.educoreapi.model.RegistroEstudiante;
import org.educoreapi.educoreapi.repository.RegistroEstudianteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RegistroEstudianteService {

    private final RegistroEstudianteRepository regEstudianteRepo;

    public RegistroEstudianteService(RegistroEstudianteRepository regEstudianteRepo){
        this.regEstudianteRepo = regEstudianteRepo;
    }

    //Listar todos los registros (estudiantes) (GET)

    public List<RegistroEstudiante> listarTodosRegistrosE (){

        return regEstudianteRepo.findAll();
    }

    // Buscar registro por ID (estudiante) (GET)

    public Optional<RegistroEstudiante> buscarRegistroEPorId(Integer id){

        return regEstudianteRepo.findById(id);

    }

    //Buscar registros por curso (GET)

    public List<RegistroEstudiante> listarRegistrosCurso(String curso){
        return regEstudianteRepo.findAllByCursoIgnoreCase(curso);
    }

    //Agregar nuevo registro (Post)
    public RegistroEstudiante agregarRegistroE(RegistroEstudiante estudianteARegistrar){
            estudianteARegistrar.setId(null);
            return regEstudianteRepo.save(estudianteARegistrar);
    }

    //Actualizar registro completo (Put)
    public Optional<RegistroEstudiante> actualizarRegistroE(Integer id,RegistroEstudiante RegEstActualizar){
        return regEstudianteRepo.findById(id).map(registroEstudiante ->{
            registroEstudiante.setNombreEstudiante(RegEstActualizar.getNombreEstudiante());
            registroEstudiante.setCurso(RegEstActualizar.getCurso());
            registroEstudiante.setActivo(RegEstActualizar.isActivo());
            return regEstudianteRepo.save(registroEstudiante);
        });
    }

    //Eliminar registro por id (Delete)
    public boolean eliminarRegistroEPorId (Integer id) {
        boolean RegistroExiste = regEstudianteRepo.existsById(id);
        if (!RegistroExiste) {
            return false;
        }
        regEstudianteRepo.deleteById(id);
        return true;
    }
}

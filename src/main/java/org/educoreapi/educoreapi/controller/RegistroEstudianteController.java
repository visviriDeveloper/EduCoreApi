package org.educoreapi.educoreapi.controller;

import jakarta.validation.Valid;
import org.educoreapi.educoreapi.model.RegistroEstudiante;
import org.educoreapi.educoreapi.service.RegistroEstudianteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/registroEstudiante")
public class RegistroEstudianteController {

    private final RegistroEstudianteService regEstudianteService;

    public RegistroEstudianteController(RegistroEstudianteService regEstudianteService) {
        this.regEstudianteService = regEstudianteService;
    }

    //GETs
    //Listar todos los estudiantes registrados
    @GetMapping
    public ResponseEntity<?> listarTodosRegistrosE (){
        try{
            List<RegistroEstudiante> listaEstudiantes = regEstudianteService.listarTodosRegistrosE();
            return ResponseEntity.ok(listaEstudiantes);
        } catch (Exception e) {
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body("Error al listar estudiantes registrados");
        }

    }

    //Listar estudiante por id
    @GetMapping("/{id}")

    public ResponseEntity<?> buscarPorId(@PathVariable Integer id){
        try{
            Optional<RegistroEstudiante> estudianteBuscado = regEstudianteService.buscarRegistroEPorId(id);
            if(estudianteBuscado.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("El estudiante no ha sido encontrado");
            }
            return ResponseEntity.ok(estudianteBuscado.get());
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al buscar al estudiante por id");
        }
    }

    //Listar estudiantes por curso
    @GetMapping("/cursos/{curso}")
    public ResponseEntity<?> buscarPorCurso(@PathVariable String curso){
        try{
            List<RegistroEstudiante> listaEstudiantesCurso = regEstudianteService.listarRegistrosCurso(curso);
            return ResponseEntity.ok(listaEstudiantesCurso);
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al buscar estudiantes por curso");
        }
    }

    //POST
    //Agregar nuevo registro (estudiante)
    @PostMapping
    public ResponseEntity<?> agregarRegistroE(@Valid @RequestBody RegistroEstudiante registroEstudiante){
        try{
            RegistroEstudiante nuevoRegistro = regEstudianteService.agregarRegistroE(registroEstudiante);
            return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRegistro);
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al agregar al estudiante por id");
        }
    }

    //DELETE
    //Eliminar registro(Estudiante) por id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarRegistroPorId(@PathVariable Integer id){
        try{
            if(regEstudianteService.eliminarRegistroEPorId(id)){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
            }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El registro buscado por la id: " + id + " no ha sido encontrado");
        } catch (Exception e) {
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al eliminar al estudiante por id");
        }
    }

    //PUT
    //Actualizacion completa del registro(Estudiante)
    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarRegistroE (@PathVariable Integer id, @Valid @RequestBody RegistroEstudiante regActualizado){
        try{
            Optional<RegistroEstudiante> registroActualizado = regEstudianteService.actualizarRegistroE(id, regActualizado);
            if(registroActualizado.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La id del registro solicitado no existe");
            }
            return ResponseEntity.ok(registroActualizado.get());
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar el registro del estudiante");
        }
    }
}

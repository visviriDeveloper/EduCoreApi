package org.educoreapi.educoreapi.controller;

import org.educoreapi.educoreapi.service.RegistroEstudianteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/registroEstudiante")
public class RegistroEstudianteController {

    private final RegistroEstudianteService regEstudianteService;

    public RegistroEstudianteController(RegistroEstudianteService regEstudianteService) {
        this.regEstudianteService = regEstudianteService;
    }

    //GETs
    @GetMapping


}

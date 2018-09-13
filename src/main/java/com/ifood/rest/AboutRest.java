package com.ifood.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutRest {

    @GetMapping("/about")
    public ResponseEntity endpointCheck() {
        return ResponseEntity.status(HttpStatus.OK).body("nosso serviço está funcionando e recebendo requisições");
    }

}

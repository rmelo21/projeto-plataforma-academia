package br.com.academia.events.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
@EnableAutoConfiguration
public class ControllerAluno {

    @GetMapping(value = "/hello/{nome}")
    public String helloAluno (@PathVariable("nome") String nome)
    {
        return  String.format("Hello %s", nome);
    }

}

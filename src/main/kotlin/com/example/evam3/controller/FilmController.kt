package com.example.evam3.controller

import com.example.evam3.entity.Film
import com.example.evam3.service.FilmService
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
@CrossOrigin(methods = [RequestMethod.GET, RequestMethod.POST, RequestMethod.PATCH, RequestMethod.PUT, RequestMethod.DELETE])
@RestController
@RequestMapping("/film")
class FilmController {
    @Autowired
    lateinit var filmService: FilmService

    @GetMapping
    fun list (): ResponseEntity<*> {
        return ResponseEntity(filmService.list(), HttpStatus.OK)
    }

    @PostMapping
    fun save (@Valid @RequestBody film: Film): ResponseEntity<*> {
        return ResponseEntity<Film>(filmService.save(film), HttpStatus.CREATED)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):String?{
        return filmService.delete(id)
    }
}
package com.example.evam3.controller

import com.example.evam3.entity.Character
import com.example.evam3.entity.Film
import com.example.evam3.entity.Scene
import com.example.evam3.service.CharacterService
import com.example.evam3.service.FilmService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/character")
class CharacterController {
    @Autowired
    lateinit var characterService: CharacterService

    @GetMapping
    fun list (): ResponseEntity<*> {
        return ResponseEntity(characterService.list(), HttpStatus.OK)
    }

    @PostMapping
    fun save (@RequestBody character: Character): ResponseEntity<*> {
        return ResponseEntity(characterService.save(character), HttpStatus.CREATED)
    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):String?{
        return characterService.delete(id)
    }

}
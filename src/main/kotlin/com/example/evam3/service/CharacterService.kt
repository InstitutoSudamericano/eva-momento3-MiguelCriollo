package com.example.evam3.service

import com.example.evam3.entity.Character
import com.example.evam3.entity.Film
import com.example.evam3.entity.Scene
import com.example.evam3.repository.CharacterRepository
import com.example.evam3.repository.FilmRepository
import com.example.evam3.repository.SceneRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class CharacterService {
    @Autowired
    lateinit var characterRepository: CharacterRepository

    fun list (): MutableList<Character> {
        return characterRepository.findAll()
    }

    fun save (character: Character): Character {
        try{
            character.actor?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Film no debe ser vacio")
            return characterRepository.save(character)
        }
        catch (ex: Exception){
            throw ResponseStatusException(HttpStatus.BAD_REQUEST,ex.message)
        }

    }
}
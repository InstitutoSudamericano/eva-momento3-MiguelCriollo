package com.example.evam3.service

import com.example.evam3.entity.Character
import com.example.evam3.entity.CharacterScene
import com.example.evam3.entity.Film
import com.example.evam3.entity.Scene
import com.example.evam3.repository.CharacterRepository
import com.example.evam3.repository.CharacterSceneRepository
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

    @Autowired
    lateinit var sceneRepository: SceneRepository

    @Autowired
    lateinit var characterSceneRepository: CharacterSceneRepository

    fun list (): MutableList<Character> {
        return characterRepository.findAll()
    }

    fun save (character: Character): Character {
        var sceneModel=sceneRepository.findById(character.sceneId)
        character.scene=sceneModel
        var characterReponse=characterRepository.save(character)
        sceneModel?.character?.add(characterReponse)
        var sceneResponse= sceneModel?.let { sceneRepository.save(it) }
        return characterReponse

    }
    fun delete (id: Long):String?{
        try{
            val response = characterRepository.findById(id)
                ?: throw Exception("ID no existe")
            characterRepository.deleteById(id)
            return "ID eliminado Correctamente!!!"
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}
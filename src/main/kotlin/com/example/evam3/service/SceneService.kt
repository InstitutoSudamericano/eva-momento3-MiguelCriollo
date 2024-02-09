package com.example.evam3.service

import com.example.evam3.entity.Film
import com.example.evam3.entity.Scene
import com.example.evam3.repository.FilmRepository
import com.example.evam3.repository.SceneRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
class SceneService {
    @Autowired
    lateinit var sceneRepository: SceneRepository

    @Autowired
    lateinit var filmRepository: FilmRepository

    fun list (): MutableList<Scene> {
        return sceneRepository.findAll()
    }
    @Transactional
    fun save (scene:Scene): String{
        val filmModel=filmRepository.findById(scene.filmId);
        if (filmModel != null) {
            filmModel.scene.add(scene)
            var totalSceneBudget=0.0
            filmModel.scene.forEach {
                totalSceneBudget+=it.budget!!
            }
            if(totalSceneBudget>filmModel.budget){
                return "El precio de la escena supera el limite del budget"
            }
            val filmResponse=filmRepository.save(filmModel)
            scene.film=filmResponse;
            val sceneResponse=sceneRepository.save(scene)
            return "Nice"
        }
        return "No"

    }
    fun delete (id: Long):String?{
        try{
            val response = sceneRepository.findById(id)
                ?: throw Exception("ID no existe")
            sceneRepository.deleteById(id)
            return "ID eliminado Correctamente!!!"
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

}
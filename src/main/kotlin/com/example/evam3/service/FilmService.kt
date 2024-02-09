package com.example.evam3.service

import com.example.evam3.entity.Film
import com.example.evam3.repository.FilmRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class FilmService {
    @Autowired
    lateinit var filmRepository: FilmRepository

    fun list ():List<Film>{
        return filmRepository.findAll()
    }

    fun save (film:Film): Film{
        val possibleFilm=filmRepository.findById(film.id)
        if(possibleFilm===null){
            return filmRepository.save(film)
        }else{
            film.scene=possibleFilm.scene
            return filmRepository.save(film)
        }

    }
    fun delete (id: Long):String?{
        try{
            val response = filmRepository.findById(id)
                ?: throw Exception("ID no existe")
            filmRepository.deleteById(id)
            return "ID eliminado Correctamente!!!"
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}
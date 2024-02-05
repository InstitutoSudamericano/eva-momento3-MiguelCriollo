package com.example.evam3.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

@Entity
@Table (name="film")
class Film {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    @NotBlank(message="El titulo del Filme es obligatorio")
    var title: String? = null

    @NotBlank(message="El Nombre el Director es Obligatorio")
    var director: String? = null

    @NotNull(message="La pelicula debe tener duracion")
    var duration: Long? = null

    @NotNull(message="La pelicula debe tener un presupuesto")
    var budget:Double=0.0

    @JsonIgnore
    @OneToMany(mappedBy = "film",cascade = [CascadeType.ALL], orphanRemoval = true)
    var scene: MutableSet<Scene> = mutableSetOf()

}
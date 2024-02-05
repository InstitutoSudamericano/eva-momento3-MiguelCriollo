package com.example.evam3.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
@Table (name="character_scene")
class CharacterScene {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    @NotBlank(message="El actor debe tener minutos de Escenas")
    @Column(name = "character_minutes")
    var characterMinutes: Int? = null

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "character_id")
    var character: Character? = null

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "scene_id")
    var scene: Scene? = null
}
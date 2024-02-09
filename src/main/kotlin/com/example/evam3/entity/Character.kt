package com.example.evam3.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull

@Entity
@Table (name="character")
class Character {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    @NotBlank(message="El nombre de Actor es Obligatorio")
    var actor: String? = null

    var description: String? = null

    @NotNull(message="El Actor debe tener un Precio por Minuto")
    @Column(name = "price_minute")
    var priceMinute: Double? = null

    @Transient
    var sceneId:Long?=null

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "scene_id",referencedColumnName = "id")
    var scene:Scene? = null
}
package com.example.evam3.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

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

    @NotBlank(message="El Actor debe tener un Precio por Minuto")
    @Column(name = "price_minute")
    var priceMinute: Double? = null

    @JsonIgnore
    @OneToMany(mappedBy = "character",cascade = [CascadeType.ALL], orphanRemoval = true)
    var characterScene:MutableSet<CharacterScene> = mutableSetOf()
}
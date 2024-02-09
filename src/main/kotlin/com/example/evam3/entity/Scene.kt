package com.example.evam3.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonManagedReference
import jakarta.persistence.*
import jakarta.validation.constraints.NotBlank

@Entity
@Table (name="scene")
class Scene {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    @NotBlank(message="El nombre de Actor es Obligatorio")
    var title: String? = null
    var description: String? = null

    var budget: Double?=null

    var minutes: Int? = null

    @Transient
    var filmId: Long? = null

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "film_id",referencedColumnName = "id")
    var film:Film?=null

    @JsonManagedReference
    @OneToMany(mappedBy = "scene",cascade = [CascadeType.ALL], orphanRemoval = true)
    var character:MutableSet<Character> = mutableSetOf()
}
package com.adventiel.demokotlin

import com.adventiel.demokotlin.model.Cow
import com.adventiel.demokotlin.repository.CowRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class DatabaseInitializer(
        private val cowRepository: CowRepository
) : CommandLineRunner {
    override fun run(vararg args: String) {
        val marguerite = Cow("Marguerite", LocalDateTime.of(2017, 9, 28, 13, 30))
        val laNoiraude = Cow("La Noiraude")
        cowRepository.deleteAll()
                .block()
        cowRepository.saveAll(listOf(marguerite, laNoiraude))
                .blockLast()
        println("inserting $marguerite and $laNoiraude")
    }
}
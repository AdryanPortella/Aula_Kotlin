package main

import modelo.*
import criador.CriadorDePersonagem
import criador.CriadorDePersonagemPadrao

fun main() {
    val racas = mapOf(
        "Humano" to Humano(),
        "Elfo" to Elfo(),
        "Anão" to Anao(),
        "Meio-Elfo" to MeioElfo()
    )

    println("Selecione a raça:")
    racas.keys.forEach { println(it) }

    val racaSelecionada = readLine()?.capitalize() ?: ""

    if (!racas.containsKey(racaSelecionada)) {
        println("Raça inválida.")
        return
    }

    val raca = racas[racaSelecionada]!!
    val criador: CriadorDePersonagem = CriadorDePersonagemPadrao()
    val personagem = criador.criarPersonagem(raca)

    println("Atributos com aplicação de bônus de raça:")
    personagem.atributos.forEach { (atributo, valor) ->
        println("$atributo: $valor")
    }

    val pontosDeVida = personagem.calcularPontosDeVida()
    println("Pontos de vida: $pontosDeVida")
}

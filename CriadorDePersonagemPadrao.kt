package criador

import modelo.Personagem
import modelo.Raca

class CriadorDePersonagemPadrao : CriadorDePersonagem {
    override fun criarPersonagem(raca: Raca): Personagem {
        val atributos = mutableMapOf(
            "Força" to 8,
            "Destreza" to 8,
            "Constituição" to 8,
            "Inteligência" to 8,
            "Sabedoria" to 8,
            "Carisma" to 8
        )

        val personagem = Personagem(atributos, raca)
        personagem.aplicarBonusDeRaca()

        val pontos = 27
        personagem.distribuirPontos(pontos)

        return personagem
    }
}

package criador

import modelo.Personagem
import modelo.Raca

interface CriadorDePersonagem {
    fun criarPersonagem(raca: Raca): Personagem
}

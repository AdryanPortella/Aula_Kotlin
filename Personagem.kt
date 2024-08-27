package modelo

class Personagem(var atributos: MutableMap<String, Int>, val raca: Raca) {
    fun aplicarBonusDeRaca() {
        raca.bonus.forEach { (atributo, bonus) ->
            atributos[atributo] = atributos[atributo]!! + bonus
        }
    }

    fun distribuirPontos(pontos: Int) {
        var pontosRestantes = pontos
        while (pontosRestantes > 0) {
            println("Você tem $pontosRestantes pontos sobrando.")
            println("Atributos:")
            atributos.forEach { (atributo, valor) ->
                println("$atributo: $valor")
            }

            println("Informe o atributo que deseja aumentar:")
            val atributo = readLine()?.capitalize() ?: ""
            if (!atributos.containsKey(atributo)) {
                println("Atributo não existe.")
                continue
            }

            println("Quantos pontos para o atributo $atributo?")
            val pontosInput = readLine()?.toIntOrNull()

            if (pontosInput == null || pontosInput <= 0) {
                println("Entrada inválida.")
                continue
            }

            if (pontosRestantes >= pontosInput && (atributos[atributo]!! + pontosInput) <= 15) {
                atributos[atributo] = atributos[atributo]!! + pontosInput
                pontosRestantes -= pontosInput
            } else {
                println("Sem pontos suficientes ou limite (15) alcançado.")
            }
        }
    }

    fun calcularPontosDeVida(): Int {
        val constituicao = atributos["Constituição"] ?: 0
        val modificadorDeConstituicao = (constituicao - 10) / 2
        return 10 + modificadorDeConstituicao
    }
}

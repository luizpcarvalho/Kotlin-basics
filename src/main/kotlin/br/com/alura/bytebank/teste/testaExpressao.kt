package br.com.alura.bytebank.teste

fun testaExpressao() {
    println("início main")
    val entrada: String = "1.0"


    val valor: Double? = try {
        entrada.toDouble()
    } catch (e: NumberFormatException) {
        println("Problema na conversão")
        e.printStackTrace()
        null
    }

    val valorComTaxa: Double? = if (valor != null) {
        valor + 0.1
    } else {
        null
    }

    if (valorComTaxa != null) {
        println("valor recebido: $valorComTaxa")
    } else {
        println("valor inválido.")
    }

    funcao1()
    println("fim main")
}


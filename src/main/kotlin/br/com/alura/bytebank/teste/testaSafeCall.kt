package br.com.alura.bytebank.teste

import br.com.alura.bytebank.modelo.Endereco
import java.lang.IllegalStateException

fun testaSafeCall() {

    var enderecoNulo: Endereco? = Endereco(logradouro = "Rua 1", complemento = "prédio")
    println(enderecoNulo?.logradouro?.length) // safe call operator
    enderecoNulo?.let { endereco: Endereco ->
        println(endereco.logradouro.length) // sem a fun lambda ( -> ) use a referência it
        val tamanhoComplemento: Int =
            endereco.complemento?.length ?: throw IllegalStateException("Complemento não deve ser vazio")
        println(tamanhoComplemento)
    }
    teste("")

}

fun teste(valor: Any) {
    val numero: Int? = valor as? Int
    println(numero)
}
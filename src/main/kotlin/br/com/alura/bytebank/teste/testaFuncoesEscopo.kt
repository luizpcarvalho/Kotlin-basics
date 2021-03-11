package br.com.alura.bytebank.teste

import br.com.alura.bytebank.modelo.Autenticavel
import br.com.alura.bytebank.modelo.Endereco
import br.com.alura.bytebank.modelo.SistemaInterno

fun testaFuncoesEscopo() {
    //    val endereco = Endereco(logradouro = "Rua Vergueiro", numero = 3185)
//    val enderecoEmMaiusculo = "${endereco.logradouro}, ${endereco.numero}".toUpperCase()
//    println(enderecoEmMaiusculo)

    val endereco = Endereco()
        .also { println("Criando endereço") }
        .apply {
            logradouro = "Rua Vergueiro"
            numero = 3185
        }
        .let(::println)

    val enderecoEmMaiusculo = Endereco(logradouro = "Rua Vergueiro", numero = 3185)
        .run {
            "$logradouro, $numero".toUpperCase()
        }.let(::println)

    listOf(Endereco(complemento = "casa"), Endereco(), Endereco(complemento = "apartamento"))
        .filter { endereco -> endereco.complemento.isNotEmpty() }
        .let(block = ::println)
}
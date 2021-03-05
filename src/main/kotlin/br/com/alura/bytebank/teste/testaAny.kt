package br.com.alura.bytebank.teste

import br.com.alura.bytebank.modelo.Cliente
import br.com.alura.bytebank.modelo.Endereco

fun testaAny() {
    val teste = Endereco(logradouro = "Rua 1", complemento = "Alura")

    println()
    println(1)
    println(1.0)
    println(true)
    println("teste")
    println(teste)

    val cliente: Any = Cliente(nome = "Luiz", cpf = "08168689640", Endereco(), senha = 1000)
    imprime(1)
    imprime(1.0)
    imprime(true)
    imprime("teste")
    imprime(cliente)

    val endereco = Endereco(logradouro = "Rua 1", complemento = "Alura", cep = "11111-111")
    val enderecoNovo = Endereco(logradouro = "Rua 2", complemento = "Caelum", cep = "11111-111")

    println(endereco.equals(enderecoNovo))
    println(endereco.hashCode())
    println(enderecoNovo.hashCode())
    println(endereco)
}

fun imprime(valor: Any): Any {
    println(valor)
    return valor
}
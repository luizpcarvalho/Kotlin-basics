import br.com.alura.bytebank.modelo.Cliente
import br.com.alura.bytebank.modelo.ContaPoupanca
import br.com.alura.bytebank.modelo.Endereco
import br.com.alura.bytebank.teste.testaHighOrderFunction

fun main() {
    testaHighOrderFunction()
}

fun testaRun() {
    val taxaAnual = 0.05
    val taxaMensal = taxaAnual / 12
    println("Taxa mensal $taxaMensal")

    val contaPoupanca = ContaPoupanca(Cliente(nome = "Alex", cpf = "111.111.111-11", senha = 1234), 1000)

    contaPoupanca
        .run {
            deposita(1000.0)
            saldo * taxaMensal
        }
        .let { rendimentoMensal ->
            println("Rendimento mensal: $rendimentoMensal")
        }

    val rendimentoAnual = run {
        var saldo = contaPoupanca.saldo
        repeat(12) {
            saldo += saldo * taxaMensal
        }
        saldo
    }
    println("Simulação do rendimento anual: $rendimentoAnual")
}

fun testaWith() {
    with(Endereco()) {
        logradouro = "Rua Vergueiro"
        numero = 3185
        bairro = "Vila Mariana"
        cidade = "São Paulo"
        estado = "SP"
        cep = "02310-063"
        complemento = "Apartamento"
        completo()
    }.let { enderecoCompleto: String ->
        println(enderecoCompleto)
    }
}
import br.com.alura.bytebank.modelo.*

fun testaContasDiferentes() {

    val alex = Cliente(nome = "Alex", cpf = "", senha = 1, endereco = Endereco(logradouro = "Rua 1"))
    val contaCorrente = ContaCorrente(alex, 1000)
    val fran = Cliente(nome = "Fran", cpf = "", senha = 2)
    val contaPoupanca = ContaPoupanca(fran, 1001)

    println(contaCorrente.titular.endereco.logradouro)

    contaCorrente.deposita(1000.0)
    contaPoupanca.deposita(1000.0)

    println("Saldo corrente: ${contaCorrente.saldo}")
    println("Saldo poupança: ${contaPoupanca.saldo}")

    contaCorrente.saca(100.0)
    contaPoupanca.saca(100.0)

    println("Saldo após saque corrente: ${contaCorrente.saldo}")
    println("Saldo após saque poupança: ${contaPoupanca.saldo}")

    contaCorrente.transfere(100.0, contaPoupanca, 1)

    println("Saldo corrente após transferir para poupança: ${contaCorrente.saldo}")
    println("Saldo poupança após receber transferência: ${contaPoupanca.saldo}")

    contaPoupanca.transfere(100.0, contaCorrente, 2)

    println("Saldo poupança após transferir para corrente: ${contaPoupanca.saldo}")
    println("Saldo corrente após receber transferência: ${contaCorrente.saldo}")
}
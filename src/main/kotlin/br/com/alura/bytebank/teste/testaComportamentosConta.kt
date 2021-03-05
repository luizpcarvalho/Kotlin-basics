import br.com.alura.bytebank.exception.FalhaAutenticacaoException
import br.com.alura.bytebank.exception.SaldoInsuficienteException
import br.com.alura.bytebank.modelo.Cliente
import br.com.alura.bytebank.modelo.ContaCorrente
import br.com.alura.bytebank.modelo.ContaPoupanca
import br.com.alura.bytebank.modelo.ContaSalario
import java.lang.Exception

fun testaComportamentosConta() {
    val alex = Cliente(nome = "Alex", cpf = "", senha = 1)
    val contaAlex = ContaCorrente(titular = alex, numero = 1000)
    contaAlex.deposita(200.0)
    println(contaAlex.titular)
    println(contaAlex.numero)
    println(contaAlex.saldo)

    val fran = Cliente(nome = "Fran", cpf = "", senha = 2)
    val contaFran = ContaPoupanca(numero = 1001, titular = fran)
    contaFran.deposita(300.0)
    println(contaFran.titular)
    println(contaFran.numero)
    println(contaFran.saldo)

    println("Depositando na conta do Alex:")
    contaAlex.deposita(50.0)
    println(contaAlex.saldo)

    println("Depositando na conta da Fran:")
    contaFran.deposita(70.0)
    println(contaFran.saldo)

    println("Sacando na conta do Alex")
    contaAlex.saca(250.0)
    println(contaAlex.saldo)

    println("Sacando na conta da Fran")
    contaFran.saca(100.0)
    println(contaFran.saldo)

    println("Saque em excesso")
    contaAlex.saca(100.0)
    println(contaAlex.saldo)

    println("Transferência da conta da ${contaFran.titular.nome} para o ${contaAlex.titular.nome}")
    try {
        contaFran.transfere(30.0, contaAlex, 2)
        println("Transferência bem sucedida.")
    } catch (e: SaldoInsuficienteException) {
        println("Falha na transferência.")
        println("Saldo insuficiente.")
        e.printStackTrace()
    } catch (e: FalhaAutenticacaoException) {
        println("Falha na transferência.")
        println("Falha na autenticação.")
        e.printStackTrace()
    } catch (e: Exception) { // lidando com erros desconhecidos
        println("Erro desconhecido.")
        e.printStackTrace()
    }

    val gui = Cliente(nome = "Gui", cpf = "", senha = 3)
    val contaSalario = ContaSalario(titular = gui, numero = 1002)
    contaSalario.deposita(200.0)

    println(contaAlex.saldo)
    println(contaFran.saldo)
}
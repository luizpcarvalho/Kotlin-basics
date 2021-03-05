package br.com.alura.bytebank.modelo

abstract class Conta(
    val titular: Cliente,
    val numero: Int
) : Autenticavel by titular { // delega a implementação da autenticação para a implementação existente em Cliente
    var saldo = 0.0
        protected set

    companion object Contador {
        var total = 0
            private set
    }

    init {
        total++
    }

    fun deposita(valor: Double) {
        if (valor > 0) {
            this.saldo += valor
        }
    }

    abstract fun saca(valor: Double)

}
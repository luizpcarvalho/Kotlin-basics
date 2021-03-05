package br.com.alura.bytebank.modelo

class ContaSalario(
    titular: Cliente,
    numero: Int
) : Conta(
    titular = titular,
    numero = numero
) {
    override fun saca(valor: Double) {
        if(this.saldo >= valor) {
            this.saldo -= valor
        }
    }
}
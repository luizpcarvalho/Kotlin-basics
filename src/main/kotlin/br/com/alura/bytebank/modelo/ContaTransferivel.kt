package br.com.alura.bytebank.modelo

import br.com.alura.bytebank.exception.FalhaAutenticacaoException
import br.com.alura.bytebank.exception.SaldoInsuficienteException

abstract class ContaTransferivel(
    titular: Cliente,
    numero: Int
) : Conta(
    titular = titular,
    numero = numero
) {

    fun transfere(valor: Double, destino: ContaTransferivel, senha: Int) {
        if (saldo < valor) {
            throw SaldoInsuficienteException(mensagem =
            "Saldo insuficiente. Saldo atual: $saldo, valor a ser subtraído: $valor.")
        }

        if(!autentica(senha)) {
            throw FalhaAutenticacaoException()
        }

        this.saldo -= valor
        destino.deposita(valor)
    }
}
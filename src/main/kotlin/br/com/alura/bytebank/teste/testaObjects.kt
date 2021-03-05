package br.com.alura.bytebank.teste

import br.com.alura.bytebank.modelo.Autenticavel
import br.com.alura.bytebank.modelo.SistemaInterno

private fun testaObjects() {
    val joao = object : Autenticavel {
        val nome: String = "João"
        val cpf: String = "111.111.111-11"
        val senha: Int = 1000

        override fun autentica(senha: Int): Boolean = this.senha == senha
    }

    val sistemaInterno = SistemaInterno()
    sistemaInterno.entra(joao, 1000)
}
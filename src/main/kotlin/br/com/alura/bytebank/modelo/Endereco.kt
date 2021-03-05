package br.com.alura.bytebank.modelo

class Endereco(
    val logradouro: String = "",
    val numero: Int = 0,
    val bairro: String = "",
    val cidade: String = "",
    val estado: String = "",
    val cep: String = "",
    val complemento: String = ""
) {


    override fun toString(): String {
        // usando raw string
        return """Endereco(logradouro='$logradouro', 
            |numero=$numero, 
            |bairro='$bairro', 
            |cidade='$cidade', 
            |estado='$estado', 
            |cep='$cep', 
            |complemento='$complemento')""".trimMargin()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Endereco

        if (cep != other.cep) return false

        return true
    }

    override fun hashCode(): Int {
        return cep.hashCode()
    }
}

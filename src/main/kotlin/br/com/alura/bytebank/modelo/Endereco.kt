package br.com.alura.bytebank.modelo

class Endereco(
    var logradouro: String = "",
    var numero: Int = 0,
    var bairro: String = "",
    var cidade: String = "",
    var estado: String = "",
    var cep: String = "",
    var complemento: String = ""
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

    fun completo(): String {
        return """
            $logradouro - $numero, $bairro, $cidade - $estado
            $cep
            $complemento
        """.trimIndent()
    }
}

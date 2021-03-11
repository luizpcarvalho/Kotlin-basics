package br.com.alura.bytebank.teste

fun testaFuncaoAnonima() {
    val minhaFuncaoAnonima: (Int, Int) -> Int = fun(a, b): Int {
        return a + b
    }
    println(minhaFuncaoAnonima(20, 10))


    val calculaBonificacaoAnonima: (salario: Double) -> Double = fun(salario): Double {
        if (salario > 1000.0) {
            return salario + 50.0
        }
        return salario + 100.0
    }
    println(calculaBonificacaoAnonima(1100.0))
}

fun testaFuncaoLambda() {
    val minhaFuncaoLambda = { a: Int, b: Int ->
        a + b // a última instrução de uma expressão lambda é seu retorno
    }
    println(minhaFuncaoLambda(15, 10))

    // multiplos retornos em função lambda
    val calculaBonificacao: (salario: Double) -> Double = lambda@{ salario ->
        if (salario > 1000.0) {
            return@lambda salario + 50.0
        }
        return@lambda salario + 100.0
    }
    println(calculaBonificacao(1000.0))
}

fun testaTipoFuncaoClasse() {
    val minhaFuncaoClase: (Int, Int) -> Int = Soma()
    println(minhaFuncaoClase(10, 10))
}

fun testaTipoFuncaoReferencia() {
    //val minhaFuncao = ::teste
    val minhaFuncao: (Int, Int) -> Int = ::soma
    println(minhaFuncao(5, 10))
}

fun soma(a: Int, b: Int): Int {
    return a + b
}

class Soma: (Int, Int) -> Int {
    override fun invoke(a: Int, b: Int): Int = a + b
}
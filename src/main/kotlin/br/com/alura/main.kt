package br.com.alura

fun main() {

    val banco = BancoDeNomes()
//    banco.nomes.sal("Alex")
    banco.salva("Alex")
    println(banco.nomes)
    println(BancoDeNomes().nomes)
}

class BancoDeNomes {

    companion object {
        private val dados = mutableListOf<String>()
    }

    val nomes: Collection<String> get() = Companion.dados

    fun salva(nome: String) {
        Companion.dados.add(nome)
    }
}

fun testaCollection() {
    val nomes: Collection<String> = mutableListOf("Alex", "Fran", "Gui", "Maria", "Ana")

    for (nome: String in nomes) {
        println(nomes)
    }

//    nomes.add("Marcelo")
    println(nomes)
    println(("Contém o nome? ${nomes.contains("Marcelo")}"))
    println("O tamanho da lista é: ${nomes.size}")
//    nomes.remove("Marcelo")
    println(nomes)
    println("O tamanho da lista é: ${nomes.size}")
}
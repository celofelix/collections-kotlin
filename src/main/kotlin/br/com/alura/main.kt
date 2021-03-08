package br.com.alura

fun main() {

    val banco = BancoDeNomes()
    println(banco.nomes)
    val nomesSalvos: Collection<String> = banco.nomes
//    banco.nomes.sal("Alex")
    banco.salva("Alex")
    println("Variável com a cópia $nomesSalvos")
    println(BancoDeNomes().nomes)
}

class BancoDeNomes {

    companion object {
        private val dados = mutableListOf<String>()
    }

    val nomes: Collection<String> get() = Companion.dados.toList()

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
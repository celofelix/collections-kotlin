package br.com.alura

fun main() {

    val assistiramCursoAndroid: MutableSet<String> = mutableSetOf("Alex", "Fran", "Gui", "Maria")
    val assistiramCursoKotlin: MutableList<String> = mutableListOf("Alex", "Paulo", "Maria")

    /*
    É possível fazer a atribuição dos elementos através de uma soma
    O operador de + é uma abstração para o método plus()
    O retorno ao usar o método plus() ou o operador + depende da ordem da coleção
    Nesse caso o retorno será de um Set
    Caso a coleção List estivesse na frente seria o retorno seria um Set
    Outro ponto é que a coleção devolvida sempre será uma do tipo imútavel
    Caso queira realizar modificações futuras deve ser feito a atribuição através do método addAll()
    O set não permite valores repetidos
    Exemplo de atribuição com operador +
    val assistiramAmbos: Set<String> = assistiramCursoAndroid + assistiramCursoKotlin

    */

    val assistiramAmbos: MutableSet<String> = mutableSetOf()
    assistiramAmbos.addAll(assistiramCursoAndroid)
    assistiramAmbos.addAll(assistiramCursoKotlin)
    println(assistiramAmbos)




}
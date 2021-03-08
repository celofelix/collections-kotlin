package br.com.alura

fun testaSet() {
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
    assistiramAmbos.add("Ana")
    assistiramAmbos.add("Ana")
    println(assistiramAmbos)

    /*
    Também existe outra forma de adicionar valores a um set além do operador +
    A coleção Set existe um método chamado union() que pode ser usado para essa adição
    O método union ele tem a caracterisca infix, ou seja, pode ser usada sem o ponto após a variavel
    */
    println(assistiramCursoAndroid.union(assistiramCursoKotlin))
    println(assistiramCursoAndroid union assistiramCursoKotlin)

    /*
    Também pode ser feito operação de substração com o operador -
    O valor retornado será apenas dos valores que não se repetem nas coleções
    A ordem que foi passada para a operação impacta no resultado
    E para o operador de substração, temos o método subtract() e também pode ser usado como infix
     */

    println(assistiramCursoKotlin - assistiramCursoAndroid)
    println(assistiramCursoKotlin subtract assistiramCursoAndroid)
    println(assistiramCursoAndroid - assistiramCursoKotlin)

    /*
    Além dos operadores de soma e substração e seus métodos union e subtract
    No set também existe o método intersect(). Ele serve para pegar apenas os valores em comuns nas coleções
    Ele também pode ser usado com infix
     */

    println(assistiramCursoAndroid intersect assistiramCursoKotlin)

    /*
    Também é possível fazer cópias de uma váriavel do tipo Set usando os métodos de cópias
    Com os métodos de cópia, a cópia não é feita por referência, assim uma variavel não impacta na outra
    Assim é possível copiar os valores de uma coleção set para uma variável que pode até mesmo ser outro tipo
     */

    val assistiramList = assistiramAmbos.toMutableList()
    assistiramList.add("Alex")
    println(assistiramList)

    println(assistiramList.toSet())
}
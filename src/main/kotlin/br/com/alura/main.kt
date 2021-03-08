package br.com.alura

fun main() {
    /*
    Um Map ele é composto de uma chave e um valor. A chave é como se fosse o indice do valor
    Mas esse indice ao invés de ser sempre um int como na List, você pode atribuir oque quiser.
    As chaves nunca se repetem, mas os valores que está com a chave pode se repetir
    Para criar o Map precisamos sempre informar a chave e seu valor.
    Para ser entendido como um par a chave e o valor deve ser passado para a classe Pair
    Existe a forma de operador infix para diminuir a quantia de código.
    O operador é o to. Ele deve estar entre a chave e o valor
     */
    val pedidos: MutableMap<Int, Double> = mutableMapOf<Int, Double>(
            Pair(1, 20.0),
            Pair(2, 34.0),
            3 to 50.0)

    println(pedidos)

    /*
    Os compotamentos como o de leitura de um valor através da chave deve-se tomar alguns cuidados
    Por exemplo, se tentar acessar uma chave que não existe, vai ser devolvido um null
    Por isso é importante fazer uma safe call, assim evitamos retorno de valores nulos
     */
    val pedido: Double? = pedidos[5]
    pedido?.let {
        println("pedido $it")
    }

    for (p in pedidos) {
        println("Código pedido: ${p.key}" + " Valor do pedido: ${p.value}")
    }

    /*
    Comportamento de escrita como o de inserção pode ser feito informar uma chave dentro de colchetes
    A outra forma para adicionar um novo valor ao Map é através do método put()
    Com o método put() basta informar dentro do parenteses a nova chave e o valor
    Além de adicionar essas formas servem para atualizar um registro existente dentro do Map
    Se a chave informada já exista ele irá atualizar ao invés de inserir um novo registro.
    Caso queira adicionar um valor somente se a chave não existir você pode usar o método putIfAbsent()
    Com o método utIfAbsent() o valor só será adicionado se a chave não existir
     */

    pedidos[4] = 70.0
    println(pedidos)
    pedidos.put(5,50.0)
    println(pedidos)
    pedidos[1] = 100.0
    pedidos.putIfAbsent(6, 200.0)
    println(pedidos)
    pedidos.putIfAbsent(6, 200.0)
    println()

    /*
    Também é possível remover um valor de um Map através da sua chave
    Existe o método remove() que basta informar a chave e assim ele irá deletar
    O método remove também existe a sobrecarga para passar a chave e o valor
    A remoção só será feita caso a chave e o valor estejam corretos, caso contrario não será removido
     */
    pedidos.remove(6)
    println(pedidos)
    pedidos.remove(3, 100.0)


}


package br.com.alura

fun main() {

    testaMap()

}

fun testaMap() {
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
            Pair(2, 64.0),
            3 to 50.0,
            4 to 100.0,
            5 to 150.0,
            6 to 80.0
    )

    /*
    Para acessar o valor de uma chave podemos usar o método get() ou getValue()
    O método get() caso a chave informada não exista ele sempre irá retornar null
    Já o método getValue() caso a chave informada não existe ele irá retornar uma exception
    A exceção NoSuchElementException que é retornada irá nos informar que a chave não existe
     */
    val valorPedido = pedidos.getValue(4)

    /*
    Temos também o método getOrElse() para pegar o valor de uma chave
    O comportamento desse método é de retornar algo caso a chave não exista
    O retorno é implementado no momento do uso do método
    Nesse exemplo o retorno será uma mensagem
     */
    println(pedidos.getOrElse(5, {
       "Chave informada não existe"
    }))

    /*
    Mais uma forma de pegar o valor a partir de uma chave é com o método getOrDefault()
    Ele tem um comportamento parecido com o getOrElse().
    Com o getOrDefault() você pode definir um valor para o retorno caso a chave não exista
    A diferença para o getOrElse() é que o valor do retorno deve ser do mesmo tipo do valor do Map
    Nesse exemplo o valor do Map é Double e está sendo retornada um Double
     */
    println(pedidos.getOrDefault(5, -1.0))

    /*
    Outra coisa que é possível fazer com o Map é acessar somente as chaves
    E assim conseguimos verificar todas as chaves existentes dentro de um Map
    Para isso é só usar .key a variavél que é do tipo Map
    E com esse acesso, podemos até mesmo usar um for para percorrer somente as chaves
     */
    println(pedidos.keys)
    for (numero in pedidos.keys){
        println("Código do pedido: $numero")
    }

    /*
    Assim como podemos acessar todas as chaves, podemos acessar todos os valores
    Para isso também basta acessar a variável que é do tipo Map e usar o .values
    Assim podemos imprimir todos os valores e percorrer com um for todos os valores
     */

    println(pedidos.values)
    for (valores in pedidos.values) {
        println("Valor do pedido: $valores")
    }

    /*
    Com o Map podemos filtrar valores a partir do método filter{}
    Mas para isso é sempre necessário informar sua chave e valor em conjunto
    O filter ele recebe uma expressão boolean, ou seja, true ou false
    Os valores retornados serão apenas os que satisfazerem a condição
     */
    val pedidosFiltrados = pedidos.filter { (numero, valor) ->
        numero % 2 == 0 && valor > 50.0
    }

    println("Pedidos filtrados $pedidosFiltrados")

    /*
    No filto anterior fizemos um filtro com a chave e o valor
    Mas também existe os métodos que filtram somente pela chave ou pelo valor
    O método para filtrar somente pela chave é o filterKeys{}
    E o método para filtrar somente pelo valor é o filterValues{}
     */
    val pedidosAcima = pedidos.filterKeys { numero ->
        numero % 2 == 0
    }

    println("Pedido de números pares: $pedidosAcima")

    val valoresAcima = pedidos.filterValues { valor ->
        valor > 70
    }
    println("Pedidos com valores acima de R$ 70.00 $valoresAcima")

    println(valorPedido)

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
    pedidos.put(5, 50.0)
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


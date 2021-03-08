package br.com.alura

fun testaAssociacao() {
    val pedidos = listOf(
            Pedido(1, 20.0),
            Pedido(2, 60.0),
            Pedido(3, 30.0),
            Pedido(4, 40.0)
    )

    println("Pedido na List: $pedidos")
    /*
    A função associate é usada quando queremos transformar uma coleção em um Map
    Dessa forma conseguimos criar um map que cada chave pode possuir um objeto
    Nesse exemplo foi criado uma List de objetos do tipo Pedido
    Com a função associate foi transformado em um Map
    Para fazer uso do associate{} precisamos passar um parâmetro de entrada
    E na expressão lambda um Pair() ou usar o operador infix to
    Com um desses dois precisamos informar oque esperamos como resultado
    Nesse caso a chave vai ser o número do pedido do objeto
    Já o seu valor é o próprio objeto pedido contendo o número e valor do pedido
    O retorno do associate é sempre um Map
    O associate sempre retorna um novo Map sem alterar o original
     */
    val pedidoMapeado: Map<Int, Pedido> = pedidos.associate { pedido: Pedido ->
        pedido.numero to pedido
    }

    println("Pedido transformado em um Map: $pedidoMapeado")
    println("Acessando o pedido do Map pela chave: $pedidoMapeado[1]")

    /*
    Temos também o associateWith para transformar para um Map
    O associateWith{} a chave sempre será o valor da coleção passada.
    No nosso caso a chave será o próprio objeto da classe Pedido
    Já o valor(value) do Map será de acordo a expressão fornecida
    No nosso exemplo vamos fazer os valores serem do tipo Boolean
    Caso o valor do pedido seja maior que > 50 o valor(value) dele no Map será true
     */

    val pedidosFretGratis: Map<Pedido, Boolean> = pedidos.associateWith { pedido: Pedido ->
        pedido.valor > 50
    }

    println("Pedidos com Fret Grátis $pedidosFretGratis")
    /*
     Para pesquisar um valor pela chave em Map onde a chave é um objeto...
     ...é preciso ter o equals e hashcode implementado
     Assim é preciso ser passados os valores do objeto para a pesquisa
     */
    println(pedidosFretGratis[Pedido(numero = 1, valor = 20.0)])

    val pedidosFreteGratisAgrupados = pedidos.groupBy { pedido: Pedido ->
        pedido.valor > 50
    }

    println("Map com chave Boolean usando groupBy $pedidosFreteGratisAgrupados")

    val nomes = listOf(
            "Alex",
            "Fran",
            "Gui",
            "Ana",
            "Paulo",
            "Maria",
            "Mario",
            "Gisele"
    )

    val agenda: Map<Char, List<String>> = nomes.groupBy { nome: String ->
        nome.first()
    }
    println("Map usando o groupby: $agenda")
}

data class Pedido(val numero: Int, val valor: Double)
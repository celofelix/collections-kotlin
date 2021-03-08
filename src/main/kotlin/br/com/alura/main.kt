@file:Suppress("NAME_SHADOWING")

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
    val pedidos: Map<Int, Double> = mapOf<Int, Double>(Pair(1, 20.0), Pair(2, 34.0), 3 to 50.0)
    println(pedidos)

    /*
    Ao fazer o acesso como o de leitura de um valor através da chave deve-se tomar alguns cuidados
    Por exemplo, se tentar acessar uma chave que não existe, vai ser devolvido um null
    Por isso é importante fazer uma safe call, assim evitamos retorno de valores nulos
     */
    val pedido: Double? = pedidos[5]
    pedido?.let {
        println("pedido $it")
    }

   for(pedido in pedidos) {
       println("Número do pedido: ${pedido.key}" + " Valor do pedido: ${pedido.value}")
   }
}


import kotlinx.coroutines.*

fun main()  {

    val gestor = GestorPedidos()

    gestor.mostrarCatalogo()

    gestor.seleccionarProductos()

    print("Ingrese su tipo de cliente (regular, vip, premium): ")
    print("")
    var tipoCliente = readLine()
    if (tipoCliente.isNullOrBlank()) {
        tipoCliente = "regular"
    }
    GlobalScope.launch {

        gestor.procesarPedido()
        gestor.mostrarPedido(tipoCliente)
        gestor.pedidoListo()

    }

    Thread.sleep(5000L)
}
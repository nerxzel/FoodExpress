import kotlinx.coroutines.*

class GestorPedidos {

    val inventarioMapa: Map<Int, Producto>

    var carroCompra: MutableList<Producto> = mutableListOf()

    init {
        val comida1 = Comida("Hamburguesa clásica", 5000, 10, false)
        val comida2 = Comida("Hamburguesa vegana", 8000, 15, true)
        val comida3 = Comida("Puré con papas fritas", 10000, 20, false)
        val comida4 = Comida("Puré con papas duquesa", 15000, 25, true)
        val bebida1 = Bebida("Coca-Cola", 1500, 5, TamanhoBebida.Mediano)
        val bebida2 = Bebida("Fanta", 1500, 5, TamanhoBebida.Grande)
        val bebida3 = Bebida("Pepsi", 1500, 5, TamanhoBebida.Pequenho)
        val bebida4 = Bebida("Crush", 1500, 5, TamanhoBebida.Mediano)

        inventarioMapa = mapOf(
            1 to comida1,
            2 to comida2,
            3 to comida3,
            4 to comida4,
            5 to bebida1,
            6 to bebida2,
            7 to bebida3,
            8 to bebida4
            )
    }

    fun mostrarCatalogo() {
        println("===SISTEMA FOODEXPRESS===")
        println("Catálogo disponible: ")
        inventarioMapa.forEach { (id, producto) -> println("$id. ${producto.mostrarInfo()}") }

    }

    fun seleccionarProductos() {
        while (true){

            println("")
            print("Seleccione productos(números separados por coma): ")
            val selector = readLine() ?: ""

            val idsSeleccionados = selector.split(",").map { it.trim().toIntOrNull() }

            if (idsSeleccionados.any {it == null}) {
                println("Por favor, ingrese los números en el formato solicitado (separados por coma)")
                continue
            }

            val ids = idsSeleccionados.filterNotNull()

            if (ids.any { it <= 0}){
                println("Por favor, no ingrese ids negativos")
                continue
            }

            try {
                ids.forEach { id ->
                    val producto = inventarioMapa[id]
                        ?: throw IllegalArgumentException("Por favor, seleccione un producto del menú")
                    agregarAlCarro(producto)
                }
            } catch (e: IllegalArgumentException) {
                println("${e.message}")
                continue
            }

            break
            }
        }

    fun mostrarPedido(tipoCliente: String) {
        println("\n=== RESUMEN DEL PEDIDO ===")

        carroCompra.forEach { producto ->
            println("${producto.nombre}: $${"%,d".format(producto.precioFinal())}")
        }

        val subtotal = calcularPrecio()
        println("Subtotal: $${"%,d".format(subtotal)}")

        val descuento = calcularDescuentoCliente(tipoCliente)
        println("Descuento (${tipoCliente.uppercase()}): -$${"%,d".format(descuento)}")

        val precioConDescuento = subtotal - descuento
        val iva = (precioConDescuento * 0.19).toInt()
        println("IVA (19%): $${"%,d".format(iva)}")

        val total = calcularTotal(tipoCliente)
        println("TOTAL: $${"%,d".format(total)}")
    }

    fun agregarAlCarro(producto: Producto) :List<Producto>{
        carroCompra.add(producto)
        return carroCompra.toList()
    }

    fun calcularPrecio(): Int {
        return carroCompra.sumOf { producto ->  producto.precioFinal() }
    }

    fun calcularDescuentoCliente(tipoCliente: String): Int {
        val subtotal = calcularPrecio()
        return when(tipoCliente.lowercase()) {
            "regular" -> (subtotal * 0.05).toInt()
            "vip" -> (subtotal * 0.10).toInt()
            "premium" -> (subtotal * 0.15).toInt()
            else -> 0
        }
    }

    fun calcularIVA(monto: Int): Int {
        val iva = (monto * 0.19).toInt()
        return monto + iva
    }

    fun calcularTotal(tipoCliente: String): Int {
        val subtotal = calcularPrecio()
        val descuento = calcularDescuentoCliente(tipoCliente)
        val precioConDescuento = subtotal - descuento
        return calcularIVA(precioConDescuento)
    }

    suspend fun procesarPedido() {
        var estado: EstadoPedido = EstadoPedido.Pendiente
        println(" ")
        println("Su pedido se encuentra: $estado")

        delay(3000L)
        estado = EstadoPedido.EnPreparacion
        println("Su pedido se encuentra: $estado")
    }

    suspend fun pedidoListo() {
        var estado: EstadoPedido = EstadoPedido.Listo
        estado = EstadoPedido.Listo
        println(" ")
        println("Su pedido se encuentra: $estado")
    }
}



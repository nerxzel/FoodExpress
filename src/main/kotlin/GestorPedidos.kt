import kotlin.collections.component1

class GestorPedidos {

    var carroCompra: MutableList<Producto> = mutableListOf()

    fun agregarAlCarro(producto: Producto) :List<Producto>{
        carroCompra.add(producto)
        return carroCompra.toList()
    }

    fun calcularPrecio(): Double{
        return carroCompra.sumOf { producto ->  producto.precio } }
}
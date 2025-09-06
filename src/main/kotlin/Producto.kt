open class Producto(val nombre: String,
                    var precio: Double,
                    var esPremium:Boolean,
                    var tiempoPreparacion: Int) {

    open fun mostrarInfo(): String {
        return "Producto(nombre='$nombre', precio=$precio)"
    }
}
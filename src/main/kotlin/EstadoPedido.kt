sealed class EstadoPedido {

    object Pendiente : EstadoPedido() {
        override fun toString() = "Pendiente"
    }
    object EnPreparacion : EstadoPedido(){
        override fun toString() = "En preparación"
    }
    object Listo : EstadoPedido(){
        override fun toString() = "Listo"
    }
}
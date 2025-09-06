fun main() {

    // Se crean objetos comida y bebida para poder hacer un invenario
    val comida1 = Comida("Hamburguesa clásica", 5000.0, false, 10)
    val comida2 = Comida("Hamburguesa vegana", 8000.0, true, 15)
    val comida3 = Comida("Puré con papas fritas", 10000.0, false, 20)
    val comida4 = Comida("Puré con papas duquesa", 15000.0, true, 25)
    val bebida1 = Bebida("Coca-Cola", 1500.0, false, 5, "Mediana")
    val bebida2 = Bebida("Fanta", 1500.0, true, 5, "Mediana")
    val bebida3 = Bebida("Pepsi", 1500.0, true, 5, "Mediana")
    val bebida4 = Bebida("Crush", 1500.0, true, 5, "Mediana")

    var gestor = GestorPedidos()
    var inventarioMapa = mapOf(1 to comida1, 2 to comida2, 3 to comida3, 4 to comida4, 5 to bebida1, 6 to bebida2, 7 to bebida3, 8 to bebida4)

    println("===SISTEMA FOODEXPRESS===")
    println("Catálogo disponible: ")
    inventarioMapa.forEach {(id, producto) ->  println("$id. ${producto.mostrarInfo()}")}
    println()
    print("Selecciona productos(números separados por coma): ")
    val selector = readln()


}
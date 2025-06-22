package Pedidos;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Pedido> pedidos = List.of(
                new Pedido("Alma", "domicilio", "554-1244"),
                new Pedido("Carmen", "local", null),
                new Pedido("Miguel", "domicilio", null),
                new Pedido("Sergio", "domicilio", "444-4444")
        );

        // 🛒 Almacenamos los mensajes en una lista
        List<String> mensajes = pedidos.stream()
                .filter(p -> p.getTipoEntrega().equalsIgnoreCase("domicilio")) // 🔍 Filtrar por entrega a domicilio
                .map(Pedido::getTelefono) // 🔄 Transformar Pedido → Optional<String>
                .filter(Optional::isPresent) // 🔍 Filtrar los Optional con valor
                .map(Optional::get) // 📥 Extraer el número del Optional
                .map(tel -> "📞 Confirmación enviada al número: " + tel) // 📨 Crear mensaje
                .toList(); // 📦 Recolectar en una lista

        // 🖨️ Mostrar los mensajes (podrías guardarlos, enviarlos, etc.)
        System.out.println("📞 Confirmaciones de pedidos a domicilio:");
        mensajes.forEach(System.out::println);
    }
}
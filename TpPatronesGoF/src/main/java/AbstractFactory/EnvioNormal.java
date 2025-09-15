package AbstractFactory;

import lombok.Data;
import lombok.AllArgsConstructor;
@Data
@AllArgsConstructor
public class EnvioNormal implements MetodoEnvio {
    @Override
    public void enviar() {
        System.out.println("Pedido con Envio Normal");
    }
}

package AbstractFactory;

import lombok.Data;
import lombok.AllArgsConstructor;
@Data
@AllArgsConstructor
public class UsuarioUI implements InterfazUI {
    @Override
    public void mostrarUI() {
        System.out.println("UI para Usuarios");
    }
}

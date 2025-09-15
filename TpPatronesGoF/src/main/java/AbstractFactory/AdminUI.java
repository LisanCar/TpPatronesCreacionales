package AbstractFactory;

import lombok.Data;
import lombok.AllArgsConstructor;
@Data
@AllArgsConstructor
public class AdminUI implements InterfazUI {
    @Override
    public void mostrarUI() {
        System.out.println("UI para Admins");
    }
}

package AbstractFactory;

public class AdminFactory implements AbstractFactory{

    @Override
    public InterfazUI crearUI() {
        return new AdminUI();
    }

    @Override
    public MetodoEnvio CrearEnvio() {
        return new EnvioExpress();
    }
}

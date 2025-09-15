package AbstractFactory;

public class UsuarioFactory implements AbstractFactory{
    @Override
    public InterfazUI crearUI() {
        return new UsuarioUI();
    }

    @Override
    public MetodoEnvio CrearEnvio() {
        return new EnvioNormal();
    }
}

package Builder;

import lombok.Data;
import lombok.Builder;
import java.time.LocalDate;

@Data
@Builder
public class Usuario {
    private String nombre, email, direccion, telefono;
    private LocalDate fechaNacimiento;

    public void mostrarUsuario(){
        System.out.println((nombre!=null ? "Nombre: "+nombre+", ":"") + (email!=null ?"Email: "+email+", ":"")+(direccion!=null ?"direccion: "+direccion+", ":"")+ (telefono!=null ?"telefono: "+telefono+", ":"")+(fechaNacimiento!=null ?"fecha de Nacimiento: "+fechaNacimiento:""));
    }

}

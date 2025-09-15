package Prototype;

import Builder.Usuario;
import MethodFactory.Libro;
import MethodFactory.LibroDigital;
import MethodFactory.LibroFisico;
import MethodFactory.LogisticaLibro;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Prestamo implements Cloneable{
    public Libro libro;
    public Usuario usuario;
    public LocalDate fechaInicio;
    public LocalDate fechaFin;

    public Prestamo cloneShallow() {
        try {
            return (Prestamo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public Prestamo cloneDeep(){
        try {
            Prestamo clon = (Prestamo) super.clone();
            clon.usuario= Usuario.builder()
                    .nombre(this.usuario.getNombre())
                    .email(this.usuario.getEmail())
                    .direccion(this.usuario.getDireccion())
                    .telefono(this.usuario.getTelefono())
                    .fechaNacimiento(this.usuario.getFechaNacimiento())
                    .build();
            if (this.libro instanceof LibroFisico) {
                clon.libro = LogisticaLibro.crearLibro("fisico", ((LibroFisico) this.libro).getTitulo(), ((LibroFisico) this.libro).getAutor(), ((LibroFisico) this.libro).getAnio());
            } else if (this.libro instanceof LibroDigital) {
                clon.libro = LogisticaLibro.crearLibro("digital", ((LibroDigital) this.libro).getTitulo(), ((LibroDigital) this.libro).getAutor(), ((LibroDigital) this.libro).getAnio());
            }
            return clon;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
    public void mostrarPrestamo(){
        System.out.println("Prestamo a nombre de: "+usuario.getNombre()+", del libro: "+libro+", Fecha de Inicio: "+fechaInicio+", Fecha de Devolucion: "+fechaFin);
    }
}

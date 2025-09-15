package MethodFactory;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class LibroFisico implements Libro{
    private String titulo;
    private String autor;
    private int anio;


    @Override
    public String getTipo() {
        return "Libro Fisico, titulo: "+titulo+", autor: "+ autor+", año de publicacion: "+anio;
    }
}

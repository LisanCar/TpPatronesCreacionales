package MethodFactory;

import lombok.Data;
@Data
public class LogisticaLibro {
    public static Libro crearLibro(String tipo, String titulo, String autor, int anio){
        if (tipo.equalsIgnoreCase("Digital")){
            return new LibroDigital(titulo, autor, anio);
        }
        else if (tipo.equalsIgnoreCase("Fisico")){return new LibroFisico(titulo, autor, anio);}
        else {throw new IncorrectInputException("Tipo Inexistente");}
    }
}

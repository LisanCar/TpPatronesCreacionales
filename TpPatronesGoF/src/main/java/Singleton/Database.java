package Singleton;

import MethodFactory.Libro;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
public class Database {
    public List<Libro> libros=new ArrayList<>();
    //Singleton con Holder
    private Database(){}
    private static class Holder{
        private static final Database INSTANCE= new Database();
    }
    public static Database getInstance(){
        return Holder.INSTANCE;
    }

    public void addLibros(Libro libro){
        libros.add(libro);
    }
    public List<Libro> listarLibros(){
        return new ArrayList<>(libros);
    }
}

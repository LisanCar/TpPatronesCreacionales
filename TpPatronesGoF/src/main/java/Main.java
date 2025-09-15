import AbstractFactory.AbstractFactory;
import AbstractFactory.AdminFactory;
import AbstractFactory.UsuarioFactory;
import AbstractFactory.MetodoEnvio;
import AbstractFactory.InterfazUI;
import Builder.Usuario;
import MethodFactory.Libro;
import MethodFactory.LogisticaLibro;
import Prototype.Prestamo;
import Singleton.Database;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //Singleton
        System.out.println("\n-----Singleton-----\n");
        Database db1 = Database.getInstance();
        Database db2 = Database.getInstance();
        System.out.println(db1 == db2);

        //FactoryMethod
        System.out.println("\n-----FactoryMethod-----\n");
        Libro l1 = LogisticaLibro.crearLibro("digital", "Padre Rico, Padre Pobre", "Robert Kiyosaki", 1997);
        Libro l2 = LogisticaLibro.crearLibro("fisico", "Habitos Atomicos", "James Clear", 2018);
        System.out.println(l1.getTipo());
        System.out.println("-----------");
        System.out.println(l2.getTipo());

        //AbstractFactory
        System.out.println("\n-----AbstractFactory-----\n");
        AbstractFactory factory= new AdminFactory();
        MetodoEnvio envio= factory.CrearEnvio();
        InterfazUI interfaz=factory.crearUI();
        envio.enviar();
        interfaz.mostrarUI();
        System.out.println("-----------");
        AbstractFactory factory1 = new UsuarioFactory();
        MetodoEnvio envio1= factory1.CrearEnvio();
        InterfazUI interfaz1 = factory1.crearUI();
        envio1.enviar();
        interfaz1.mostrarUI();

        //Builder
        System.out.println("\n-----Builder-----\n");
        Usuario u1 = Usuario.builder()
                .nombre("Lisandro Carrillo")
                .email("carrillo.lisan@gmail.com")
                .telefono("2615431432")
                .direccion("Charcas 4330")
                .fechaNacimiento(LocalDate.of(2004,7,14))
                .build();
        System.out.println("-----------");
        Usuario u2= Usuario.builder()
                .nombre("Daniel Oldra")
                .direccion("Balcarce 477")
                .fechaNacimiento(LocalDate.of(2002,4,9))
                .build();
        u1.mostrarUsuario();
        u2.mostrarUsuario();

        //Prototype
        System.out.println("\n-----Prototype-----\n");
        Prestamo p1=new Prestamo(l1,u1, LocalDate.now(),LocalDate.now().plusDays(30));
        Prestamo p2 = p1.cloneShallow();
        Prestamo p3 = p1.cloneDeep();
        p2.setFechaFin(LocalDate.now().plusDays(60));
        p3.setUsuario(u2);
        p3.setLibro(l2);

        p1.mostrarPrestamo();
        System.out.println("-----Shallow-----");
        p2.mostrarPrestamo();
        System.out.println("-----Deep-----");
        p3.mostrarPrestamo();
    }
}

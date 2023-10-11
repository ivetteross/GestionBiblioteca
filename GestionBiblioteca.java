import java.util.Scanner;
import inventario.Libro;
import inventario.Usuario;

public class GestionBiblioteca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" ****************************");
        System.out.println("* Bienvenido a la Biblioteca *");
        System.out.println(" ****************************");

        // Arreglos para almacenar libros y usuarios
        Libro[] biblioteca = new Libro[20];
        Usuario[] usuarios = new Usuario[12];

        // Inicialización de algunos libros y usuarios
        biblioteca[0] = new Libro("1984", "George Orwell", "123", true);
        biblioteca[1] = new Libro("Cien años de soledad", "Gabriel García Márquez", "456", true);
        biblioteca[2] = new Libro("Crimen y castigo", "Fyodor Dostoevsky", "789", true);
        biblioteca[3] = new Libro("Don Quijote de la Mancha", "Miguel Cervantes", "234", true);
        biblioteca[4] = new Libro("El Gran Gatsby", "F. Scott Fitzgerald", "567", true);
        biblioteca[5] = new Libro("El Perfume", "Patrick Süskind", "890", true);
        biblioteca[6] = new Libro("El alquimista", "Paulo Coelho ", "345", true);
        biblioteca[7] = new Libro("El Señor de los Anillos", "J.R.R. Tolkien", "678", true);
        biblioteca[8] = new Libro("La Odisea", "Homero", "901", true);
        biblioteca[9] = new Libro("La chica del tren", "Paula Hawkins", "432", true);
        biblioteca[10] = new Libro("La sombra del viento", "Carlos Ruiz Zafón ", "109", true);
        biblioteca[11] = new Libro("Los juegos del hambre", "Suzanne Collins", "876", true);
        biblioteca[12] = new Libro("Rayuela", "Julio Cortázar", "543", true);
        biblioteca[13] = new Libro("Sapiens: De animales a dioses", "Yuval Noah Harari", "210", true);
        biblioteca[14] = new Libro("Matar a un ruiseñor", "Harper Lee", "321", true);
        biblioteca[15] = new Libro("Orgullo y prejuicio", "Jane Austen", "654", true);
        biblioteca[16] = new Libro("Los hombres me explican cosas", "Rebecca Solnit", "987", true);
        biblioteca[17] = new Libro("La insoportable levedad del ser", "Milan Kundera", "765", true);
        biblioteca[18] = new Libro("Memorias del subsuelo", "Fyodor Dostoevsky", "012", true);
        biblioteca[19] = new Libro("Siddhartha", "Hermann Hesse", "098", true);
        
        
        usuarios[0] = new Usuario("Alejandra Perez Espinoza", "E12345", "Estudiante");
        usuarios[1] = new Usuario("Angela Karina Canseco Cruz", "E23456", "Estudiante");
        usuarios[2] = new Usuario("Karla Isabel Dorado Padilla", "E34567", "Estudiante");
        usuarios[3] = new Usuario("Laura Itzel Gress Becerril", "E45678", "Estudiante");
        usuarios[4] = new Usuario("Laura Ivette Noemi Rosas Ramirez", "E56789", "Estudiante");
        usuarios[5] = new Usuario("Lesly Adriana Osorio Gonzalez", "E67890", "Estudiante");
        usuarios[6] = new Usuario("Maria Fernanda Gomez Miranda", "E78901", "Estudiante");
        usuarios[7] = new Usuario("Maricela Prado Velazquez", "E89012", "Estudiante");
        usuarios[8] = new Usuario("Paola Ixchel de la Cruz Flores", "E90123", "Estudiante");
        usuarios[9] = new Usuario("Zayra Lorena Almazo Rosales", "E01234", "Estudiante");
        usuarios[10] = new Usuario("Alberto Luebbert", "P12345", "Profesor");
        usuarios[11] = new Usuario("Brenda Morales", "P98765", "Profesor");
        

        int opcion = 0;
        boolean entradaValida = false;
        do {
            // Menú principal
            System.out.println("\nMenú de Opciones:");
            System.out.println("1. Realizar préstamo");
            System.out.println("2. Realizar devolución");
            System.out.println("3. Mostrar libros disponibles");
            System.out.println("4. Ingresar como administrador");
            System.out.println("5. Salir");
            System.out.println(" ");
            System.out.print("Seleccione una opción: ");

            // Intentamos leer la opción del usuario
            try {
                opcion = Integer.parseInt(scanner.next());
                entradaValida = true;
            } catch (NumberFormatException e) {
                entradaValida = false;
                System.out.println("Opción no válida. Por favor, ingrese un número válido.");
            }

            switch (opcion) {
                case 1:
                    // Realizar préstamo
                    System.out.println("Ingrese su carnet: ");
                    String carnet = scanner.next();
                    scanner.nextLine();
                    System.out.println("Ingrese el Número Dewey del libro que desea prestar: ");
                    String numDewey = scanner.next();
                    scanner.nextLine(); // Consumir la nueva línea pendiente

                    Usuario usuarioEncontrado = buscarUsuarioPorCarnet(usuarios, carnet);

                    if (usuarioEncontrado != null) {
                        Libro libroEncontrado = buscarLibroPorDewey(biblioteca, numDewey);

                        if (libroEncontrado != null) {
                            libroEncontrado.prestar(usuarioEncontrado.nombre);
                        } else {
                            System.out.println("Libro no encontrado.");
                        }
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;

                case 2:
                    // Realizar devolución
                    System.out.println("Ingrese el Número Dewey del libro que desea devolver: ");
                    numDewey = scanner.next();
                    scanner.nextLine(); // Consumir la nueva línea pendiente

                    Libro libroDevolver = buscarLibroPorDewey(biblioteca, numDewey);

                    if (libroDevolver != null) {
                        libroDevolver.devolver();
                    } else {
                        System.out.println("Libro no encontrado.");
                    }
                    break;

                case 3:
                    // Mostrar libros disponibles
                    System.out.println("\nLibros Disponibles:");
                    for (Libro libro : biblioteca) {
                        if (libro != null && libro.disponible) {
                            libro.mostrarInformacion();
                            System.out.println();
                        }
                    }
                    break;

                case 4:
                    // Ingresar como administrador
                    System.out.println("Ingrese la contraseña de administrador: ");
                    String contrasenaAdmin = scanner.next();
                    if (contrasenaAdmin.equals("admin123")) {
                        System.out.println("Bienvenido, administrador!");
                        int opcionAdmin = 0;
                        boolean entradaValidaAdmin;
                
                        do {
                            // Menú de administrador
                            System.out.println("\nMenú de Administrador:");
                            System.out.println("1. Registrar libro");
                            System.out.println("2. Editar libro");
                            System.out.println("3. Eliminar libro");
                            System.out.println("4. Registrar usuario");
                            System.out.println("5. Editar usuario");
                            System.out.println("6. Eliminar usuario");
                            System.out.println("7. Mostrar libros registrados");
                            System.out.println("8. Mostrar usuarios registrados");
                            System.out.println("9. Volver al menú principal");
                            System.out.print("Seleccione una opción: ");
                
                            try {
                                opcionAdmin = Integer.parseInt(scanner.next());
                                entradaValidaAdmin = true;
                            } catch (NumberFormatException e) {
                                entradaValidaAdmin = false;
                                System.out.println("Opción no válida. Por favor, ingrese un número válido.");
                            }
                
                            if (entradaValidaAdmin) {
                                switch (opcionAdmin) {
                                    case 1:
                                        // Registrar libro
                                        System.out.println("Ingrese el título del libro: ");
                                        scanner.nextLine(); // Consumir la nueva línea pendiente
                                        String tituloLibro = scanner.nextLine(); // Leer toda la línea del título
                                        System.out.println("Ingrese el autor del libro: ");
                                        String autorLibro = scanner.nextLine(); // Leer toda la línea del autor
                                        System.out.println("Ingrese el Número Dewey del libro: ");
                                        String numDeweyLibro = scanner.next();
                                        scanner.nextLine(); // Consumir la nueva línea pendiente
                                        
                                        int indiceLibro = buscarIndiceLibre(biblioteca);
                                        if (indiceLibro != -1) {
                                            biblioteca[indiceLibro] = new Libro(tituloLibro, autorLibro, numDeweyLibro, true);
                                            System.out.println("Libro registrado con éxito.");
                                        } else {
                                            System.out.println("No hay espacio para más libros.");
                                        }
                                        break;
                
                                    case 2:
                                        // Editar libro
                                        System.out.print("Ingrese el Número Dewey del libro a editar: ");
                                        String numDeweyEditar = scanner.next();
                                        scanner.nextLine(); // Consumir la nueva línea pendiente
                                        Libro libroEditar = buscarLibroPorDewey(biblioteca, numDeweyEditar);
                                        if (libroEditar != null) {
                                            System.out.println("Ingrese el nuevo título del libro: ");
                                            String nuevoTitulo = scanner.nextLine(); // Utilizamos nextLine() para leer toda la línea
                                            System.out.println("Ingrese el nuevo autor del libro: ");
                                            String nuevoAutor = scanner.nextLine(); // Utilizamos nextLine() para leer toda la línea
                                            System.out.println("Ingrese el nuevo Número Dewey del libro: ");
                                            String nuevoNumDewey = scanner.next();
                                            scanner.nextLine(); // Consumimos la nueva línea pendiente después de leer el nuevo número Dewey
                
                                            libroEditar.editarInformacion(nuevoTitulo, nuevoAutor, nuevoNumDewey);
                                        } else {
                                            System.out.println("Libro no encontrado.");
                                        }
                                        break;
                
                                    case 3:
                                        // Eliminar libro
                                        System.out.println("Ingrese el Número Dewey del libro a eliminar: ");
                                        String numDeweyEliminar = scanner.next();
                                        scanner.nextLine(); // Consumir la nueva línea pendiente
                                        Libro libroEliminar = buscarLibroPorDewey(biblioteca, numDeweyEliminar);
                                        if (libroEliminar != null) {
                                            libroEliminar.eliminar();
                                            System.out.println("Libro eliminado con éxito.");
                                        } else {
                                            System.out.println("Libro no encontrado.");
                                        }
                                        break;
                
                                    case 4:
                                        // Registrar usuario
                                        System.out.println("Ingrese el nombre del usuario: ");
                                        scanner.nextLine(); // Consumir la nueva línea pendiente
                                        String nombreUsuario = scanner.nextLine(); // Utilizamos nextLine() para leer toda la línea
                                        System.out.println("Ingrese el carnet del usuario: ");
                                        String carnetUsuario = scanner.nextLine();
                                        System.out.println("Ingrese el tipo de usuario (Estudiante o Profesor): ");
                                        String tipoUsuario = scanner.next();
                                        scanner.nextLine(); // Consumimos la nueva línea pendiente
                
                                        int indiceUsuario = buscarIndiceLibre(usuarios);
                                        if (indiceUsuario != -1) {
                                            usuarios[indiceUsuario] = new Usuario(nombreUsuario, carnetUsuario, tipoUsuario);
                                            System.out.println("Usuario registrado con éxito.");
                                        } else {
                                            System.out.println("No hay espacio para más usuarios.");
                                        }
                                        break;
                
                                    case 5:
                                        // Editar usuario
                                        System.out.println("Ingrese el carnet del usuario a editar: ");
                                        String carnetEditar = scanner.next();
                                        scanner.nextLine(); // Consumir la nueva línea pendiente
                                    
                                        Usuario usuarioEditar = buscarUsuarioPorCarnet(usuarios, carnetEditar);
                                        if (usuarioEditar != null) {
                                            System.out.println("Ingrese el nuevo nombre del usuario: ");
                                            String nuevoNombre = scanner.nextLine(); // Utilizamos nextLine() para leer toda la línea
                                            System.out.println("Ingrese el nuevo tipo del usuario (Estudiante o Profesor): ");
                                            String nuevoTipo = scanner.next();
                                            scanner.nextLine(); // Consumimos la nueva línea pendiente después de leer el nuevo tipo de usuario
                                    
                                            usuarioEditar.editarInformacion(nuevoNombre, carnetEditar, nuevoTipo);
                                        } else {
                                            System.out.println("Usuario no encontrado.");
                                        }
                                        break;
                
                                    case 6:
                                        // Eliminar usuario
                                        System.out.println("Ingrese el carnet del usuario a eliminar: ");
                                        scanner.nextLine(); // Consumir la nueva línea pendiente
                                        String carnetEliminar = scanner.next();
                                        scanner.nextLine(); // Consumir la nueva línea pendiente
                                        Usuario usuarioEliminar = buscarUsuarioPorCarnet(usuarios, carnetEliminar);
                                        if (usuarioEliminar != null) {
                                            usuarioEliminar.eliminar();
                                            System.out.println("Usuario eliminado con éxito.");
                                        } else {
                                            System.out.println("Usuario no encontrado.");
                                        }
                                        break;
                
                                    case 7:
                                        // Mostrar libros registrados
                                        System.out.println("\nLibros Registrados:");
                                        for (Libro libro : biblioteca) {
                                            if (libro != null && !libro.estaEliminado()) {
                                                libro.mostrarInformacion();
                                                System.out.println();
                                            }
                                        }
                                        break;
                
                                    case 8:
                                        // Mostrar usuarios registrados
                                        System.out.println("\nUsuarios Registrados:");
                                        for (Usuario usuario : usuarios) {
                                            if (usuario != null && !usuario.estaEliminado()) {
                                                usuario.mostrarInformacion();
                                                System.out.println();
                                            }
                                        }
                                        break;
                
                                    case 9:
                                        // Volver al menú principal
                                        break;
                
                                    default:
                                        System.out.println("Opción inválida.");
                                }
                            }
                        } while (opcionAdmin != 9);
                    } else {
                        System.out.println("Contraseña incorrecta. Acceso denegado.");
                    }
                    break;
                

                case 5:
                    // Salir del programa
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (!entradaValida);

        scanner.close();
    }

    // Método para buscar un índice libre en un arreglo de libros o usuarios
    private static int buscarIndiceLibre(Object[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == null) {
                return i;
            }
        }
        return -1;
    }

    // Método para buscar un libro por su número Dewey
    private static Libro buscarLibroPorDewey(Libro[] biblioteca, String numDewey) {
        for (Libro libro : biblioteca) {
            if (libro != null && libro.numDewey.equals(numDewey)) {
                return libro;
            }
        }
        return null;
    }

    // Método para buscar un usuario por su carnet
    private static Usuario buscarUsuarioPorCarnet(Usuario[] usuarios, String carnet) {
        for (Usuario usuario : usuarios) {
            if (usuario != null && usuario.carnet.equals(carnet)) {
                return usuario;
            }
        }
        return null;
    }
}

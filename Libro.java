package inventario;

// Definición de la clase Libro
public class Libro {
    String titulo;
    String autor;
    public String numDewey;
    public boolean disponible;
    private boolean eliminado;

    // Constructor de la clase Libro
    public Libro(String titulo, String autor, String numDewey, boolean disponible) {
        this.titulo = titulo;
        this.autor = autor;
        this.numDewey = numDewey;
        this.disponible = disponible;
        eliminado = false; // Inicialmente no eliminado
    }

    // Método para prestar el libro
    public void prestar(String nombre) {
        if (disponible) {
            disponible = false;
            System.out.println("El libro " + titulo + " ha sido prestado con éxito a: " + nombre);
        } else {
            System.out.println("El libro no está disponible para préstamo.");
        }
    }

    // Método para devolver el libro
    public void devolver() {
        disponible = true;
        System.out.println("Libro devuelto con éxito.");
    }

    // Método para mostrar información del libro
    public void mostrarInformacion() {
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Número Dewey: " + numDewey);
        System.out.println("Disponible: " + (disponible ? "Si" : "No"));
    }

    // Método para editar información del libro
    public void editarInformacion(String nuevoTitulo, String nuevoAutor, String nuevoNumDewey) {
        this.titulo = nuevoTitulo;
        this.autor = nuevoAutor;
        this.numDewey = nuevoNumDewey;
        System.out.println("Información del libro actualizada.");
    }

    // Método para eliminar el libro
    public void eliminar() {
        this.titulo = null;
        this.autor = null;
        this.numDewey = null;
        this.disponible = false;
        eliminado = true;
    }

    // Método para consultar el estado "eliminado"
    public boolean estaEliminado() {
        return eliminado;
    }

}


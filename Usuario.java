package inventario;

// Definición de la clase Usuario
public class Usuario {
    public String nombre;
    public String carnet;
    private String tipo;
    private boolean eliminado;

    // Constructor de la clase Usuario
    public Usuario(String nombre, String carnet, String tipo) {
        this.nombre = nombre;
        this.carnet = carnet;
        this.tipo = tipo;
        this.eliminado = false; // Inicialmente no eliminado
    }

    // Método para mostrar información del usuario
    public void mostrarInformacion() {
        if (!eliminado) {
            System.out.println("Nombre: " + nombre);
            System.out.println("Carnet: " + carnet);
            System.out.println("Tipo: " + tipo);
        }
    }

    // Método para editar información del usuario
    public void editarInformacion(String nuevoNombre, String nuevoCarnet, String nuevoTipo) {
        this.nombre = nuevoNombre;
        this.carnet = nuevoCarnet;
        this.tipo = nuevoTipo;
        System.out.println("Información del usuario actualizada.");
    }

    // Método para eliminar al usuario
    public void eliminar() {
        this.eliminado = true;
    }

    // Método para consultar el estado "eliminado"
    public boolean estaEliminado() {
        return eliminado;
    }
}

package clases;

import javax.swing.JOptionPane;

public class ClasePrincipal {

    public static void main(String[] args) {

        int opcion = 0, nodo_informacion = 0;
        Cola cola = new Cola();

        do {

            try {

                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Menú de Opciones\n\n"
                        + "1. Insertar un dato\n"
                        + "2. Extraer un dato\n"
                        + "3. Mostrar contenido de la Cola\n"
                        + "4. Salir.\n\n"));

                switch (opcion) {
                    case 1:
                        nodo_informacion = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Porfavor ingresa el valor a guardarlo en la pila."));
                        cola.Insertar(nodo_informacion);
                        break;
                    case 2:
                        if (!cola.ColaVacia()) {
                            JOptionPane.showMessageDialog(null, "Se extrajo un dato con el valor: " 
                                    + cola.Extraer());
                        } else {
                            JOptionPane.showMessageDialog(null, "La cola esta vacía");
                        }
                        break;
                    case 3:
                        cola.MostrarContenido();
                        break;
                    case 4:
                        opcion = 4;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no dispobible.");
                        break;
                }

            } catch (NumberFormatException e) {
            }

        } while (opcion != 4);
    }
}

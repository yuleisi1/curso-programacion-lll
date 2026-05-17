package proyecto;
 
import java.util.Stack;
 
public class SOperaciones {
 
    private Stack<String> pilaDeshacer;
    private Stack<String> pilaRehacer;
    private Stack<String> pilaReportes;
 
    public SOperaciones() {
        pilaDeshacer = new Stack<>();
        pilaRehacer = new Stack<>();
        pilaReportes = new Stack<>();
    }
 
    public void agregarOperacion(String descripcion) {
        pilaDeshacer.push(descripcion);
        pilaRehacer.clear(); 
        System.out.println("[Operacion registrada]: " + descripcion);
    }
 
    public void deshacer() {
        try {
            if (pilaDeshacer.isEmpty()) {
                throw new PilaDeshacerVaciaException(
                    "PilaDeshacerVaciaException - No hay operaciones para deshacer"
                );
            }
            String op = pilaDeshacer.pop();
            pilaRehacer.push(op);
            System.out.println("Operacion deshecha: " + op);
        } catch (PilaDeshacerVaciaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
 
    public void rehacer() {
        try {
            if (pilaRehacer.isEmpty()) {
                throw new PilaDeshacerVaciaException(
                    "PilaDeshacerVaciaException - No hay operaciones para rehacer"
                );
            }
            String op = pilaRehacer.pop();
            pilaDeshacer.push(op);
            System.out.println("Operacion rehecha: " + op);
        } catch (PilaDeshacerVaciaException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
 
    public void mostrarEstado() {
        System.out.println("\nPila Deshacer (" + pilaDeshacer.size() + " ops): " + pilaDeshacer);
        System.out.println("Pila Rehacer  (" + pilaRehacer.size() + " ops): " + pilaRehacer);
    }
 
    public void abrirReporte(String reporte) {
        pilaReportes.push(reporte);
        System.out.println("Reporte abierto: " + reporte);
    }
 
    public void atrasReporte() {
        if (pilaReportes.isEmpty()) {
            System.out.println("No hay reportes anteriores.");
            return;
        }
        String anterior = pilaReportes.pop();
        System.out.println("Volviendo al reporte anterior. Reporte cerrado: " + anterior);
        if (!pilaReportes.isEmpty()) {
            System.out.println("Reporte actual: " + pilaReportes.peek());
        } else {
            System.out.println("No hay mas reportes en el historial.");
        }
    }
}
 

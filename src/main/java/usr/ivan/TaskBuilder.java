package usr.ivan;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.*;

import usr.ivan.models.Task;

public class TaskBuilder {
  public TaskBuilder() {

  }

  public Task buildTask() {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String title, descripcion;
    LocalDate fecha;

    title = JOptionPane.showInputDialog("Titulo de la tarea: ");
    descripcion = JOptionPane.showInputDialog("Introduce el contenido de la tarea: ");

    while (true) {

      String fechaStr = JOptionPane.showInputDialog("Introduce la fecha: (dd/mm/yyyy)");
      if (fechaStr == null) {
        JOptionPane.showMessageDialog(null, "Operación cancelada");
        return null;
      }
      try {

        fecha = LocalDate.parse(fechaStr, dateTimeFormatter);
        break;
      } catch (Exception e) {
      }
    }
    return new Task(title, descripcion, fecha);

  }
}

package usr.ivan;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import usr.ivan.models.Task;

import java.awt.*;

public class MainFrame extends JFrame {
   // Me quiero suicidar

   /*
    * Interfáz gráfica
    */
private JTable taskTable;
private DefaultTableModel taskTableModelM;
   public void buildFrame(TaskDAO taskDAO) {

      setTitle("Lista de Tareas");
      setSize(800, 600);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLayout(new BorderLayout());
      /*
       * 2 Paneles
       * Izquierda : Botones que hacen llamadas a la base de datos, añadir tarea,
       * eliminar...
       * Derecha : JList con todas las tareas en columnas (responsive por si se
       * alargan las columnas??)
       */

      /*
       * Panel izquierdo con botones
       */

      JPanel panelBotones = new JPanel();
      panelBotones.setLayout(new GridLayout(0,1,5,5));
      panelBotones.setPreferredSize(new Dimension(200, 0));

      /*
       * Botones a añadir, se irán sumando con el tiempo
       * 
       */

      JButton addButton = new JButton("Añadir Tarea");
      JButton modifyButton = new JButton("Modificar Tarea");
      JButton deleteButton = new JButton("Eliminar tarea");

      panelBotones.add(addButton);
      panelBotones.add(Box.createRigidArea(new Dimension(0, 10)));
      panelBotones.add(modifyButton);
      panelBotones.add(Box.createRigidArea(new Dimension(0, 10)));
      panelBotones.add(deleteButton);

      deleteButton.addActionListener(event -> {
         String idStr = JOptionPane.showInputDialog("Introduce el ID");

         try {
            long id = Long.parseLong(idStr);
            taskDAO.deleteTaskById(id);
            System.out.println("Tarea eliminada correctamente");
            loadTasksFromDatabase(taskDAO);
         } catch (NumberFormatException e) {

            e.printStackTrace();
         }
      });
      /*
       * Creamos la lista de tareas en el panel derecho
       */

       String[] columnNames = {"ID", "Título" , "Descripción", "Completada", "Fecha"};
      taskTableModelM = new DefaultTableModel(columnNames, 0); //Modelo de la tabla
      taskTable = new JTable(taskTableModelM);
      JScrollPane taskScrollPane = new JScrollPane(taskTable); // Scroll

      // Dividimos la parte izquieda de la derecha usando JSplitPane

      JSplitPane splitPane = new JSplitPane(
            JSplitPane.HORIZONTAL_SPLIT,
            panelBotones, // Componente a la izquierda
            taskScrollPane // Comonente a la derecha
      );
      splitPane.setLastDividerLocation(200);

      add(splitPane, BorderLayout.CENTER);

      setVisible(true);

      loadTasksFromDatabase(taskDAO);
      /*
       * Event listener de la tabla
       */
      

   }

   private void loadTasksFromDatabase(TaskDAO taskDao) {

      int index = taskTableModelM.getRowCount();

      if (index > 0) {
         for (int i = index -1; i >= 0; i--) {
            taskTableModelM.removeRow(i);
         }
      }

      List<Task> tasks = taskDao.getAllTasks();

      for (Task task : tasks) {

         taskTableModelM.addRow(new Object[] {
               task.getId(),
               task.getTitle(),
               task.getDescription(),
               task.isCompleted() ? "Si" : "No",
               task.getDate()
         });
      }
   }

   private void delteAllRows(List<Task> listaTareas) {
      if (listaTareas.isEmpty() || listaTareas == null) {
         // Do nothing
         return;
      }
      for (Task task : listaTareas) {
         listaTareas.remove(task);
      }
   }
}

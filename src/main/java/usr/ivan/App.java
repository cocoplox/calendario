package usr.ivan;


import java.util.List;

import usr.ivan.models.Task;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    public void run() {
       //Llamamos a la clase Initial, que pedirá credenciales y creará la tabla inicial
       Initial initial = new Initial();
       initial.inicializar();

   
       //Mostrar toda las tareas y tal, crear una clase propia
    TaskDAO taskDAO = new TaskDAO();
   // Task taskTest = new Task("Titulo", "descripcion", Date.from(Instant.now()));
    //taskDAO.saveTask(taskTest);

    //List<Task> allTasks = taskDAO.getAllTasks();
    //allTasks.forEach(task -> System.out.println(task));

    taskDAO.deleteTaskById(1);
    }



}

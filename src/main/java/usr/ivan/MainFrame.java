package usr.ivan;
import javax.swing.*;
public class MainFrame {
   //Me quiero suicidar

   /*
    * Interfáz gráfica
    */
   public void buildFrame(){
      JFrame ventana = new JFrame("Lista de tareas");
      ventana.setSize(720, 720);
      ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      ventana.setVisible(true);
   }
}

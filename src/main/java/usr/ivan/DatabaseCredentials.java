package usr.ivan;

import javax.swing.*;

import io.github.cdimascio.dotenv.Dotenv;

public class DatabaseCredentials {
  public String[] getCredentials() {
    String host, port, dbName, username, password;

    host = JOptionPane.showInputDialog("Introduce el host (default localhost):");
    port = JOptionPane.showInputDialog("Introduce el puerto (default: 3306);");
    dbName = JOptionPane.showInputDialog("Introduce el nombre de la base de datos: ");
    username = JOptionPane.showInputDialog("Introduce el nombre de usuario (hint: root): ");

    JPasswordField passwordField = new JPasswordField(20);
    int option = JOptionPane.showConfirmDialog(
        null,
        passwordField,
        "Contraseña",
        JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.QUESTION_MESSAGE);

    if (option == JOptionPane.OK_OPTION) {
      char[] contraseña = passwordField.getPassword();
      password = new String(contraseña);
      System.out.println(password);
    } else {
      System.out.println("Cancelaste la operacion");
      System.exit(2);
      return null;
    }

    host = (host == null || host.isEmpty()) ? "localhost" : host;
    port = (port == null || port.isEmpty()) ? "3306" : port;

    /*
     * TODO: Eliminar en la version final
     *
     * 
     */

    Dotenv dotenv = Dotenv.load();
    host = dotenv.get("DB_HOST");
    port = dotenv.get("DB_PORT");
    dbName = dotenv.get("DB_NAME");
    username = dotenv.get("DB_USERNAME");
    password = dotenv.get("DB_PASSWORD");
    String[] array = new String[] { host, port, dbName, username, password };
    return array;
  }
}

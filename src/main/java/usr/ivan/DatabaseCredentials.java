package usr.ivan;
import javax.swing.*;

public class DatabaseCredentials {
    public String[] getCredentials() {
        String host, port, dbName, username, password;

        host = JOptionPane.showInputDialog("Introduce el host (default localhost):");
        port = JOptionPane.showInputDialog("Introduce el puerto (default: 3306);");
        dbName = JOptionPane.showInputDialog("Introduce el nombre de la base de datos: ");
        username = JOptionPane.showInputDialog("Introduce el nombre de usuario (hint: root): ");
        password = JOptionPane.showInputDialog("Introduce la contraseña: ");

        host = (host == null || host.isEmpty()) ? "localhost" : host;
        port = (port == null || port.isEmpty()) ? "3306" : port;

        String[] array = new String[]{host,port,dbName,username,password};
        return array; 
    }
}

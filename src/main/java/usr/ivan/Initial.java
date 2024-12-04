package usr.ivan;

import usr.ivan.models.HibernateUtil;
import javax.swing.*;
public class Initial {
    // Aqui iniciaremos la base de datos.
    public void inicializar() {
        DatabaseCredentials dc = new DatabaseCredentials();

        try {
            HibernateUtil.buildSessionFactory(dc.getCredentials());

            
            System.out.println("Conexion con la base de datos, exitosa");

        } catch (Exception e) {

            System.err.println("Ha habido un error al iniciar la base de datos: " + e.getMessage());
            JOptionPane.showMessageDialog(
                null,
                "Credenciales incorrectas",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            System.exit(1);

        }
    }
}

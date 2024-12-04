package usr.ivan;
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

    }

}

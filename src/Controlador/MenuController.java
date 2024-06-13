package Controlador;

import Vista.Juego;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "Jugar") {
            Juego juego = new Juego();
            juego.cargarFrame();
            juego.reiniciarJuego();
        }

        if (e.getActionCommand() == "Salir") {
            System.exit(0);
        }
    }
}

package Modelo;

import Vista.Juego;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;

public class Enemigo {

    Laberinto laberinto = new Laberinto();

    private static String estado = "static";
    private static String vista = "derecha";

    private int x;
    private int y;
    private final int ancho = 42;
    private final int alto = 71;
    private final int movimiento = 15;

    public Enemigo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void paint(Graphics g) {
        
        if (estado == "movimiento" && vista == "derecha") {
            ImageIcon personaje = new ImageIcon(getClass().getResource("/Vista/Img/p2giftD.gif"));
            g.drawImage(personaje.getImage(), x, y, 40, 64, null);
        } else if (estado == "movimiento" && vista == "izquierda") {
            ImageIcon personaje = new ImageIcon(getClass().getResource("/Vista/Img/p2giftI.gif"));
            g.drawImage(personaje.getImage(), x, y, 40, 64, null);
        }
    }

    public Rectangle getEnemigo() {
        return new Rectangle(x, y, ancho, alto);
    }

    public void mover() {
        int[][] laberinto = this.laberinto.obtenerLaberinto();
        Random random = new Random();
        int direccion;

        direccion = random.nextInt(8);

        do {
            switch (direccion) {
                case 0: // Movimiento hacia la derecha
                    for (int i = 0; i < 2; i++) {
                        estado = "movimiento";
                        vista = "derecha";
                        if (laberinto[y / movimiento][(x / movimiento) + 1] == 0) {
                            x = x + movimiento;
                        } else {
                            break;
                        }
                    }
                    break;
                case 1: // Movimiento hacia la izquierda
                    for (int i = 0; i < 2; i++) {
                        estado = "movimiento";
                        vista = "izquierda";
                        if (laberinto[y / movimiento][(x / movimiento) - 1] == 0) {
                            x = x - movimiento;
                        } else {
                            break;
                        }
                    }
                    break;
                case 2: // Movimiento hacia arriba
                    for (int i = 0; i < 2; i++) {
                        estado = "movimiento";
                        if (laberinto[(y / movimiento) - 1][x / movimiento] == 0) {
                            y = y - movimiento;
                        } else {
                            break;
                        }
                    }
                    break;
                case 3: // Movimiento hacia abajo
                    for (int i = 0; i < 2; i++) {
                        estado = "movimiento";
                        if (laberinto[(y / movimiento) + 1][x / movimiento] == 0) {
                            y = y + movimiento;
                        } else {
                            break;
                        }
                    }
            }
        } while (laberinto[y / movimiento][x / movimiento] != 0);
    }
}

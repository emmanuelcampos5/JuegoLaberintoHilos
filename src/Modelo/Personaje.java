package modelo;

import Modelo.Laberinto;
import Vista.Juego;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Personaje {

    Laberinto laberinto = new Laberinto();

    private static int llaves = 0;
    private static String estado = "static";
    private static String vista = "derecha";

    private int x = 50;
    private int y = 40;
    private final int ancho = 32;
    private final int alto = 61;
    private final int movimiento = 15;

    //constructor
    

    public void paint(Graphics g) {
        if (estado == "static" && vista == "izquierda") {
            ImageIcon personaje = new ImageIcon(getClass().getResource("/Vista/Img/p1staticI.png"));
            g.drawImage(personaje.getImage(), x, y, ancho, alto, null);
        } else if (estado == "static" && vista == "derecha") {
            ImageIcon personaje = new ImageIcon(getClass().getResource("/Vista/Img/p1staticD.png"));
            g.drawImage(personaje.getImage(), x, y, ancho, alto, null);
        } else if (estado == "movimiento" && vista == "derecha") {
            ImageIcon personaje = new ImageIcon(getClass().getResource("/Vista/Img/p1giftD.gif"));
            g.drawImage(personaje.getImage(), x, y, 40, 64, null);
        } else if (estado == "movimiento" && vista == "izquierda") {
            ImageIcon personaje = new ImageIcon(getClass().getResource("/Vista/Img/p1giftI.gif"));
            g.drawImage(personaje.getImage(), x, y, 40, 64, null);
        }        
    }

    //KeyListener
    public void keyPressed(KeyEvent e) {
        int[][] laberinto = this.laberinto.obtenerLaberinto();

        try {
            if (e.getKeyCode() == KeyEvent.VK_D) {
                estado = "movimiento";
                vista = "derecha";
                if (laberinto[y / movimiento][(x / movimiento) + 1] == 0) {
                    x = x + movimiento;
                }
            }

            if (e.getKeyCode() == KeyEvent.VK_A) {
                estado = "movimiento";
                vista = "izquierda";
                if (laberinto[y / movimiento][(x / movimiento) - 1] == 0) {
                    x = x - movimiento;
                }
            }

            if (e.getKeyCode() == KeyEvent.VK_W) {
                estado = "movimiento";
                if (laberinto[(y / movimiento) - 1][x / movimiento] == 0) {
                    y = y - movimiento;
                }
            }

            if (e.getKeyCode() == KeyEvent.VK_S) {
                estado = "movimiento";
                if (laberinto[(y / movimiento) + 1][x / movimiento] == 0) {
                    y = y + movimiento;
                }
            }
        } catch (Exception ex) {

        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_D) {
            estado = "static";
        }

        if (e.getKeyCode() == KeyEvent.VK_A) {
            estado = "static";
        }

        if (e.getKeyCode() == KeyEvent.VK_W) {
            estado = "static";
        }

        if (e.getKeyCode() == KeyEvent.VK_S) {
            estado = "static";
        }
    }

    public Rectangle getPersonaje() {
        return new Rectangle(x, y, ancho, alto);
    }

    public void setLlaves() {
        this.llaves++;
    }

    public int getLlaves() {
        return llaves;
    }
}

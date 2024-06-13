package Vista;

import Modelo.Enemigo;
import Modelo.Laberinto;
import Modelo.Llave;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import modelo.Personaje;

public class Juego extends JPanel {

    JFrame ventana;

    Personaje personaje = new Personaje();
    Laberinto laberinto = new Laberinto();

    Enemigo enemigo1 = new Enemigo(329, 40);
    Enemigo enemigo2 = new Enemigo(335, 730);
    Enemigo enemigo3 = new Enemigo(600, 500);
    Enemigo enemigo4 = new Enemigo(600, 310);

    Llave llave1 = new Llave(100, 500);
    Llave llave2 = new Llave(800, 745);
    Llave llave3 = new Llave(95, 730);
    Llave llave4 = new Llave(815, 310);

    private static boolean gameOver = false;
    private static boolean gameWin = false;

    public Juego() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                personaje.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                personaje.keyReleased(e);
            }
        });
        setFocusable(true);

        ActualizarJuego();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujar(g);
    }

    public void dibujar(Graphics g) {
        System.out.println(laberinto);
        System.out.println(personaje);
        System.out.println(enemigo1);
        laberinto.paint(g);
        llave1.paint(g);
        llave2.paint(g);
        llave3.paint(g);
        llave4.paint(g);
        personaje.paint(g);
        enemigo1.paint(g);
        enemigo2.paint(g);
        enemigo3.paint(g);
        enemigo4.paint(g);

        enemigo1.mover();
        enemigo2.mover();
        enemigo3.mover();
        enemigo4.mover();
    }

    public void ColisionJuego() {
        Rectangle p1 = personaje.getPersonaje();
        Rectangle e1 = enemigo1.getEnemigo();
        Rectangle e2 = enemigo2.getEnemigo();
        Rectangle e3 = enemigo3.getEnemigo();
        Rectangle e4 = enemigo4.getEnemigo();
        Rectangle l1 = llave1.getLlave();
        Rectangle l2 = llave2.getLlave();
        Rectangle l3 = llave3.getLlave();
        Rectangle l4 = llave4.getLlave();

        if (p1.intersects(e1) || p1.intersects(e2) || p1.intersects(e3) || p1.intersects(e4)) {
            gameOver = true;
        }

        if (p1.getX() >= 800 && p1.getY() == 10) {
            gameWin = true;
        }

        if (p1.intersects(l1)) {
            llave1.setX(-100);
            llave1.setY(-100);
            personaje.setLlaves();
            laberinto.setLlaves(personaje.getLlaves());

        } else if (p1.intersects(l2)) {
            llave2.setX(-100);
            llave2.setY(-100);
            personaje.setLlaves();
            laberinto.setLlaves(personaje.getLlaves());

        } else if (p1.intersects(l3)) {
            llave3.setX(-100);
            llave3.setY(-100);
            personaje.setLlaves();
            laberinto.setLlaves(personaje.getLlaves());

        } else if (p1.intersects(l4)) {
            llave4.setX(-100);
            llave4.setY(-100);
            personaje.setLlaves();
            laberinto.setLlaves(personaje.getLlaves());
        }
    }

    public void ActualizarJuego() {
        Timer timer = new Timer(70, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ColisionJuego();
                repaint();

                if (gameOver || gameWin) {
                    // Detener el temporizador cuando el juego termina
                    ((Timer) e.getSource()).stop();

                    // Mostrar mensaje al jugador
                    if (gameOver) {
                        JOptionPane.showMessageDialog(null, "¡Has perdido!");
                        ventana.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "¡Has ganado!");
                        ventana.dispose();
                    }
                }
            }
        });
        timer.start();
    }

    public void cargarFrame() {
        ventana = new JFrame("Laberinto");
        ventana.add(this);
        ventana.setSize(935, 960);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void reiniciarJuego() {
        personaje = new Personaje();
        laberinto = new Laberinto();

        enemigo1 = new Enemigo(329, 40);
        enemigo2 = new Enemigo(335, 730);
        enemigo3 = new Enemigo(600, 500);
        enemigo4 = new Enemigo(600, 310);

        llave1 = new Llave(100, 500);
        llave2 = new Llave(800, 745);
        llave3 = new Llave(95, 730);
        llave4 = new Llave(815, 310);

        gameOver = false;
        gameWin = false;
    }
}


package Modelo;

import Vista.Juego;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Llave {
    
    private int x;
    private int y;
    private final int ancho = 32;
    private final int alto = 53;
    
    public Llave(int x, int y){
        this.x = x;
        this.y = y;
    } 
    
    public void paint(Graphics g) {
        ImageIcon llave = new ImageIcon(getClass().getResource("/Vista/Img/llave.png"));
        g.drawImage(llave.getImage(), x, y, ancho, alto, null);
    }
    
    public Rectangle getLlave() {
        return new Rectangle(x, y, ancho, alto);
    }
    
    public void setX(int x){
        this.x = x;
    }
    
    public void setY(int y){
        this.y = y;
    }
}

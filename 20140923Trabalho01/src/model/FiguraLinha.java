package model;

import java.awt.Graphics;

/**
 *
 * @author Mario
 */
public class FiguraLinha extends Figura {

    public FiguraLinha(int x, int y) {
        super(x, y);
        
    }

    @Override
    public void desenha(Graphics g) {
        g.drawLine(xIni, yIni, xFim, yFim);
    }

    @Override
    public boolean intersecta(int x, int y) {
        if (x < this.getX()) {
            return false;
        }
        if (x > (this.getX() + this.getLargura())) {
            return false;
        }
        if (y < this.getY()) {
            return false;
        }
        return y <= (this.getY() + this.getAltura());
    }
}

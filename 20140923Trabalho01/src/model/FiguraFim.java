package model;

import java.awt.Graphics;

/**
 *
 * @author 631220116
 */
public class FiguraFim extends Figura {
    
    private String texto;

    public FiguraFim(int x, int y) {
        super(x, y);
        this.texto = "";
    }
    
     public void iniciaTexto() {
        texto = "Fim";
    }

    @Override
    public void desenha(Graphics g) {
        int x = (xIni <= xFim) ? xIni : xFim;
        int y = (yIni <= yFim) ? yIni : yFim;
        int larg = Math.abs(xIni - xFim);
        int alt = Math.abs(yIni - yFim);
        g.drawOval(x, y, larg, alt);
        
        g.drawString(texto, x + larg / 2 - 10, y + alt / 2);
        
        if (this.estaSelecionado()) {
            g.drawOval(x - 2, y - 2, 4, 4);
            g.drawOval(x - 2, y + alt - 2, 4, 4);
            g.drawOval(x + larg - 2, y - 2, 4, 4);
            g.drawOval(x + larg - 2, y + alt - 2, 4, 4);
        }
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
        if (y > (this.getY() + this.getAltura())) {
            return false;
        }
        return true;
    }
}

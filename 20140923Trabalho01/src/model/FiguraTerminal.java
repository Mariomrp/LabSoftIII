package model;

import java.awt.FontMetrics;
import java.awt.Graphics;

/**
 *
 * @author 631220116 FiguraProcessamento -> cria retangulo
 */
public class FiguraTerminal extends Figura {

    protected String texto;

    public FiguraTerminal(int x, int y) {
        super(x, y);
        this.texto = "";
    }

    public void iniciaTexto(String texto) {
        this.texto = texto;
    }

    private int getLarguraTexto(Graphics g) {
        FontMetrics metrics = g.getFontMetrics(g.getFont());

        return (metrics.getHeight());

    }

    @Override
    public void desenha(Graphics g) {
        int x = (xIni <= xFim) ? xIni : xFim;
        int y = (yIni <= yFim) ? yIni : yFim;
        int larg = Math.abs(xIni - xFim);
        int alt = Math.abs(yIni - yFim);
        g.drawRect(x, y, larg, alt);

        int largTexto = getLarguraTexto(g);
        g.drawString(texto, x + larg / 2 - largTexto - (getLarguraTexto(g) / 2), y + alt / 2);
        if (this.estaSelecionado()) {
            g.drawRect(x - 2, y - 2, 4, 4);
            g.drawRect(x - 2, y + alt - 2, 4, 4);
            g.drawRect(x + larg - 2, y - 2, 4, 4);
            g.drawRect(x + larg - 2, y + alt - 2, 4, 4);
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

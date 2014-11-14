package control;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import model.Figura;

/**
 *
 * @author 631220116
 */
public class TeladeDesenho extends JPanel {

    List<Figura> listadeFiguras;

    public TeladeDesenho() {
        listadeFiguras = new ArrayList<>();
    }

    private void limparTela(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.BLACK);
    }

    public void addFigura(Figura f) {
        listadeFiguras.add(f);
    }

    public Figura getUltimaFigura() {
        return listadeFiguras.get(listadeFiguras.size() - 1);
    }

    public void removerFiguras() {
        listadeFiguras.clear();
    }

    @Override
    public void paintComponent(Graphics g) {
        limparTela(g);

        for (Figura f : listadeFiguras) {
            f.desenha(g);
        }
    }

    public void verificaSelecao(int x, int y) {
        deselecionarFiguras();
        for (Figura f : listadeFiguras) {
            if (f.intersecta(x, y)) {
                deselecionarFiguras();
                f.selecionar();
            }
        }
    }

    public Figura getSelecionado() {
        for (Figura f : listadeFiguras) {
            if (f.estaSelecionado()) {
                return f;
            }
        }
        return null;
    }

    public void deselecionarFiguras() {
        for (Figura f : listadeFiguras) {
            f.deselecionar();
        }
        repaint();
    }

    public void carregaDados(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        listadeFiguras = (List<Figura>) ois.readObject();
        ois.close();
        fis.close();
    }

    public void salvarDados(File file) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.reset();
        oos.writeObject(listadeFiguras);
        oos.close();
        fos.close();
    }
}

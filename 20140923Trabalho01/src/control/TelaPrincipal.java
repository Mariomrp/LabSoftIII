package control;

import model.FiguraFim;
import model.FiguraLinha;
import model.FiguraProcessamento;
import model.FiguraInicio;
import model.Figura;
import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import model.FiguraDecisao;
import model.FiguraTerminal;


/**
 *
 * @author 631220116
 */
class TelaPrincipal extends JFrame {

    TeladeDesenho teladeDesenho;
    //barra de ferramentas
    private JToolBar barradeFerramentas;
    private JToggleButton botaoFigInicio, botaoFigFim, botaoFigDecisao, botaoFigProcessamento,
                          botaoFigLinha, botaoFigSubrotina, botaoFigSelecionar, botaoFigLimpar;
    //itens do menu
    private JMenuItem menuItemNovo, menuItemAbrir, menuItemSalvar, menuItemSair, menuItemSobre;

    public TelaPrincipal() {
        super("Trabalho 01 .:FLUXOGRAMA:.");

        iniciaMenu();
        iniciaBarradeFerramentas();
        iniciaComponentes();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 620, 500);
        setVisible(true);
    }

    private void iniciaMenu() {
        JMenuBar menubar = new JMenuBar();

        JMenu menuArquivos = new JMenu("Arquivo");
        menuArquivos.setMnemonic(KeyEvent.VK_A);

        JMenu menuAjuda = new JMenu("Ajuda");
        menuArquivos.setMnemonic(KeyEvent.VK_J);

        menuItemSobre = new JMenuItem(TratadorMenu.SOBRE);
        menuItemSobre.setName(TratadorMenu.SOBRE);
        menuAjuda.add(menuItemSobre);
        menuItemSobre.addActionListener(new TratadorMenu());

        menuItemNovo = new JMenuItem(TratadorMenu.NOVO);
        menuItemNovo.setName(TratadorMenu.NOVO);
        menuArquivos.add(menuItemNovo);
        menuItemNovo.setMnemonic(KeyEvent.VK_N); // gera tecla de atalho "control + n"
        menuItemNovo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        menuItemNovo.setToolTipText("Insere Novo Fluxograma."); // ao colocar o ponteiro do mouse em cima mostra texto
        menuItemNovo.addActionListener(new TratadorMenu());

        menuItemAbrir = new JMenuItem(TratadorMenu.ABRIR);
        menuItemAbrir.setName(TratadorMenu.ABRIR);
        menuArquivos.add(menuItemAbrir);
        menuItemAbrir.setMnemonic(KeyEvent.VK_A);
        menuItemAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        menuItemAbrir.setToolTipText("Abre Fluxograma.");
        menuItemAbrir.addActionListener(new TratadorMenu());

        menuItemSalvar = new JMenuItem(TratadorMenu.SALVAR);
        menuItemSalvar.setName(TratadorMenu.SALVAR);
        menuArquivos.add(menuItemSalvar);
        menuItemSalvar.setMnemonic(KeyEvent.VK_S);
        menuItemSalvar.setAccelerator(KeyStroke.getKeyStroke("control S"));// usando String "nao nescessita colocar +"
        menuItemSalvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        menuItemSalvar.setToolTipText("Salva Fluxograma.");
        menuItemSalvar.addActionListener(new TratadorMenu());

        menuItemSair = new JMenuItem(TratadorMenu.SAIR);
        menuItemSair.setName(TratadorMenu.SAIR);
        menuArquivos.add(menuItemSair);
        menuItemSair.setMnemonic(KeyEvent.VK_R);
        menuItemSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.ALT_MASK | ActionEvent.CTRL_MASK));// combina control+alt
        menuItemSair.setToolTipText("Encerra Programa.");
        menuItemSair.addActionListener(new TratadorMenu());

        menubar.add(menuArquivos);
        menubar.add(Box.createHorizontalGlue());
        menubar.add(menuAjuda);

        setJMenuBar(menubar);
    }

    private void iniciaComponentes() {
        teladeDesenho = new TeladeDesenho();
        teladeDesenho.addMouseListener(new TratadorMouse());
        teladeDesenho.addMouseMotionListener(new TratadorMouse());
        this.add(teladeDesenho);
        this.add(barradeFerramentas, BorderLayout.NORTH);
        getContentPane().add(teladeDesenho);
    }

    private void iniciaBarradeFerramentas() {

        ButtonGroup grupo = new ButtonGroup();

        barradeFerramentas = new JToolBar();

        botaoFigInicio = new JToggleButton(createImageIcon("/imagens/inicio.jpg", "Inicio"));
        botaoFigInicio.setToolTipText("Inicio.");
        barradeFerramentas.add(botaoFigInicio);
        grupo.add(botaoFigInicio);
        barradeFerramentas.add(Box.createHorizontalStrut(10));

        botaoFigFim = new JToggleButton(createImageIcon("/imagens/fim.jpg", "Fim"));
        botaoFigFim.setToolTipText("Fim.");
        barradeFerramentas.add(botaoFigFim);
        grupo.add(botaoFigFim);
        barradeFerramentas.add(Box.createHorizontalStrut(10));
	
        botaoFigDecisao = new JToggleButton(createImageIcon("/imagens/decisao.jpg", "Decisão"));
        botaoFigDecisao.setToolTipText("Decisão.");
        barradeFerramentas.add(botaoFigDecisao);
        grupo.add(botaoFigDecisao);
        barradeFerramentas.add(Box.createHorizontalStrut(10));
	
        botaoFigProcessamento = new JToggleButton(createImageIcon("/imagens/processamento.jpg", "Processamento"));
        botaoFigProcessamento.setToolTipText("Processamento.");
        barradeFerramentas.add(botaoFigProcessamento);
        grupo.add(botaoFigProcessamento);
        barradeFerramentas.add(Box.createHorizontalStrut(10));

        botaoFigLinha = new JToggleButton(createImageIcon("/imagens/fluxo.jpg", "Fluxo"));
        botaoFigLinha.setToolTipText("Fluxo.");
        barradeFerramentas.add(botaoFigLinha);
        grupo.add(botaoFigLinha);
        barradeFerramentas.add(Box.createHorizontalStrut(10));

        botaoFigSubrotina = new JToggleButton(createImageIcon("/imagens/subrotina.jpg", "SubRotina"));
        botaoFigSubrotina.setToolTipText("SubRotina.");
        barradeFerramentas.add(botaoFigSubrotina);
        grupo.add(botaoFigSubrotina);
        barradeFerramentas.add(Box.createHorizontalStrut(10));

        botaoFigSelecionar = new JToggleButton("Selecionar");
        botaoFigSelecionar.setToolTipText("Seleciona Item.");
        barradeFerramentas.add(botaoFigSelecionar);
        grupo.add(botaoFigSelecionar);
        barradeFerramentas.add(Box.createVerticalStrut(10));

        botaoFigLimpar = new JToggleButton("Limpar");
        botaoFigLimpar.setToolTipText("Limpar Tela.");
        barradeFerramentas.add(botaoFigLimpar);
        grupo.add(botaoFigLimpar);
        barradeFerramentas.add(Box.createVerticalStrut(10));
    }

    protected static ImageIcon createImageIcon(String path, String description) {
        java.net.URL imgURL = TelaPrincipal.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("Arquivo não encontrado: " + path);
            return null;
        }
    }

    private class TratadorMouse extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            if (botaoFigSelecionar.isSelected()) {
                teladeDesenho.verificaSelecao(e.getX(), e.getY());
            } else if (botaoFigInicio.isSelected()) {
                FiguraInicio figinicio = new FiguraInicio(e.getX(), e.getY());
                teladeDesenho.addFigura(figinicio);
            } else if (botaoFigProcessamento.isSelected()) {
                FiguraProcessamento figproc = new FiguraProcessamento(e.getX(), e.getY());
                teladeDesenho.addFigura(figproc);
            } else if (botaoFigFim.isSelected()) {
                FiguraFim figfim = new FiguraFim(e.getX(), e.getY());
                teladeDesenho.addFigura(figfim);
            } else if (botaoFigLinha.isSelected()) {
                FiguraLinha figlinha = new FiguraLinha(e.getX(), e.getY());
                teladeDesenho.addFigura(figlinha);
            } else if (botaoFigDecisao.isSelected()) {
                FiguraDecisao figdec = new FiguraDecisao(e.getX(), e.getY());
                teladeDesenho.addFigura(figdec);
            } else if (botaoFigSubrotina.isSelected()) {
                FiguraTerminal figterm = new FiguraTerminal(e.getX(), e.getY());
                teladeDesenho.addFigura(figterm);
            } else if (botaoFigLimpar.isSelected()) {
                teladeDesenho.removerFiguras();
            } 
            teladeDesenho.repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (botaoFigInicio.isSelected() || botaoFigFim.isSelected() || botaoFigProcessamento.isSelected() 
                || botaoFigDecisao.isSelected() || botaoFigLinha.isSelected() || botaoFigSubrotina.isSelected()) {
                Figura figura = teladeDesenho.getUltimaFigura();
                figura.setPontoFinal(e.getX(), e.getY());

                if (botaoFigInicio.isSelected()) {
                    ((FiguraInicio) figura).iniciaTexto();
                }

                if (botaoFigFim.isSelected()) {
                    ((FiguraFim) figura).iniciaTexto();
                }
		                
            } else if (botaoFigSelecionar.isSelected()) {

                Figura figura = teladeDesenho.getSelecionado();
                if (figura != null && figura.intersecta(e.getX(), e.getY())) {
                    figura.moveTo(e.getX(), e.getY());
                }
            }
            teladeDesenho.repaint();
        }
        
        @Override
        public void mouseReleased(MouseEvent e) {
                if (botaoFigProcessamento.isSelected()) {
                    String texto = JOptionPane.showInputDialog(null, "Digite o Procedimento.");
                    Figura figura = teladeDesenho.getUltimaFigura();
                    ((FiguraProcessamento) figura).iniciaTexto(texto);
                }
                
                if (botaoFigDecisao.isSelected()) {
                    String texto = JOptionPane.showInputDialog(null, "Digite a Decisão.");
                    Figura figura = teladeDesenho.getUltimaFigura();
                    ((FiguraDecisao) figura).iniciaTexto(texto);
                }                
                teladeDesenho.repaint();
        }
    }

    public class TratadorMenu implements ActionListener {

        public static final String NOVO = "Novo";
        public static final String ABRIR = "Abrir";
        public static final String SALVAR = "Salvar";
        public static final String SAIR = "Sair";
        public static final String SOBRE = "Sobre";        

        @Override
        public void actionPerformed(ActionEvent e) {
            JComponent componente = (JComponent) e.getSource();
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            switch (componente.getName()) {
                case NOVO:
                    teladeDesenho.removerFiguras();
                    teladeDesenho.repaint();
                    break;
                case ABRIR:
                    int returnVa = fileChooser.showOpenDialog(TelaPrincipal.this);

                    if (returnVa == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile();
                        try {
                            teladeDesenho.carregaDados(file);
                            teladeDesenho.repaint();
                            JOptionPane.showMessageDialog(TelaPrincipal.this, "Arquivo carregado com sucesso!");
                        } catch (IOException | ClassNotFoundException | HeadlessException exc) {
                            JOptionPane.showMessageDialog(TelaPrincipal.this, "Erro ao ler do arquivo!");
                        }
                    }
                    break;
                case SALVAR:
                    int returnVal = fileChooser.showSaveDialog(TelaPrincipal.this);
                    if (returnVal == JFileChooser.APPROVE_OPTION) {
                        File file = fileChooser.getSelectedFile();
                        try {
                            teladeDesenho.salvarDados(file);
                            JOptionPane.showMessageDialog(TelaPrincipal.this, "Arquivo salvo com sucesso!");
                        } catch (IOException ex) {
                            JOptionPane.showMessageDialog(TelaPrincipal.this, "Erro ao salvar no arquivo!");
                        }
                    }
                    break;
                case SOBRE:
                    JOptionPane.showMessageDialog(TelaPrincipal.this, "Inicio do Trabalho 01(Fluxograma)\nVersão 0.6 \n Autores:\n*Mário\n*Jonathan");
                    break;
                case SAIR:
                    System.exit(0);
                    break;
            }
        }
    }
}

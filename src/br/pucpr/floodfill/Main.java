package br.pucpr.floodfill;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            File arquivoOriginal = new File("labirinto.png");
            if (!arquivoOriginal.exists()) {
                JOptionPane.showMessageDialog(null,
                        "O arquivo 'labirinto.png' não foi encontrado na raiz do projeto!",
                        "Erro de Arquivo", JOptionPane.ERROR_MESSAGE);
                return;
            }

            BufferedImage imagemOriginal = ImageIO.read(arquivoOriginal);

            JFrame janela = new JFrame("Visualizador Flood Fill - PUCPR");
            JLabel labelImagem = new JLabel(new ImageIcon(imagemOriginal));
            janela.add(labelImagem);
            janela.pack();
            janela.setLocationRelativeTo(null);
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            janela.setVisible(true);

            FloodFillManager gerenciador = new FloodFillManager(imagemOriginal, labelImagem);

            String[] opcoes = {"Pilha (Stack)", "Fila (Queue)"};
            int escolha = JOptionPane.showOptionDialog(null,
                    "Qual estrutura de dados deseja utilizar?",
                    "Configuração do Sistema",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null, opcoes, opcoes[0]);

            if (escolha == -1) return;

            int xInicial = 50;
            int yInicial = 5;
            int corAmarela = 0xFFFFFF00;

            new Thread(() -> {
                try {
                    if (escolha == 0) {
                        gerenciador.preencherComPilha(xInicial, yInicial, corAmarela);
                        gerenciador.salvarImagem("resultado_pilha.png");
                    } else {
                        gerenciador.preencherComFila(xInicial, yInicial, corAmarela);
                        gerenciador.salvarImagem("resultado_fila.png");
                    }

                    JOptionPane.showMessageDialog(janela,
                            "Preenchimento finalizado com sucesso!",
                            "Sucesso", JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(janela,
                            "Erro durante o processamento: " + e.getMessage(),
                            "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }).start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
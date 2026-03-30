package br.pucpr.floodfill;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FloodFillManager {
    private BufferedImage imagem;
    private JLabel componenteVisual;
    private int corAlvo;
    private int corSubstituta;
    private int contadorFrames = 0;

    private final int INTERVALO_REFRESH = 50;
    private final int DELAY_MS = 1;

    public FloodFillManager(BufferedImage imagem, JLabel componenteVisual) {
        this.imagem = imagem;
        this.componenteVisual = componenteVisual;
    }


    public void preencherComPilha(int xInicial, int yInicial, int novaCor) throws IOException {
        this.corAlvo = imagem.getRGB(xInicial, yInicial);
        this.corSubstituta = novaCor;

        if (corAlvo == corSubstituta) return;

        Stack<Pixel> pilha = new Stack<>();
        pilha.empilhar(new Pixel(xInicial, yInicial));

        while (!pilha.estaVazia()) {
            Pixel p = pilha.desempilhar();

            if (isInvalido(p.getX(), p.getY())) continue;

            aplicarPixel(p.getX(), p.getY());

            pilha.empilhar(new Pixel(p.getX() + 1, p.getY()));
            pilha.empilhar(new Pixel(p.getX() - 1, p.getY()));
            pilha.empilhar(new Pixel(p.getX(), p.getY() + 1));
            pilha.empilhar(new Pixel(p.getX(), p.getY() - 1));
        }
    }

    public void preencherComFila(int xInicial, int yInicial, int novaCor) throws IOException {
        this.corAlvo = imagem.getRGB(xInicial, yInicial);
        this.corSubstituta = novaCor;

        if (corAlvo == corSubstituta) return;

        Queue<Pixel> fila = new Queue<>();
        fila.enfileirar(new Pixel(xInicial, yInicial));

        while (!fila.estaVazia()) {
            Pixel p = fila.desenfileirar();

            if (isInvalido(p.getX(), p.getY())) continue;

            aplicarPixel(p.getX(), p.getY());

            fila.enfileirar(new Pixel(p.getX() + 1, p.getY()));
            fila.enfileirar(new Pixel(p.getX() - 1, p.getY()));
            fila.enfileirar(new Pixel(p.getX(), p.getY() + 1));
            fila.enfileirar(new Pixel(p.getX(), p.getY() - 1));
        }
    }

    private boolean isInvalido(int x, int y) {
        if (x < 0 || x >= imagem.getWidth() || y < 0 || y >= imagem.getHeight()) {
            return true;
        }
        return imagem.getRGB(x, y) != corAlvo;
    }

    private void aplicarPixel(int x, int y) throws IOException {
        imagem.setRGB(x, y, corSubstituta);
        contadorFrames++;
        if (contadorFrames % INTERVALO_REFRESH == 0) {
            if (componenteVisual != null) {
                componenteVisual.repaint();
                try {
                    Thread.sleep(DELAY_MS);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        if (contadorFrames % 500 == 0) {
            salvarImagem("frames/frame_" + contadorFrames + ".png");
        }
    }

    public void salvarImagem(String nomeArquivo) throws IOException {
        File arquivoSaida = new File(nomeArquivo);
        if (arquivoSaida.getParentFile() != null) {
            arquivoSaida.getParentFile().mkdirs();
        }
        ImageIO.write(imagem, "png", arquivoSaida);
    }
}
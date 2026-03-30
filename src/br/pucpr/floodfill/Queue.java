package br.pucpr.floodfill;

public class Queue<T> {
    private Node<T> primeiro;
    private Node<T> ultimo;

    public void enfileirar(T dado) {
        Node<T> novoNo = new Node<>(dado);
        if (estaVazia()) {
            primeiro = novoNo;
        } else {
            ultimo.setNext(novoNo);
        }
        ultimo = novoNo;
    }

    public T desenfileirar() {
        if (estaVazia()) {
            return null;
        }

        T valor = primeiro.getData();
        primeiro = primeiro.getNext();

        if (primeiro == null) {
            ultimo = null;
        }

        return valor;
    }

    public boolean estaVazia() {
        return primeiro == null;
    }
}
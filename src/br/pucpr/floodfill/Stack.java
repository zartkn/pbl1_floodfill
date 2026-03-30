package br.pucpr.floodfill;

public class Stack<T> {
    private Node<T> topo;

    public void empilhar(T dado) {
        Node<T> novoNo = new Node<>(dado);
        novoNo.setNext(topo);
        topo = novoNo;
    }

    public T desempilhar() {
        if (estaVazia()) {
            return null;
        }

        T valor = topo.getData();
        topo = topo.getNext();
        return valor;
    }

    public boolean estaVazia() {
        return topo == null;
    }
}
package avltree;

import bstreelinklistinterfgeneric.LinkedBST;
import Exceptions.ItemDuplicated;
import Exceptions.ExceptionIsEmpty;
import Exceptions.ItemNotFound;

public class AVLTree<E extends Comparable<E>> extends LinkedBST<E> {
    protected boolean height;

    protected class NodeAVL extends Node {
        protected int bf;

        public NodeAVL(E data) {
            this(data, null, null, 0);
        }

        public NodeAVL(E data, Node left, Node rigth, int bf) {
            super(data, left, rigth);
            this.bf = bf;
        }

        @Override
        public String toString() {
            return data + " (bf=" + bf + ")";
        }
    }

    public AVLTree() {
        super();
    }

    @Override
    public void insert(E x) throws ItemDuplicated {
        this.height = false;
        this.root = insert(x, (NodeAVL) this.root);
    }

    protected NodeAVL insert(E x, NodeAVL node) throws ItemDuplicated {
        NodeAVL fat = node;

        if (node == null) {
            this.height = true;
            fat = new NodeAVL(x);
        } else {
            int resC = x.compareTo(node.data);
            if (resC == 0)
                throw new ItemDuplicated(x + " ya se encuentra en el árbol...");

            if (resC > 0) {
                fat.rigth = insert(x, (NodeAVL) node.rigth);
                if (this.height) {
                    switch (fat.bf) {
                        case -1: fat.bf = 0; this.height = false; break;
                        case 0:  fat.bf = 1; this.height = true; break;
                        case 1:
                            fat = balanceToLeft(fat);
                            this.height = false;
                            break;
                    }
                }
            } else {
                fat.left = insert(x, (NodeAVL) node.left);
                if (this.height) {
                    switch (fat.bf) {
                        case 1: fat.bf = 0; this.height = false; break;
                        case 0: fat.bf = -1; this.height = true; break;
                        case -1:
                            fat = balanceToRight(fat);
                            this.height = false;
                            break;
                    }
                }
            }
        }

        return fat;
    }

    private NodeAVL balanceToLeft(NodeAVL node) {
        NodeAVL hijo = (NodeAVL) node.rigth;
        switch (hijo.bf) {
            case 1:
                node.bf = 0;
                hijo.bf = 0;
                node = rotateSL(node);
                break;
            case -1:
                NodeAVL nieto = (NodeAVL) hijo.left;
                switch (nieto.bf) {
                    case -1: node.bf = 0; hijo.bf = 1; break;
                    case 0:  node.bf = 0; hijo.bf = 0; break;
                    case 1:  node.bf = -1; hijo.bf = 0; break;
                }
                nieto.bf = 0;
                node.rigth = rotateSR(hijo);
                node = rotateSL(node);
                break;
        }
        return node;
    }

    private NodeAVL balanceToRight(NodeAVL node) {
        NodeAVL hijo = (NodeAVL) node.left;
        switch (hijo.bf) {
            case -1:
                node.bf = 0;
                hijo.bf = 0;
                node = rotateSR(node);
                break;
            case 1:
                NodeAVL nieto = (NodeAVL) hijo.rigth;
                switch (nieto.bf) {
                    case 1:  node.bf = 0; hijo.bf = -1; break;
                    case 0:  node.bf = 0; hijo.bf = 0; break;
                    case -1: node.bf = 1; hijo.bf = 0; break;
                }
                nieto.bf = 0;
                node.left = rotateSL(hijo);
                node = rotateSR(node);
                break;
        }
        return node;
    }

    public NodeAVL getRoot() {
        return this.root;
    }
    
    private NodeAVL rotateSL(NodeAVL node) {
        System.out.println("Rotación Simple a la Izquierda (RSL) en nodo: " + node.data);
        NodeAVL p = (NodeAVL) node.rigth;
        node.rigth = p.left;
        p.left = node;
        System.out.println("Nueva raíz del subárbol: " + p.data);
        return p;
    }

    private NodeAVL rotateSR(NodeAVL node) {
        System.out.println("Rotación Simple a la Derecha (RSR) en nodo: " + node.data);
        NodeAVL p = (NodeAVL) node.left;
        node.left = p.rigth;
        p.rigth = node;
        System.out.println("Nueva raíz del subárbol: " + p.data);
        return p;
    }

    protected void parenthesize(NodeAVL node, int level) {
        if (node == null) return;

        for (int i = 0; i < level; i++) System.out.print("  ");
        System.out.println(node.data + " (bf=" + node.bf + ")");

        if (node.left != null || node.rigth != null) {
            if (node.left != null) {
                for (int i = 0; i < level + 1; i++) System.out.print("  ");
                System.out.print("(");
                System.out.println();
                parenthesize((NodeAVL) node.left, level + 2);
                for (int i = 0; i < level + 1; i++) System.out.print("  ");
                System.out.println(")");
            }

            if (node.rigth != null) {
                for (int i = 0; i < level + 1; i++) System.out.print("  ");
                System.out.print("(");
                System.out.println();
                parenthesize((NodeAVL) node.rigth, level + 2);
                for (int i = 0; i < level + 1; i++) System.out.print("  ");
                System.out.println(")");
            }
        }
    }

    
    protected NodeAVL root;
    
    @Override
    public void inOrder() {
        inOrder(root); // Usa el root de tipo NodeAVL
        System.out.println();
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.rigth);
        }
    }

    
    @Override
    public void delete(E data) throws ExceptionIsEmpty {
        if (root == null)
            throw new ExceptionIsEmpty("El árbol está vacío.");
        this.height = false;
        root = delete(data, root);
    }

    private NodeAVL delete(E x, NodeAVL node) {
        if (node == null) return null;

        int resC = x.compareTo(node.data);

        if (resC < 0) {
            node.left = delete(x, (NodeAVL) node.left);
            if (this.height)
                node = balanceAfterRightDelete(node);
        } else if (resC > 0) {
            node.rigth = delete(x, (NodeAVL) node.rigth);
            if (this.height)
                node = balanceAfterLeftDelete(node);
        } else {
            if (node.left == null) {
                node = (NodeAVL) node.rigth;
                this.height = true;
            } else if (node.rigth == null) {
                node = (NodeAVL) node.left;
                this.height = true;
            } else {
                NodeAVL minNode = findMinNode((NodeAVL) node.rigth);
                node.data = minNode.data;
                node.rigth = delete(minNode.data, (NodeAVL) node.rigth);
                if (this.height)
                    node = balanceAfterLeftDelete(node);
            }
        }
        return node;
    }

    private NodeAVL balanceAfterLeftDelete(NodeAVL node) {
        switch (node.bf) {
            case 1:
                node.bf = 0;
                break;
            case 0:
                node.bf = -1;
                this.height = false;
                break;
            case -1:
                NodeAVL leftChild = (NodeAVL) node.left;
                if (leftChild.bf <= 0) {
                    node = rotateSR(node);
                    node.bf = 0;
                    ((NodeAVL) node.rigth).bf = 0;
                    this.height = (leftChild.bf == 0);
                } else {
                    node.left = rotateSL(leftChild);
                    node = rotateSR(node);
                    updateBalanceAfterDoubleRotation(node);
                }
                break;
        }
        return node;
    }


    private NodeAVL balanceAfterRightDelete(NodeAVL node) {
        switch (node.bf) {
            case -1:
                node.bf = 0;
                break;
            case 0:
                node.bf = 1;
                this.height = false;
                break;
            case 1:
                NodeAVL rightChild = (NodeAVL) node.rigth;
                if (rightChild.bf >= 0) {
                    node = rotateSL(node);
                    node.bf = 0;
                    ((NodeAVL) node.left).bf = 0;
                    this.height = (rightChild.bf == 0);
                } else {
                    node.rigth = rotateSR(rightChild);
                    node = rotateSL(node);
                    updateBalanceAfterDoubleRotation(node);
                }
                break;
        }
        return node;
    }

    private void updateBalanceAfterDoubleRotation(NodeAVL node) {
        if (node.bf == 0) {
            ((NodeAVL) node.left).bf = 0;
            ((NodeAVL) node.rigth).bf = 0;
        } else if (node.bf == 1) {
            ((NodeAVL) node.left).bf = -1;
            ((NodeAVL) node.rigth).bf = 0;
        } else {
            ((NodeAVL) node.left).bf = 0;
            ((NodeAVL) node.rigth).bf = 1;
        }
        node.bf = 0;
    }


    private NodeAVL findMinNode(NodeAVL node) {
        while (node.left != null)
            node = (NodeAVL) node.left;
        return node;
    }
    
 // Recorrido por niveles recursivo para AVLTree
    public void levelOrderRecursive() {
        int h = height(root);
        for (int i = 0; i <= h; i++) {
            printLevel(root, i);
        }
        System.out.println();
    }

    // Altura de un nodo AVL (igual que en LinkedBST, pero con NodeAVL)
    private int height(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.rigth));
    }

    // Imprimir nodos en un nivel dado (recursivo)
    private void printLevel(Node node, int level) {
        if (node == null) return;
        if (level == 0) {
            System.out.print(node.data + " ");
        } else {
            printLevel(node.left, level - 1);
            printLevel(node.rigth, level - 1);
        }
    }
    
 // Método público para preorden que inicia la llamada recursiva
    @Override
    public void preOrder() {
        preOrder(root);
        System.out.println();
    }

    // Método recursivo privado para recorrer en preorden usando NodeAVL
    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.rigth);
        }
    }

    public void parenthesize() {
        parenthesize(this.root, 0); // Llama al método protegido o privado
    }


}

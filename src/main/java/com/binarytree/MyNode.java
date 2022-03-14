package com.binarytree;


public class MyNode {
    private  int value;
    private  String label;
    public MyNode left;
    public   MyNode right;

    public MyNode(int value,String label) {
        this.value = value;
        this.left=null;
        this.right=null;
        this.label = label;
    }

    public MyNode() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public MyNode getLeft() {
        return left;
    }

    public void setLeft(MyNode left) {
        this.left = left;
    }

    public MyNode getRight() {
        return right;
    }

    public void setRight(MyNode right) {
        this.right = right;
    }
}

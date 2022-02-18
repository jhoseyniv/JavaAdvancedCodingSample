package binarytree;


import java.util.ArrayList;

public class MyBinaryTree {

    private MyNode root;

    public MyNode getRoot() {
        return root;
    }

    public void setRoot(MyNode root) {
        this.root = root;
    }

    public MyBinaryTree(MyNode root) {
        this.root = root;
    }

    public MyBinaryTree() {
        root =null;
    }

    public void addNode(MyNode current, int value, String lable){
         if(value < current.getValue()) {
             if(current.left != null) {
                 addNode(current.left,value,lable);
             }
             else {
                 System.out.println("Add a node ("+value + " , "+ lable + ") to left of node(" + current.getValue() + " , " + current.getLabel() + ");");
                 current.left = new MyNode(value,lable);
             }
        }
       else if (value > current.getValue()){
            if(current.right !=null) {
                addNode(current.right, value, lable);
            }
             else {
                System.out.println("Add a node ("+value + " , "+ lable + ") to right of node(" + current.getValue() + " , " + current.getLabel() + ");");
                current.right = new MyNode(value,lable);
            }
        }
    }


    public void preOrderTravers(MyNode current){
        if(current==null) return;
         System.out.print(current.getValue() + " , ");
        preOrderTravers(current.left);
        preOrderTravers(current.right);
    }
    public void postOrderTravers(MyNode current){
        if(current==null) return;
        postOrderTravers(current.left);
        postOrderTravers(current.right);
        System.out.print(current.getValue() + " , ");
    }
    public void inOrderTravers(MyNode current){
        if(current==null) return;
        inOrderTravers(current.left);
        System.out.print(current.getValue() + " , ");
        inOrderTravers(current.right);
    }
    public MyNode getChildernOfNode(MyNode start,int value, String label){

        if(start== null ) return null;
        if (start.getValue() == value && start.getLabel().equalsIgnoreCase(label))   return start;

           MyNode res1= getChildernOfNode(start.left,value,label);
            if(res1 !=null) return  res1;
           MyNode res2 = getChildernOfNode(start.right,value,label);
        return  res2;
    }

    public MyNode getParentOfNode(MyNode start,int value, String label){

        if(start.left == null  &&  start.right == null) return null;

        if(start.left == null )  return getParentOfNode(start.right,value,label);
        if (start.left.getValue() == value && start.left.getLabel().equalsIgnoreCase(label) ||
                    start.right.getValue() == value && start.right.getLabel().equalsIgnoreCase(label))   return start;

        if(start.getValue() > value)
            return getParentOfNode(start.left,value,label);

        if(start.getValue() < value)
            return getParentOfNode(start.right,value,label);
        return null;
    }
    public int getHeightOfTree(MyNode start) {
        if(start==null ) return -1;
            int leftH= getHeightOfTree(start.left);
            int rightH= getHeightOfTree(start.right);
            if(leftH > rightH ) return  leftH+1;
            else  return  rightH +1;
    }


}

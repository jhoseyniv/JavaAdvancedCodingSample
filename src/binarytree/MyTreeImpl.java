package binarytree;

import java.time.LocalDate;
import java.util.Scanner;

public class MyTreeImpl {

    public static void main(String args[]){
        MyBinaryTree myBinaryTree=new MyBinaryTree( new MyNode(0,"Root"));

        myBinaryTree.addNode(myBinaryTree.getRoot(),6,"11");
        myBinaryTree.addNode(myBinaryTree.getRoot(),4,"12");
        myBinaryTree.addNode(myBinaryTree.getRoot(),8,"22");
        myBinaryTree.addNode(myBinaryTree.getRoot(),3,"23");
        myBinaryTree.addNode(myBinaryTree.getRoot(),5,"34");
        myBinaryTree.addNode(myBinaryTree.getRoot(),7,"45");
        myBinaryTree.addNode(myBinaryTree.getRoot(),9,"56");

        System.out.println("Pre Order travers of this tree is : ");
        myBinaryTree.preOrderTravers(myBinaryTree.getRoot());
        System.out.println("\n ");

        System.out.println("Post Order travers of this tree is : ");
        myBinaryTree.postOrderTravers(myBinaryTree.getRoot());
        System.out.println("\n ");

        System.out.println("In Order travers of this tree is : ");
        myBinaryTree.inOrderTravers(myBinaryTree.getRoot());


        System.out.println("<---------------- Find childerns ------------------>");
        int val=4;
        String st="12";
        MyNode  child=myBinaryTree.getChildernOfNode(myBinaryTree.getRoot(),val,st);
        if(child.left!=null)
            System.out.println("Left child of " +val + " is : " + child.left.getValue()  );
        if(child.right!=null)
            System.out.println("right child of " +val + " is : " + child.right.getValue() );

        int childVal=4;
        String childLabel="12";
        System.out.println("<---------------- Find Parent ------------------>");
        MyNode parent =myBinaryTree.getParentOfNode(myBinaryTree.getRoot(),childVal,childLabel);
        System.out.println("parent of : " + parent.getValue());


        System.out.println("<---------------- Find Height Of Tree ------------------>");
        int height = myBinaryTree.getHeightOfTree(myBinaryTree.getRoot());
        System.out.println("Height of tree is : " + height);

    }
}

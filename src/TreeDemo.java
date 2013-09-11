/**
 * Created with IntelliJ IDEA.
 * User: Stephen
 * Date: 9/10/13
 * Time: 11:01 PM
 * To change this template use File | Settings | File Templates.
 */

import java.util.*;

public class TreeDemo
{
    public static void main(String[] asd)
    {
        Tree t = new Tree();
        String s = "16428973";
        t.BSTree(s);
        System.out.println("Number of nodes: " + t.countNodes());
        System.out.println("Number of leaves: " + t.countLeaves());
        System.out.println("Tree height: " + t.height());

        System.out.print("In-order: ");
        t.inOrder();
        System.out.print("Pre-order: ");
        t.preOrder();
        System.out.print("Post-order: ");
        t.postOrder();

        System.out.println("Is 2 in the tree? " + t.search('2'));
        System.out.println("Is 5 in the tree? " + t.search('5'));
        t.findHeight();
        t.bfs();
        t.erase();
        System.out.println("Tree erased!");
    }
}

class Tree
{

    class Node
    {
        Object data;
        Node left, right;
    }

    Node root = null;

    // build a binary search tree from an input string
    public void BSTree(String s)
    {
        int len = s.length();
        char ch = s.charAt(0);
        root = subTree (ch);
        Node p= null, q;//p chases q
        Comparable item;
        for(int j= 1; j < len; j++)
        {
            q = root;
            item = s.charAt(j);//auto boxing
            while(q != null)
            {
                p = q;//p will chase q
                if(item.compareTo(q.data) <0)
                {
                    q = q.left;
                }
                else
                {
                    q = q.right;
                }
            }//q points to null and p is a leaf
            Node temp = subTree(item);
            if(item.compareTo(p.data) <0)
            {
                p.left = temp;
            }
            else
            {
                p.right = temp;
            }
        }

    }

	/*----------  Collection of methods on Trees  ------------*/

    // count the number of nodes in the tree
    public int countNodes()
    {
        return countNodes(root);
    }

    private int countNodes(Node t)
    {
        if(t != null)
        {
            return 1 + countNodes(t.left) + countNodes(t.right);
        }
        return 0;
    }

    // count the number of leaves in the tree
    public int countLeaves()
    {
        return countLeaves(root);
    }

    private int countLeaves(Node t)
    {
        if(t != null)
        {
            if(isLeaf(t))
            {
                return 1;
            }
            else
                return countLeaves(t.left) + countLeaves(t.right);
        }
        return 0;
    }

    // compute the tree height
    public int height()
    {
        return h(root);
    }

    private int h(Node t)
    {
        if(t == null)
            return -1;
        return 1 + Math.max(h(t.left), h(t.right) );
    }

    // compute the hight for all the leaves
    public void findHeight()
    {
        findHeight(root, 0);
    }

    private void findHeight(Node t, int h)
    {
        if(t != null)
        {
            findHeight(t.left, h+1);
            if(isLeaf(t) )
            {
                System.out.println(t.data + "|" + h);
            }
            findHeight(t.right, h+1);
        }
    }

    // erease the tree content
    public void erase()
    {
        root = erase(root);
    }

    private Node erase(Node t)
    {
        if(t != null)
        {
            t.left = erase(t.left);
            t.right = erase(t.right);
            t = null;
        }
        return null;
    }

    // check if a node is a leaf
    private boolean isLeaf(Node t)
    {
        return t.left== null && t.right == null;
    }

    // return true if the char c is contained in the tree
    public boolean search(char c)
    {
        Comparable item = c;//auto boxing
        Node t = root;
        while(t != null)
        {
            if(item.compareTo(t.data) == 0)
                return true;

            if(item.compareTo(t.data) >0)
                t = t.right;
            else t = t.left;
        }
        return false;
    }

    // create a subtree (node) to be added to the tree
    public Node  subTree(Comparable obj)
    {
        Node temp = new Node();
        temp.data = obj;
        temp.left = null;
        temp.right = null;
        return temp;
    }

    // in-order traversal
    public void inOrder()
    {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node t)
    {
        if(t != null)
        {
            inOrder(t.left);
            System.out.print (t.data);
            inOrder(t.right);
        }
    }

    // pre-order traversal
    public void preOrder()
    {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node t)
    {
        if(t != null)
        {
            System.out.print (t.data);
            preOrder(t.left);
            preOrder(t.right);
        }
    }

    // post-order traversal
    public void postOrder()
    {
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node t)
    {
        if(t != null)
        {
            postOrder(t.left);
            postOrder(t.right);
            System.out.print (t.data);
        }
    }

    public void bfs()
    {
        LinkedList<Node> list = new LinkedList<Node>();
        Node q = root;
        if( q != null)
        {
            list.addLast(q);
            while(list.size() !=0)
            {
                q = list.removeFirst();
                System.out.print(q.data);
                if(q.left != null)
                {
                    list.addLast(q.left);
                }
                if(q.right != null)
                {
                    list.addLast(q.right);
                }
            }
        }
        System.out.println();
    }
}

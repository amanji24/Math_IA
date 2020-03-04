import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.event.ListSelectionEvent;

public class BinaryTree {

	Node root;
	int depth = 0;
	int nodes = 0;
	  
    // Constructors 
    BinaryTree(int key) 
    { 
        root = new Node(key); 
        nodes = 1;
    } 
  
    BinaryTree() 
    { 
        root = null; 
    }
    
    public String toString() {
    	
    	String s = "";
    	s += addToString(root);
    	s = removeCommas(s);
    	int l = s.length();
    	String str = "";
    	for (int i = 0; i < l; i++) {
    		str += s.substring(i,i+1);
    		if (i != l-1)
    			str += ",";
    	}
    	return str;
    	
    }
    
    public static String removeCommas(String s) {
    	
    	String out = "";
    	int l = s.length();
    	for (int i = 0; i < l; i++) {
    		if (!s.substring(i,i+1).equals(","))
    			out += s.substring(i,i+1);
    	}
    	return out;
    	
    }
    
    public static String addToString(Node n) {
    	
    	if (n.left == null) {
    		if (n.right == null) {
    			return ""+n.key+",";
    		} else {
    			return ""+n.key+","+addToString(n.right)+",";
    		}
    	} else {
    		if (n.right == null) {
    			return ""+addToString(n.left)+","+n.key+",";
    		} else {
    			return ""+addToString(n.left)+","+n.key+","+addToString(n.right)+",";
    		}
    	}
    	
    }
    
    public void insert(int n) {
    	this.nodes++;
    	boolean flag = false;
		Node d = this.root;
		int curDepth = 0;
		while (!flag) {
			curDepth++;
			if (n < d.key) {
				if (d.left == null) {
					d.left = new Node(n);
					flag = true;
				} else {
					d = d.left;
				}
			} else {
				if (d.right == null) {
					d.right = new Node(n);
					flag = true;
				} else {
					d = d.right;
				}
			}
		}
		if (curDepth > this.depth)
			this.depth = curDepth;
    }
    
    public int get(String in) {
    	Node o = this.root;
    	int l = in.length();
    	for (int i = 0; i < l; i++) {
    		if (in.substring(i, i+1).equals("0"))
    			o = o.left;
    		else
    			o = o.right;
    	}
    	return o.key;
    }
    
    public static BinaryTree genBTreeFromArray(int[] z) {
		
		BinaryTree b = new BinaryTree(z[0]);
		
		for (int i = 1; i < z.length; i++) {
			
			int n = z[i];
			b.insert(n);
		}
		
		return b;
		
	}
    
    public int[] getArray() {
    	ArrayList<Integer> temp = getList(root);
    	int s = temp.size();
    	int[] out = new int[s];
    	for (int i = 0; i < s; i++)
    		out[i] = temp.get(i);
    	return out;
    }
    
    public ArrayList<Integer> getList(Node n) {
    	ArrayList<Integer> out = new ArrayList<Integer>();
    	
    	if (n.left == null) {
    		if (n.right == null) {
    			out.add(n.key);
    		} else {
    			out.add(n.key);
    			out.addAll(getList(n.right));
    		}
    	} else {
    		if (n.right == null) {
    			out.addAll(getList(n.left));
    			out.add(n.key);
    		} else {
    			out.addAll(getList(n.left));
    			out.add(n.key);
    			out.addAll(getList(n.right));
    		}
    	}
    	    	
    	return out;
    }
    
    public Node getLeft() {
    	Node out = root;
    	while (out.left != null)
    		out = out.left;
    	return out;
    }
        
    public static ArrayList<Integer> sort(int[] in) {
    	BinaryTree bT = genBTreeFromArray(in);
    	return bT.getList(bT.root);
	}
    
    // 6.2128856347 times slower than Arrays.sort() on random
    
    // 4.77804375 times slower than Radix sort on partially sorted
    
}

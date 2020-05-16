package Experiment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ExperimentEleven {
	private static final int[] arr = {5,5,10,10,10,15,20,25};
	private static final com c = new com();
	public static void main(String[] args) {
		ArrayList<Node> list =  new ArrayList<Node>();
		for (int i = 0; i < arr.length; i++) {
			Node a = new Node();
			a.setValue(arr[i]);
			list.add(a);
		}
		Node a =Huffman(list);
	}
	
	public static Node Huffman(ArrayList<Node> list) {
		if(list.size() == 1) {
			return list.get(0);
		}
			Node a = list.remove(0);
			Node b = list.remove(0);
			Node parent = new Node();
			a.setCode("0");
			parent.setLeft(a);
			b.setCode("1");
			parent.setRight(b);
			parent.setValue(a.getValue()+b.getValue());
			list.add(parent);
			Collections.sort(list, c);
			return Huffman(list);
	}
}
class com implements Comparator<Node>{
	@Override
	public int compare(Node o1, Node o2) {
		// TODO Auto-generated method stub
		return o1.getValue()-o2.getValue();
	}
}

//¶þ²æÊ÷
class Node{
	private Node left;
	private Node right;
	private int value;
	private String code = "";
	private Boolean isCode = false;
	public Node() {
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setLeft(Node left) {
		this.left = left;
	}
	
	public Node getLeft() {
		return this.left;
	}
	
	public void setRight(Node right) {
		this.right = right;
	}
	
	public Node getRight() {
		return this.right;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Boolean getIsCode() {
		return isCode;
	}

	public void setIsCode(Boolean isCode) {
		this.isCode = isCode;
	}
}
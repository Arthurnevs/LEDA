package adt.avltree;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AVLTreeImpl<Integer> t = new AVLTreeImpl<>();
		t.insert(-10);
		t.insert(12);
		System.out.println(t.size());
		
		AVLTreeVerifierImpl<Integer> r = new AVLTreeVerifierImpl<>(t);
		t.remove(-10);
		t.remove(12);
		System.out.println(t.size());
		
		System.out.println(r.isAVLTree());
		System.out.println(r.isBST());

	}

}

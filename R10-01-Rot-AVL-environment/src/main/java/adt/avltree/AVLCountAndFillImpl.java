package adt.avltree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import adt.bst.BSTNode;
import adt.bt.Util;

public class AVLCountAndFillImpl<T extends Comparable<T>> extends
		AVLTreeImpl<T> implements AVLCountAndFill<T> {

	private int LLcounter;
	private int LRcounter;
	private int RRcounter;
	private int RLcounter;

	public AVLCountAndFillImpl() {
		
	}

	@Override
	public int LLcount() {
		return LLcounter;
	}

	@Override
	public int LRcount() {
		return LRcounter;
	}

	@Override
	public int RRcount() {
		return RRcounter;
	}

	@Override
	public int RLcount() {
		return RLcounter;
	}

	@Override
	public void fillWithoutRebalance(T[] array) {
		List<T[]> lista = new ArrayList<T[]>();
		Arrays.sort(array);
		lista.add(array);
		
		for(int i = 0; i < lista.size(); i++) {
			T[] aux = lista.get(i);
			int meio = aux.length / 2;
			T[] aux2 = Arrays.copyOfRange(aux, 0, meio);
			T[] aux3 = Arrays.copyOfRange(aux, meio+1, aux.length);
			if(aux.length > 1) {
				lista.add(aux2);
				lista.add(aux3);
			}
			insert(aux[meio]);
		}
		
	}
	protected void rebalance(BSTNode<T> node) {
		// TODO Auto-generated method stub
		int balance = super.calculateBalance(node);
		
		if(balance > 1) {
			BSTNode<T> aux;
			if(calculateBalance((BSTNode<T>) node.getLeft()) > 0) {
				aux = Util.rightRotation(node);
				this.LLcounter++;
			}else {
				Util.leftRotation((BSTNode<T>) node.getLeft());
				aux = Util.rightRotation(node);
				this.LRcounter++;
			}
			if(aux.getParent() == null) {
				super.root = aux;
			}
		}else if(balance < -1) {
			BSTNode<T> aux;
			if(calculateBalance((BSTNode<T>) node.getRight()) < 0) {
				aux = Util.leftRotation(node);
				this.RRcounter++;
			}else {
				Util.rightRotation((BSTNode<T>) node.getRight());
				aux = Util.leftRotation(node);
				this.RLcounter++;	
			}
			if(aux.getParent() == null) {
				super.root = aux;
			}
		}
	}

}

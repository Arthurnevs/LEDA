package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Note que esta classe estende sua implementacao de BST (BSTImpl).
 * Dependendo do design que voce use, sua BSTImpl precisa ter apenas funcionando
 * corretamente o metodo insert para que voce consiga testar esta classe.
 */
public class FloorCeilBSTImpl extends BSTImpl<Integer> implements FloorCeilBST {

	@Override
	public Integer floor(Integer[] array, double numero) {
		
		for(int i = 0; i < array.length; i++) {
			this.insert(array[i]);
		}
		
		return floorRec(this.root, numero);
	}
	
	int floor = Integer.MIN_VALUE;
	public Integer floorRec(BSTNode<Integer> b,double numero) {
		if(b.getLeft() != null || b.getRight() != null) {
			if(b.getData() == numero) {
				floor = b.getData();
			}
			else if(b.getData() < numero && b.getData() > floor) {
				floor = b.getData();
			}
			if(b.getData() > numero) {
				floorRec((BSTNode<Integer>) b.getLeft(), numero);
			}else{
				floorRec((BSTNode<Integer>) b.getRight(),numero);
			}

		}
		if(floor == Integer.MIN_VALUE) {
			return null;
		}
		return floor;
		
	}

	@Override
	public Integer ceil(Integer[] array, double numero) {
		//TODO Implemente seu codigo aqui
		throw new UnsupportedOperationException("Not implemented yet!");
	}

}

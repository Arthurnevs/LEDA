package adt.avltree;

import adt.bst.BSTNode;
import adt.bst.BSTVerifierImpl;

/**
 * Performs consistency validations within a AVL Tree instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class AVLTreeVerifierImpl<T extends Comparable<T>> extends BSTVerifierImpl<T> implements AVLTreeVerifier<T> {

	private AVLTreeImpl<T> avlTree;

	public AVLTreeVerifierImpl(AVLTree<T> avlTree) {
		super(avlTree);
		this.avlTree = (AVLTreeImpl<T>) avlTree;
	}

	private AVLTreeImpl<T> getAVLTree() {
		return avlTree;
	}

	@Override
	public boolean isAVLTree() {
		if(!avlTree.isEmpty()) {
			if(isBST() && isAVLTreeRec(avlTree.getRoot())) {
				return true;
			}else {
				return false;
			}
		}
		return true;

	}

	private boolean isAVLTreeRec(BSTNode<T> node) {
		// TODO Auto-generated method stub
		boolean r = true;
		boolean l = true;
		
		if(node.isEmpty()) {
			int balance = this.avlTree.calculateBalance(node);
			
			if(balance > 1 || balance < -1) {
				r = false;
				l = false;
			}else {
				r = isAVLTreeRec((BSTNode<T>) node.getRight());
				l = isAVLTreeRec((BSTNode<T>) node.getLeft());
			}
		}
		
		if(l && r) {
			return true;
		}
		return false;
	}

}

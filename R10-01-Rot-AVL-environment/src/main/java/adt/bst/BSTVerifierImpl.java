package adt.bst;

/**
 * 
 * Performs consistency validations within a BST instance
 * 
 * @author Claudio Campelo
 *
 * @param <T>
 */
public class BSTVerifierImpl<T extends Comparable<T>> implements BSTVerifier<T> {
	
	private BSTImpl<T> bst;

	public BSTVerifierImpl(BST<T> bst) {
		this.bst = (BSTImpl<T>) bst;
	}
	
	private BSTImpl<T> getBSt() {
		return bst;
	}

	@Override
	public boolean isBST() {
		if(bst == null) {
			return false;
		}
		return isBST(bst.getRoot());
	}

	private boolean isBST(BSTNode<T> node) {
		// TODO Auto-generated method stub
		if(!node.isEmpty()) {
			if(!node.getLeft().isEmpty()) {
				if(node.getLeft().getData().compareTo(node.getData()) < 0) {
					return isBST((BSTNode<T>) node.getLeft());
				}else {
					return false;
				}
			}
		}else if(!node.getRight().isEmpty()){
			if (node.getRight().getData().compareTo(node.getData()) > 0) {
				return isBST((BSTNode<T>) node.getRight());
			} else {
				return false;
			}
		}
		return true;
	}
	
}

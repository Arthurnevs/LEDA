package adt.bst;

import java.util.ArrayList;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return height(this.root);
	}

	private int height(BSTNode<T> node) {
		// Considera 1 pelo root
		int altura = 1;
		// Se o root for vazio retorna -1
		if(node.isEmpty()) {
			return -1;
		}else {
			int l = height((BSTNode<T>) node.getLeft());
			int r = height((BSTNode<T>) node.getRight());
			
			if(l < r) {
				altura = altura + r;
			}else {
				altura = altura + l;
			}
		}
		return altura;
	}

	@Override
	public BSTNode<T> search(T element) {
		return search(this.root, element);
	}

	private BSTNode<T> search(BSTNode<T> node, T element) {
		
		BSTNode<T> resultado = new BSTNode<T>();

		if(!node.isEmpty()) {
			if(element.compareTo(node.getData())>0) {
				resultado = search((BSTNode<T>) node.getRight(), element);
			}else if(element.compareTo(node.getData())< 0) {
				resultado = search((BSTNode<T>) node.getLeft(),element);
			}else {
				resultado = node;
			}
		}
		return resultado;
	}

	@Override
	public void insert(T element) {
		insert(element,this.root);

	}

	private void insert(T element, BSTNode<T> node) {
		// TODO Auto-generated method stub
		if(node.isEmpty()) {
			node.setData(element);
			node.setRight(new BSTNode<T>());
			node.setLeft(new BSTNode<T>());
			node.getRight().setParent(node);
			node.getLeft().setParent(node);
		}else if(element.compareTo(node.getData())>0) {
			insert(element, (BSTNode<T>) node.getRight());
		}else {
			insert(element, (BSTNode<T>) node.getLeft());
		}
	}

	@Override
	public BSTNode<T> maximum() {
		return maximum(this.root);
	}

	private BSTNode<T> maximum(BSTNode<T> node) {
		// TODO Auto-generated method stub
		if(this.isEmpty()) {
			return null;
		}
		else if(node.getRight().isEmpty()) {
			return node;
		}else {
			return maximum((BSTNode<T>) node.getRight());
		}
	}

	@Override
	public BSTNode<T> minimum() {
		return minimum(this.root);
	}

	private BSTNode<T> minimum(BSTNode<T> node) {
		// TODO Auto-generated method stub
		if(this.isEmpty()) {
			return null;
		}else if(node.getLeft().isEmpty()) {
			return node;
		}else {
			return minimum((BSTNode<T>) node.getLeft());
		}
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = this.search(element);
		
		if(node.isEmpty()) {
			return null;
		}else if(!node.getRight().isEmpty()) {
			return this.minimum((BSTNode<T>) node.getRight());
		}else {
			BSTNode<T> resultado = (BSTNode<T>) node.getParent();
			
			while(resultado != null && node.equals(resultado.getRight())) {
				node = resultado;
				resultado = (BSTNode<T>) node.getParent();
			}
			
			return resultado;
		}
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		// TODO Auto-generated method stub
		BSTNode<T> node = this.search(element);
		if(node.isEmpty()) {
			return null;
		}else if(!node.getLeft().isEmpty()) {
			return this.minimum((BSTNode<T>) node.getLeft());
		}else {
			BSTNode<T> resultado = (BSTNode<T>) node.getParent();
			
			while(resultado != null && node.equals(resultado.getLeft())) {
				node = resultado;
				resultado = (BSTNode<T>) node.getParent();
			}
			return resultado;
		}
	}

	@Override
	public void remove(T element) {
		
	    if (element == null) {
	    	return;
		}
		
		BSTNode<T> node = search(element);
		
		if(node.isEmpty()) {
			return;
		}
		
		int qtdFilhos = qtdFilhos(node);
		
		if(qtdFilhos == 0) {
			removeNodeFolha(node);
		}else if(qtdFilhos == 1) {
			removeNodeUmFilho(node);
		}else if(qtdFilhos == 2){
			removeNodeDoisFilhos(node);
		}
	}
	
	private void removeNodeFolha(BSTNode<T> node) {
		node.setData(null);

	}
	
	private void removeNodeUmFilho(BSTNode<T> node) {
		
		if(node.getParent() == null) {
			if(!node.getLeft().isEmpty()) {
				node.getLeft().setParent(null);
				this.root = (BSTNode<T>)node.getLeft	();
				return;
			}else if(!node.getRight().isEmpty()) {
				node.getRight().setParent(null);
				this.root = (BSTNode<T>) node.getRight();
				return;
			}
		}else {
			
			BSTNode<T> aux = null;
			
			if(!node.getRight().isEmpty()) {
				aux =	(BSTNode<T>) node.getRight();
			}else {
				aux = (BSTNode<T>) node.getLeft();
			}
			
			aux.setParent(node.getParent());
			
			if(node.equals(aux.getParent().getRight())) {
				node.getParent().setRight(aux);
			}else if(node.equals(aux.getParent().getLeft())) {
				node.getParent().setLeft(aux);
			}
			
		}
	}
	
	private void removeNodeDoisFilhos(BSTNode<T> node) {
		BSTNode<T> sucessor = sucessor(node.getData());
		
		if(sucessor == null) {
			return;
		}
		node.setData(sucessor.getData());
		
		int qtdFilhos = qtdFilhos(sucessor);
		
		if(qtdFilhos == 0) {
			removeNodeFolha(sucessor);
		}else if(qtdFilhos == 1) {
			removeNodeUmFilho(sucessor);
		}else {
			removeNodeDoisFilhos(sucessor);
		}
		
	}
	
	private int qtdFilhos(BSTNode<T> node) {
		int retorno = 0;
		
		if(!node.getRight().isEmpty()) {
			retorno++;
		}
		if(!node.getLeft().isEmpty()) {
			retorno++;
		}
		return retorno;
	}

	@Override
	public T[] preOrder() {
		ArrayList<T> array = new ArrayList<T>();
		preOrder(array, this.root);
		
		int size = array.size();
		T[] result = (T[]) new Comparable[size];
		
		for(int i = 0; i < size; i++) {
			result[i] = array.get(i);
		}
		
		return result;
		}

	private void preOrder(ArrayList<T> array, BSTNode<T> node) {

		if(node.isEmpty()) {
			return;
		}	
		array.add(node.getData());
		preOrder(array,(BSTNode<T>) node.getLeft());
		preOrder(array,(BSTNode<T>) node.getRight());

		
	}
	@Override
	public T[] order() {
		ArrayList<T> array = new ArrayList<T>();
	    
	    order(this.getRoot(), array);

	    int size = array.size();
	    
	    T[] result = (T[]) new Comparable[size];
	    
	    for(int i = 0; i < size; i++) {
	    	result[i] = array.get(i);
	    }
	    
	    return result;
	    
	}
	
	
	private void order(BSTNode<T> node, ArrayList<T> array) {
	    if(node.isEmpty()) {
	    	return;
	    }
	    order((BSTNode<T>) node.getLeft(),array);
	    array.add(node.getData());
	    order((BSTNode<T>)node.getRight(),array);
	    	    
	   }

	@Override
	public T[] postOrder() {
		ArrayList<T> array = new ArrayList<T>();
	    
	    postOrder(this.root, array);

	    int size = array.size();
	    
	    T[] result = (T[]) new Comparable[size];
	    
	    for(int i = 0; i < size; i++) {
	    	result[i] = array.get(i);
	    }
	    
	    return result;
	}

	private void postOrder(BSTNode<T> node, ArrayList<T> array) {
		if(node.isEmpty()) {
			return;
		}
		postOrder((BSTNode<T>) node.getLeft(), array);
		postOrder((BSTNode<T>) node.getRight(), array);
		array.add(node.getData());

	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}

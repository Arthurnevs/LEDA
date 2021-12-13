package adt.bt;

import org.junit.runners.ParentRunner;

import adt.bst.BSTNode;

public class Util {


	/**
	 * A rotacao a esquerda em node deve subir e retornar seu filho a direita
	 * @param node
	 * @return - noh que se tornou a nova raiz
	 */
	public static <T extends Comparable<T>> BSTNode<T> leftRotation(BSTNode<T> node) {
		BSTNode<T> pivo = (BSTNode<T>) node.getRight();
		BSTNode<T> left = (BSTNode<T>) pivo.getLeft();
		BSTNode<T> parent = (BSTNode<T>) node.getParent();
		
		if(parent != null) {
			if(parent.getLeft().equals(node)) {
				parent.setLeft(pivo);
			}else {
				parent.setRight(pivo);
			}
		}
		
		pivo.setParent(parent);
		node.setParent(pivo);
		
		node.setRight(left);
		pivo.setLeft(node);
		
		if(left != null) {
			left.setParent(node);
		}
		return pivo;
	}

	/**
	 * A rotacao a direita em node deve subir e retornar seu filho a esquerda
	 * @param node
	 * @return noh que se tornou a nova raiz
	 */
	public static <T extends Comparable<T>> BSTNode<T> rightRotation(BSTNode<T> node) {
		BSTNode<T> pivo = (BSTNode<T>) node.getLeft();
		BSTNode<T> right = (BSTNode<T>) pivo.getRight();
		BSTNode<T> parent = (BSTNode<T>) node.getParent();
		
		if(parent != null) {
			if(parent.getLeft().equals(node)) {
				parent.setLeft(pivo);
			}else {
				parent.setRight(pivo);
			}
		}
		pivo.setParent(parent);
		node.setParent(pivo);
		
		node.setLeft(right);
		pivo.setRight(node);
		
		if(right != null) {
			right.setParent(node);
		}
		return pivo;
		
	}

	public static <T extends Comparable<T>> T[] makeArrayOfComparable(int size) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size];
		return array;
	}
}

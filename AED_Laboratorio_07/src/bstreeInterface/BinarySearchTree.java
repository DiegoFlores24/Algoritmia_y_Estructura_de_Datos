package bstreeInterface;
import Exceptions.ExceptionIsEmpty;
import Exceptions.ItemNotFound;
import Exceptions.ItemDuplicated;

public interface BinarySearchTree<E> {
	void insert(E data) throws ItemDuplicated;
	E search(E data)throws ItemNotFound;
	void delete(E data)throws ExceptionIsEmpty;
	boolean isEmpty();
}


/*
 * Student information for assignment:
 * On my honor, Ayush Patel, this programming assignment is my own work
 * and I have not provided this code to any other student.
 * UTEID: ap55837
 * email address: patayush01@utexas.edu
 * TA name: Tony
 * Number of slip days I am using: 1
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements IList<E> {
	private DoubleListNode<E> first;
	private DoubleListNode<E> last;
	private int size;

	/**
	 * add item to the front of the list. <br>
	 * pre: item != null <br>
	 * post: size() = old size() + 1, get(0) = item
	 *
	 * @param item the data to add to the front of this list 
	 * This method is O(1)
	 */
	public void addFirst(E item) {
		if (item == null)
			throw new IllegalArgumentException("item cannot be null");
		DoubleListNode<E> newFirst = new DoubleListNode<E>(null, item, first);
		// if size != 0, then old first's previous needs to be set to new first
		if (size != 0)
			first.setPrev(newFirst);
		// set first to the new first
		first = newFirst;
		size++;
		// if there is no elements before this method is called, then first and
		// last node are same node
		if (size == 1)
			last = first;
	}

	/**
	 * add item to the end of the list. <br>
	 * pre: item != null <br>
	 * post: size() = old size() + 1, get(size() -1) = item
	 *
	 * @param item the data to add to the end of this list 
	 * This method is O(1)
	 */
	public void addLast(E item) {
		if (item == null)
			throw new IllegalArgumentException("item cannot be null");
		DoubleListNode<E> newLast = new DoubleListNode<E>(last, item, null);
		// if size != 0, then old last next needs to be set to new last
		if (size != 0)
			last.setNext(newLast);
		// last is set to newLast
		last = newLast;
		size++;
		// if there is no elements before this method is called, then first
		// and last node are same node
		if (size == 1)
			first = last;
	}

	/**
	 * remove and return the first element of this list. <br>
	 * pre: size() > 0 <br>
	 * post: size() = old size() - 1
	 *
	 * @return the old first element of this list 
	 * This method is O(1)
	 */
	public E removeFirst() {
		if (size <= 0)
			throw new IllegalArgumentException("no elements in list");
		// using remove method, passing in first index
		return remove(0);

	}

	/**
	 * remove and return the last element of this list. <br>
	 * pre: size() > 0 <br>
	 * post: size() = old size() - 1
	 *
	 * @return the old last element of this list 
	 * This method is O(1)
	 */
	public E removeLast() {
		if (size <= 0)
			throw new IllegalArgumentException("no elements in list");
		// using remove method, passing in last index
		return remove(size - 1);

	}

	/**
	 * Add an item to the end of this list. <br>
	 * pre: item != null <br>
	 * post: size() = old size() + 1, get(size() - 1) = item
	 * 
	 * @param item the data to be added to the end of this list, item != null
	 * This method is O(1)
	 */
	@Override
	public void add(E item) {
		// precons checked in addLast
		// calls addLast method, which does same thing as add method,
		addLast(item);

	}

	/**
	 * Insert an item at a specified position in the list. <br>
	 * pre: 0 <= pos <= size(), item != null <br>
	 * post: size() = old size() + 1, get(pos) = item, all elements in the list
	 * with a positon >= pos have a position = old position + 1
	 * 
	 * @param pos  the position to insert the data at in the list
	 * @param item the data to add to the list, item != null 
	 * Average case O(N)
	 */
	@Override
	public void insert(int pos, E item) {
		if (pos > size || pos < 0 || item == null)
			throw new IllegalArgumentException("index out of bounds");
		// if inserting to end, same as addLast
		if (pos == size)
			addLast(item);
		// if inserting to front, same as addFirst
		else if (pos == 0)
			addFirst(item);
		// if neither of previous, then inserting to middle
		else {
			DoubleListNode<E> nodeAtPos = getNodeAtPos(pos);
			// creating newNode with previous set to nodeAtPos's previous and
			// its next set to nodeAtPos
			DoubleListNode<E> newNode = new DoubleListNode<E>(
					nodeAtPos.getPrev(), item, nodeAtPos);
			// set next of node before inserted node to the inserted node
			newNode.getPrev().setNext(newNode);
			// set previous of node after inserted node to inserted node
			newNode.getNext().setPrev(newNode);
			size++;
		}

	}

	/**
	 * Change the data at the specified position in the list. the old data at
	 * that position is returned. <br>
	 * pre: 0 <= pos < size(), item != null <br>
	 * post: get(pos) = item, return the old get(pos)
	 * 
	 * @param pos  the position in the list to overwrite
	 * @param item the new item that will overwrite the old item, item != null
	 * @return the old data at the specified position 
	 * Average case O(N)
	 */

	@Override
	public E set(int pos, E item) {
		if (pos < 0 || pos >= size || item == null)
			throw new IllegalArgumentException(
					"pos is out of bounds or item is null");
		DoubleListNode<E> node = getNodeAtPos(pos);
		// storing previous data of node
		E prevData = node.getData();
		// using setData method of DoubleListNode to update data of node
		node.setData(item);
		return prevData;
	}

	/**
	 * Get an element from the list. <br>
	 * pre: 0 <= pos < size() <br>
	 * post: return the item at pos
	 * 
	 * @param pos specifies which element to get
	 * @return the element at the specified position in the list 
	 * Average case O(N)
	 */
	@Override
	public E get(int pos) {
		if (pos < 0 || pos >= size)
			throw new IllegalArgumentException("pos is out of bounds");
		// calling getNodeAtPos and getData to return element of node at pos
		return getNodeAtPos(pos).getData();
	}

	/**
	 * Remove an element in the list based on position. <br>
	 * pre: 0 <= pos < size() <br>
	 * post: size() = old size() - 1, all elements of list with a position > pos
	 * have a position = old position - 1
	 * 
	 * @param pos the position of the element to remove from the list
	 * @return the data at position pos 
	 * Average case O(N)
	 */
	@Override
	public E remove(int pos) {
		if (pos < 0 || pos >= size)
			throw new IllegalArgumentException("pos is out of bounds");
		// storing node needed to be removed
		// NOTE, not losing effiency if pos == 0 or size -1 because getNodeAtPos
		// accounts for those cases
		DoubleListNode<E> nodeStart = getNodeAtPos(pos);
		// storing data of that node to return after removal
		E data = nodeStart.getData();
		// using removeLogic method, passing in next node because that is node
		// at pos + 1 (node that replaces node at pos)
		removeLogic(nodeStart, nodeStart.getNext(), pos, pos + 1);
		return data;
	}

	// pre: none
	// post: repoints nodes to remove nodes between start and end, inclusive of
	// start and exclusive of end
	// This method is O(1)
	private void removeLogic(DoubleListNode<E> nodeStart,
			DoubleListNode<E> nodeEnd, int start, int end) {
		// We need to store previous of start because node at start is being
		// removed (doesn't matter if previous of start is null because wont add
		// use nodeStart when start==0)
		nodeStart = nodeStart.getPrev();
		// if removing all elements in list, reset first and last (not using
		// makeEmpty() because size is changed in this method)
		if (size == end - start)
			reset();
		// when changing first node in list
		else if (start == 0) {
			// removing from front, so first is set to first node that is
			// not removed in list, and set new first's previous to null
			// because nothing before this node
			first = nodeEnd;
			first.setPrev(null);
		} else if (end == size) {
			// removing from end, so last is set to node right before node
			// at start, new last is set to null because nothing after this
			// node
			last = nodeStart;
			last.setNext(null);

		} else {
			// else removing from middle, so set node before start's next to
			// first node NOT removed (nodeEnd), and set nodeEnd's previous
			// to node before start
			nodeStart.setNext(nodeEnd);
			nodeEnd.setPrev(nodeStart);
		}
		size -= end - start;
	}

	/**
	 * Remove the first occurrence of obj in this list. Return <tt>true</tt> if
	 * this list changed as a result of this call, <tt>false</tt> otherwise.
	 * <br>
	 * pre: obj != null <br>
	 * post: if obj is in this list the first occurrence has been removed and
	 * size() = old size() - 1. If obj is not present the list is not altered in
	 * any way.
	 * 
	 * @param obj The item to remove from this list. obj != null
	 * @return Return <tt>true</tt> if this list changed as a result of this
	 *         call, <tt>false</tt> otherwise. 
	 * Average case O(N)
	 */
	@Override
	public boolean remove(E obj) {
		if (obj == null)
			throw new IllegalArgumentException("passed in a null");
		Iterator<E> iter = this.iterator();
		// iterating through LinkedList
		while (iter.hasNext())
			// if element of node equals obj, remove that node and return true
			if (iter.next().equals(obj)) {
				iter.remove();
				return true;
			}
		//obj not found, return false
		return false;
	}

	/**
	 * Return a sublist of elements in this list from <tt>start</tt> inclusive
	 * to <tt>stop</tt> exclusive. This list is not changed as a result of this
	 * call. <br>
	 * pre: <tt>0 <= start <= size(), start <= stop <= size()</tt> <br>
	 * post: return a list whose size is stop - start and contains the elements
	 * at positions start through stop - 1 in this list.
	 * 
	 * @param start index of the first element of the sublist.
	 * @param stop  stop - 1 is the index of the last element of the sublist.
	 * @return a list with <tt>stop - start</tt> elements, The elements are from
	 *         positions <tt>start</tt> inclusive to <tt>stop</tt> exclusive in
	 *         this list. If start == stop an empty list is returned. 
	 * Average case O(N)
	 */
	@Override
	public IList<E> getSubList(int start, int stop) {
		if (start < 0 || start > stop || stop > size)
			throw new IllegalArgumentException("index out of bounds");
		IList<E> subList = new LinkedList<>();
		// get the first node whose data needs to be added
		DoubleListNode<E> nodeToBeAdded = getNodeAtPos(start);
		while (start < stop) {
			// add the node data to subList and get the get next node
			subList.add(nodeToBeAdded.getData());
			// move to next node after previous node's data has been added to
			// sublist
			nodeToBeAdded = nodeToBeAdded.getNext();
			start++;
		}

		return subList;
	}

	/**
	 * Return the size of this list. In other words the number of elements in
	 * this list. <br>
	 * pre: none <br>
	 * post: return the number of items in this list
	 * 
	 * @return the number of items in this list 
	 * This method is O(1)
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Find the position of an element in the list. <br>
	 * pre: item != null <br>
	 * post: return the index of the first element equal to item or -1 if item
	 * is not present
	 * 
	 * @param item the element to search for in the list. item != null
	 * @return return the index of the first element equal to item or a -1 if
	 *         item is not present 
	 * Average case O(N)
	 */
	@Override
	public int indexOf(E item) {
		// if there is no elements, item cannot be present so return -1
		if (size <= 0)
			return -1;
		// else use indexOf method already written by passing in 0 (starting
		// pos)
		return indexOf(item, 0);
	}

	/**
	 * find the position of an element in the list starting at a specified
	 * position. <br>
	 * pre: 0 <= pos < size(), item != null <br>
	 * post: return the index of the first element equal to item starting at pos
	 * or -1 if item is not present from position pos onward
	 * 
	 * @param item the element to search for in the list. Item != null
	 * @param pos  the position in the list to start searching from
	 * @return starting from the specified position return the index of the
	 *         first element equal to item or a -1 if item is not present
	 *         between pos and the end of the list 
	 * Average case O(N)
	 */
	@Override
	public int indexOf(E item, int pos) {
		if (pos < 0 || pos >= size || item == null)
			throw new IllegalArgumentException(
					"pos is out of bounds or item is null");
		// staring with node at pos
		DoubleListNode<E> checkThisNode = getNodeAtPos(pos);
		// traversing list until we get to end of it
		while (pos < size) {
			// if find item in list, return that pos
			if (checkThisNode.getData().equals(item))
				return pos;
			// else, go to next node
			checkThisNode = checkThisNode.getNext();
			pos++;
		}
		// if item not found, returning -1;
		return -1;
	}

	/**
	 * return the list to an empty state. <br>
	 * pre: none <br>
	 * post: size() = 0 
	 * This method is O(1)
	 */
	@Override
	public void makeEmpty() {
		// setting size to 0, calling reset method
		size = 0;
		reset();
	}

	// pre: none
	// post: first and last set to null (empty list)
	// This method is O(1)
	private void reset() {
		// Instead of putting this in makeEmpty(), putting this in separate
		// method so removeLogic method can call it without resetting size
		// (easier logic if removeLogic modifies size itself and uses this
		// method over makeEmpty() doing it all)
		last = null;
		first = null;
	}

	/**
	 * return an Iterator for this list. <br>
	 * pre: none <br>
	 * post: return an Iterator object for this List 
	 * This method is O(1)
	 */
	public Iterator<E> iterator() {
		return new LLIterator();
	}

	/**
	 * Remove all elements in this list from <tt>start</tt> inclusive to
	 * <tt>stop</tt> exclusive. <br>
	 * pre: <tt>0 <= start <= size(), start <= stop <= size()</tt> <br>
	 * post: <tt>size() = old size() - (stop - start)</tt>
	 * 
	 * @param start position at beginning of range of elements to be removed
	 * @param stop  stop - 1 is the position at the end of the range of elements
	 *              to be removed 
	 * Average case O(N)
	 */
	@Override
	public void removeRange(int start, int stop) {
		if (start > stop || start < 0 || stop > size)
			throw new IllegalArgumentException("index out of bounds");
		if (start < stop) {
			DoubleListNode<E> nodeBeforeEnd = getNodeAtPos(start);
			DoubleListNode<E> nodeEnd = getNodeAtPos(stop);
			removeLogic(nodeBeforeEnd, nodeEnd, start, stop);
		}
	}

	/**
	 * Return a String version of this list enclosed in square brackets, [].
	 * Elements are in are in order based on position in the list with the first
	 * element first. Adjacent elements are separated by comma's
	 * 
	 * @return a String representation of this IList 
	 * Average case O(N)
	 */

	public String toString() {
		StringBuilder output = new StringBuilder();
		Iterator<E> iter1 = this.iterator();
		output.append("[");
		// used to not add comma space in front of first element
		boolean isFirst = true;
		// while there are elements left in list
		while (iter1.hasNext()) {
			// ensures there's no comma space in front of first element (adding
			// comma at beginning of loop to not put comma space after last
			// element)
			if (!isFirst)
				output.append(", ");
			else
				isFirst = false;
			output.append(iter1.next());

		}
		output.append("]");
		return output.toString();
	}

	/**
	 * Determine if this IList is equal to other. Two ILists are equal if they
	 * contain the same elements in the same order.
	 * 
	 * @return true if this IList is equal to other, false otherwise 
	 * Average case O(N)
	 */
	public boolean equals(Object other) {
		// checking to see if other is a LinkedList
		if (other instanceof IList) {
			Iterator<E> iter1 = this.iterator();
			// casting to IList<?> after checking using if
			Iterator<?> iter2 = ((IList<?>) other).iterator();
			// if sizes not equal, return false
			if (this.size != ((IList<?>) other).size())
				return false;
			// while both still have elements
			while (iter1.hasNext() && iter2.hasNext()) {
				// if elements are not equal, return false
				if (!iter1.next().equals(iter2.next()))
					return false;
			}
			// if no different elements & same size, return true
			return true;

		}
		// if other is not instanceof IList, return false
		return false;

	}

	// pre: none
	// post: return DoubleListNode<E> that is at int pos
	// This method is O(N)
	private DoubleListNode<E> getNodeAtPos(int pos) {
		// if pos is last index, return last (rather than traversing entire list
		// to get to last)
		if (pos == size - 1)
			return last;
		DoubleListNode<E> node = first;
		// traverse through list (doing i < pos rather than i <= pos because
		// node is already set to first)
		for (int i = 0; i < pos; i++) {
			node = node.getNext();
		}
		return node;
	}

	private class LLIterator implements Iterator<E> {
		private DoubleListNode<E> nodeWithNextData;
		private boolean removeOk;
		private int indexToRemove;

		public LLIterator() {
			// setting nodeWithNextData to first node in linkedList, and
			// indexToRemove as 1 before index of first (-1)
			nodeWithNextData = first;
			indexToRemove = -1;
		}

		// pre: none
		// post: if nodeWithNextData != null, then there is a next node in list,
		// so returns true. returns false otherwise
		// this method is O(1)
		public boolean hasNext() {
			return nodeWithNextData != null;
		}

		// pre: hasNext = true (there is a next node in list)
		// post: returns data of nodeWithNextData, and then move
		// nodeWithNextData to next node in list
		// This method is O(1)
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			// storing data of next node
			E nextData = nodeWithNextData.getData();
			// set nodeWithNextData to next node in structure
			nodeWithNextData = nodeWithNextData.getNext();
			// element can be removed now, so set removeOk = true
			removeOk = true;
			// add to indexToRemove because on next node now
			indexToRemove++;
			return nextData;
		}

		// pre: removeOk is true(next() has been called before this method is
		// called)
		// post: removes node at the indexToRemove, moves indexToRemove back one
		// to account for removed
		// node, and set removeOk back to false (need to call next() again to
		// use remove())
		// this method is O(1)
		public void remove() {
			if (!removeOk) {
				throw new IllegalStateException();
			}
			// utilizing removeLogic method from LinkedList class to make it O(1)
			if(indexToRemove== size - 1)
				LinkedList.this.removeLogic(last,  last.getNext(), indexToRemove, indexToRemove + 1);
			else
			  LinkedList.this.removeLogic(nodeWithNextData.getPrev(), nodeWithNextData, indexToRemove, indexToRemove + 1);
			// reset removeOk value (cannot remove without calling .next()
			// before)
			removeOk = false;
			// go back an index because we have removed an element
			indexToRemove--;
		}

	}

}
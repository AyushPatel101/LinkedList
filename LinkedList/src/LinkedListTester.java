/*  Student information for assignment:

*
*  On my honor, Ayush Patel, this programming assignment is my own work
*  and I have not provided this code to any other student.
*
*  Name: Ayush Patel
*  email address: patayush01@utexas.edu
*  UTEID: ap55837
*  TA name: Tony 
*  Number of slip days used on this assignment: 1 
*/

// Faster operation between ArrayList and LinkedList: 
// Adding to end: About the same
// Adding to front: LinkedList
// Removing from front: LinkedList
// Getting random: ArrayList
// Getting all using iterator: About the same
// Getting all using get method: ArrayList

// Big O of each operation:

// Adding to end:
// ArrayList: O(1) because as N doubles, time ~ doubles, leading to O(N). However, 
// the experiment initialization is O(N), therefore the actual O(N) of the operation is O(N/N)= O(1).
// LinkedList: O(1) because as N doubles, time ~ doubles, leading to O(N). However,
// the experiment initialization is O(N), therefore the actual O(N) of the operation is O(N/N)= O(1).

// Adding to front:
// ArrayList: O(N) because as N doubles, time ~ quadruples, leading to O(N^2). However,
// the experiment initialization is O(N), therefore the actual O(N) of the operation is O(N^2/N)= O(N).
// LinkedList: O(1) because as N doubles, time ~ doubles, leading to O(N). However,
// the experiment initialization is O(N), therefore the actual O(N) of the operation is O(N/N)= O(1).

// Removing from front:
// ArrayList: O(N) because as N doubles, time ~ quadruples, leading to O(N^2). However,
// the experiment initialization is O(N), therefore the actual O(N) of the operation is O(N^2/N)= O(N).
// LinkedList: O(1) because as N doubles, time ~ doubles, leading to O(N). However, 
// the experiment initialization is O(N), therefore the actual O(N) of the operation is O(N/N)= O(1).

// Getting random:
// ArrayList: O(1) because as N doubles, time ~ doubles, leading to O(N). However, 
// the experiment initialization is O(N), therefore the actual O(N) of the operation is O(N/N)= O(1).
// LinkedList: O(N) because as N doubles, time ~ quadruples, leading to O(N^2). However,
// the experiment initialization is O(N), therefore the actual O(N) of the operation is O(N^2/N)= O(N).

// Getting all using iterator:
// ArrayList: O(1) because as N doubles, time ~ doubles, leading to O(N). However,
// the experiment initialization is O(N), therefore the actual O(N) of the operation is O(N/N)= O(1).
// LinkedList: O(1) because as N doubles, time ~ doubles, leading to O(N). However,
// the experiment initialization is O(N), therefore the actual O(N) of the operation is O(N/N)= O(1).

// Getting all using get method:
// ArrayList: O(1) because as N doubles, time ~ doubles, leading to O(N). However,
// the experiment initialization is O(N), therefore the actual O(N) of the operation is O(N/N)= O(1)."
// LinkedList: O(N) because as N doubles, time ~ quadruples, leading to O(N^2). However,
// the experiment initialization is O(N), therefore the actual O(N) of the operation is O(N^2/N)= O(N)."


import java.util.Iterator;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class LinkedListTester {

	public static void main(String[] args) {

		LinkedList<String> list = new LinkedList<>();
		Object[] actual;
		Object[] expected;

		// test 0
		String test = "addFirst: ";
		expected = new String[] { "B", "A" };
		int testNumber = 1;
		list.addFirst("A");
		list.addFirst("B");
		System.out.println(test);
		computeResult(toArray(list), expected, testNumber++);

		// test 1
		expected = new String[] { "A" };
		list = new LinkedList<>();
		list.addFirst("A");
		list.get(0);
		computeResult(toArray(list), expected, testNumber++);

		// test 2
		expected = new String[] { "B", "C", "A" };
		list.addFirst("C");
		list.addFirst("B");
		computeResult(toArray(list), expected, testNumber++);
		System.out.println();
		// test 3
		test = "addLast: ";
		list = new LinkedList<>();
		expected = new String[] { "A", "B" };
		list.addLast("A");
		list.addLast("B");
		System.out.println(test);
		computeResult(toArray(list), expected, testNumber++);

		// test 4
		expected = new String[] { "A", "B", "C" };
		list.addLast("C");
		computeResult(toArray(list), expected, testNumber++);

		// test 5
		expected = new String[] { "A", "B", "C", "C", "D" };
		list.addLast("C");
		list.addLast("D");
		computeResult(toArray(list), expected, testNumber++);
		System.out.println();

		// test 6
		test = "removeFirst: ";
		expected = new String[] { "B", "C", "C", "D" };
		String removed = list.removeFirst();
		System.out.println(test);
		if (removed.contentEquals("A"))
			computeResult(toArray(list), expected, testNumber++);
		else
			System.out.println("Failed test " + testNumber++);

		// test 7
		expected = new String[] { "D" };
		removed = list.removeFirst();
		removed = list.removeFirst();
		removed = list.removeFirst();
		if (removed.contentEquals("C"))
			computeResult(toArray(list), expected, testNumber++);
		else
			System.out.println("Failed test " + testNumber++);

		// test 8
		expected = new String[] {};
		removed = list.removeFirst();
		if (removed.contentEquals("D"))
			computeResult(toArray(list), expected, testNumber++);
		else
			System.out.println("Failed test " + testNumber++);
		System.out.println();

		// test 9
		test = "removeLast: ";
		list.makeEmpty();
		list.addLast("A");
		list.addLast("B");
		list.addLast("C");
		list.addLast("C");
		list.addLast("D");
		System.out.println(test);
		expected = new String[] { "A", "B", "C", "C" };
		removed = list.removeLast();
		if (removed.contentEquals("D"))
			computeResult(toArray(list), expected, testNumber++);
		else
			System.out.println("Failed test " + testNumber++);

		// test 10
		expected = new String[] { "A" };
		removed = list.removeLast();
		removed = list.removeLast();
		removed = list.removeLast();
		if (removed.contentEquals("B"))
			computeResult(toArray(list), expected, testNumber++);
		else
			System.out.println("Failed test " + testNumber++);

		// test 11
		expected = new String[] {};
		removed = list.removeLast();
		if (removed.contentEquals("A"))
			computeResult(toArray(list), expected, testNumber++);
		else
			System.out.println("Failed test " + testNumber++);
		System.out.println();

		// test 12
		test = "add: ";
		list.add("A");
		expected = new String[] { "A" };
		System.out.println(test);
		computeResult(toArray(list), expected, testNumber++);

		// test 13
		list.add("B");
		list.add("C");
		expected = new String[] { "A", "B", "C" };
		computeResult(toArray(list), expected, testNumber++);

		// test 14
		list.add("A");
		list.add("B");
		list.add("C");
		expected = new String[] { "A", "B", "C", "A", "B", "C" };
		computeResult(toArray(list), expected, testNumber++);
		System.out.println();

		// test 15
		test = "insert: ";
		list = new LinkedList<>();
		list.insert(0, "A");
		expected = new String[] { "A" };
		System.out.println(test);
		computeResult(toArray(list), expected, testNumber++);

		// test 16
		list.insert(1, "C");
		expected = new String[] { "A", "C" };
		computeResult(toArray(list), expected, testNumber++);

		// test 17
		list.insert(1, "B");
		list.insert(1, "D");
		expected = new String[] { "A", "D", "B", "C" };
		computeResult(toArray(list), expected, testNumber++);
		System.out.println();

		// test 18
		test = "set: ";
		list.set(1, "B");
		list.set(1, "C");
		System.out.println(test);
		expected = new String[] { "A", "C", "B", "C" };
		computeResult(toArray(list), expected, testNumber++);

		// test 19
		list.set(0, "C");
		list.set(2, "C");
		expected = new String[] { "C", "C", "C", "C" };
		computeResult(toArray(list), expected, testNumber++);

		// test 20
		list.set(3, "D");
		expected = new String[] { "C", "C", "C", "D" };
		computeResult(toArray(list), expected, testNumber++);
		System.out.println();

		// test 21
		test = "get: ";
		System.out.println(test);
		test = list.get(3);
		expected = new String[] { "C", "C", "C", "D" };
		if (test.contentEquals("D"))
			computeResult(toArray(list), expected, testNumber++);
		else
			System.out.println("Failed test " + testNumber++);

		// test 22
		list.set(0, "A");
		test = list.get(0);
		expected = new String[] { "A", "C", "C", "D" };
		if (test.contentEquals("A"))
			computeResult(toArray(list), expected, testNumber++);
		else
			System.out.println("Failed test " + testNumber++);

		// test 23
		list.set(1, "V");
		test = list.get(1);
		expected = new String[] { "A", "V", "C", "D" };
		if (test.contentEquals("V"))
			computeResult(toArray(list), expected, testNumber++);
		else
			System.out.println("Failed test " + testNumber++);
		System.out.println();

		// test 24
		test = "remove(int pos): ";
		System.out.println(test);
		test = list.remove(0);
		expected = new String[] { "V", "C", "D" };
		if (test.contentEquals("A"))
			computeResult(toArray(list), expected, testNumber++);
		else
			System.out.println("Failed test " + testNumber++);

		// test 25
		test = list.remove(1);
		expected = new String[] { "V", "D" };
		if (test.contentEquals("C"))
			computeResult(toArray(list), expected, testNumber++);
		else
			System.out.println("Failed test " + testNumber++);

		// test 26
		test = list.remove(1);
		expected = new String[] { "V" };
		if (test.contentEquals("D"))
			computeResult(toArray(list), expected, testNumber++);
		else
			System.out.println("Failed test " + testNumber++);
		System.out.println();

		// test 27
		test = "remove(E Obj): ";
		System.out.println(test);
		list.add("X");
		list.add("P");
		list.add("C");
		boolean check = list.remove("B");
		expected = new String[] { "V", "X", "P", "C" };
		if (!check)
			computeResult(toArray(list), expected, testNumber++);
		else
			System.out.println("Failed test " + testNumber++);

		// test 28
		check = list.remove("V");
		expected = new String[] { "X", "P", "C" };
		if (check)
			computeResult(toArray(list), expected, testNumber++);
		else
			System.out.println("Failed test " + testNumber++);

		// test 29
		check = list.remove("V");
		expected = new String[] { "X", "P", "C" };
		if (!check)
			computeResult(toArray(list), expected, testNumber++);
		else
			System.out.println("Failed test " + testNumber++);
		System.out.println();

		// test 30
		test = "getSubList: ";
		System.out.println(test);
		IList<String> tester = list.getSubList(0, 0);
		expected = new String[] {};
		if (tester.toString().equals(Arrays.toString(expected)))
			System.out.println("Passed test " + testNumber++);
		else
			System.out.println("Failed test " + testNumber++);

		// test 31
		tester = list.getSubList(0, 2);
		expected = new String[] { "X", "P" };
		if (tester.toString().equals(Arrays.toString(expected)))
			System.out.println("Passed test " + testNumber++);
		else
			System.out.println("Failed test " + testNumber++);

		// test 32
		tester = list.getSubList(0, 3);
		expected = new String[] { "X", "P", "C" };
		if (tester.toString().equals(Arrays.toString(expected)))
			System.out.println("Passed test " + testNumber++);
		else
			System.out.println("Failed test " + testNumber++);
		System.out.println();

		// test 33
		test = "size: ";
		System.out.println(test);
		if (list.size() == expected.length)
			System.out.println("Passed test " + testNumber++);
		else
			System.out.println("Failed test " + testNumber++);

		// test 34
		list = new LinkedList<>();
		expected = new String[] {};
		if (list.size() == expected.length)
			System.out.println("Passed test " + testNumber++);
		else
			System.out.println("Failed test " + testNumber++);

		// test 35
		list.add("P");
		expected = new String[] { "P" };
		if (list.size() == expected.length)
			System.out.println("Passed test " + testNumber++);
		else
			System.out.println("Failed test " + testNumber++);
		System.out.println();

		// test 36
		test = "indexOf(E item) ";
		System.out.println(test);
		expected = new String[] { "P" };
		if (list.indexOf("P") == 0)
			System.out.println("Passed test " + testNumber++);
		else
			System.out.println("Failed test " + testNumber++);

		// test 37
		list.addFirst("C");
		expected = new String[] { "C", "P" };
		if (list.indexOf("C") == 0)
			System.out.println("Passed test " + testNumber++);
		else
			System.out.println("Failed test " + testNumber++);

		// test 38
		list.addFirst("D");
		expected = new String[] { "D", "C", "P" };
		if (list.indexOf("C") == 1)
			System.out.println("Passed test " + testNumber++);
		else
			System.out.println("Failed test " + testNumber++);
		System.out.println();

		// test 39
		test = "indexOf(E item, int pos) ";
		System.out.println(test);
		list.add("C");
		expected = new String[] { "D", "C", "P", "C" };
		if (list.indexOf("C", 1) == 1)
			System.out.println("Passed test " + testNumber++);
		else
			System.out.println("Failed test " + testNumber++);

		// test 40
		if (list.indexOf("C", 2) == 3)
			System.out.println("Passed test " + testNumber++);
		else
			System.out.println("Failed test " + testNumber++);

		// test 41
		if (list.indexOf("D", 1) == -1)
			System.out.println("Passed test " + testNumber++);
		else
			System.out.println("Failed test " + testNumber++);
		System.out.println();

		// test 42
		test = "makeEmpty: ";
		System.out.println(test);
		list.makeEmpty();
		expected = new String[] {};
		computeResult(toArray(list), expected, testNumber++);

		// test 43
		list.makeEmpty();
		expected = new String[] {};
		computeResult(toArray(list), expected, testNumber++);

		// test 44
		list.add("O");
		list.add("P");
		list.makeEmpty();
		expected = new String[] {};
		computeResult(toArray(list), expected, testNumber++);
		System.out.println();

		// test 45
		test = "Iterator: ";
		System.out.println(test);
		Iterator<String> iter = list.iterator();
		if (iter instanceof Iterator)
			System.out.println("Passed test " + testNumber++);
		else
			System.out.println("Failed test " + testNumber++);

		// test 46
		list.add("P");
		list.add("P");
		list.add("P");
		iter = list.iterator();
		if (iter instanceof Iterator)
			System.out.println("Passed test " + testNumber++);
		else
			System.out.println("Failed test " + testNumber++);

		// test 47
		list.add("P");
		list.add("P");
		list.remove("P");
		iter = list.iterator();
		if (iter instanceof Iterator)
			System.out.println("Passed test " + testNumber++);
		else
			System.out.println("Failed test " + testNumber++);
		System.out.println();

		// test 48
		test = "removeRange:  ";
		System.out.println(test);
		list.makeEmpty();
		list.add("V");
		list.add("X");
		list.add("P");
		list.add("C");
		list.removeRange(1, 3);
		expected = new String[] { "V", "C" };
		computeResult(toArray(list), expected, testNumber++);

		// test 49
		list.removeRange(list.size() - 1, list.size());
		expected = new String[] { "V" };
		computeResult(toArray(list), expected, testNumber++);

		// test 50
		list.removeRange(0, 1);
		expected = new String[] {};
		computeResult(toArray(list), expected, testNumber++);
		System.out.println();

		// test 51
		test = "toString:  ";
		System.out.println(test);
		list.makeEmpty();
		list.add("V");
		list.add("X");
		list.add("P");
		list.add("C");
		expected = new String[] { "V", "X", "P", "C" };
		if (list.toString().equals(Arrays.toString(expected)))
			computeResult(toArray(list), expected, testNumber++);
		else
			System.out.println("Failed test " + testNumber++);

		// test 52
		list.removeRange(list.size() - 1, list.size());
		expected = new String[] { "V", "X", "P" };
		if (list.toString().equals(Arrays.toString(expected)))
			computeResult(toArray(list), expected, testNumber++);
		else
			System.out.println("Failed test " + testNumber++);

		// test 53
		list.removeRange(0, 1);
		expected = new String[] { "X", "P" };
		if (list.toString().equals(Arrays.toString(expected)))
			computeResult(toArray(list), expected, testNumber++);
		else
			System.out.println("Failed test " + testNumber++);
		System.out.println();

		// test 54
		test = "equals:  ";
		System.out.println(test);
		list.makeEmpty();
		list.add("V");
		list.add("X");
		list.add("P");
		list.add("C");
		LinkedList<String> list2 = new LinkedList<>();
		list2.add("V");
		list2.add("X");
		list2.add("P");
		list2.add("C");
		if (list.equals(list2))
			System.out.println("Passed test " + testNumber++);
		else
			System.out.println("Failed test " + testNumber++);

		// test 55
		list.makeEmpty();
		list2 = new LinkedList<>();
		if (list.equals(list2))
			System.out.println("Passed test " + testNumber++);
		else
			System.out.println("Failed test " + testNumber++);

		// test 56
		list.add("P");
		list2.add("P");
		list2.remove(0);
		if (!list.equals(list2))
			System.out.println("Passed test " + testNumber++);
		else
			System.out.println("Failed test " + testNumber++);
		System.out.println();

		// test 57
		System.out.println("Iterator tests");
		System.out.println("hasNext(): ");
		Iterator<String> iteratorLL = list.iterator();
		if (iteratorLL.hasNext())
			System.out.println("Passed test " + testNumber++);
		else
			System.out.println("Failed test " + testNumber++);

		// test 58
		list.add("P");
		list.add("M");
		iteratorLL = list.iterator();

		if (iteratorLL.hasNext())
			System.out.println("Passed test " + testNumber++);
		else
			System.out.println("Failed test " + testNumber++);

		// test 59
		list.makeEmpty();
		iteratorLL = list.iterator();

		if (!iteratorLL.hasNext())
			System.out.println("Passed test " + testNumber++);
		else
			System.out.println("Failed test " + testNumber++);
		System.out.println();

		// test 60
		System.out.println("next(): ");
		list.add("P");
		iteratorLL = list.iterator();
		String next = iteratorLL.next();
		if (next.contentEquals("P"))
			System.out.println("Passed test " + testNumber++);
		else
			System.out.println("Failed test " + testNumber++);

		// test 61
		list.add("C");
		iteratorLL = list.iterator();
		next = iteratorLL.next();
		next = iteratorLL.next();
		if (next.contentEquals("C"))
			System.out.println("Passed test " + testNumber++);
		else
			System.out.println("Failed test " + testNumber++);

		// test 62
		list.makeEmpty();
		list.add("P");
		list.add("C");
		list.remove(1);
		list.add("M");
		iteratorLL = list.iterator();
		next = iteratorLL.next();
		next = iteratorLL.next();
		if (next.equals("M"))
			System.out.println("Passed test " + testNumber++);
		else
			System.out.println("Failed test " + testNumber++);
		System.out.println();

		// test 63
		System.out.println("remove(): ");
		list.makeEmpty();
		list.add("P");
		iteratorLL = list.iterator();
		next = iteratorLL.next();
		iteratorLL.remove();
		expected = new String[] {};
		computeResult(toArray(list), expected, testNumber++);

		// test 64
		list.add("C");
		list.add("P");
		iteratorLL = list.iterator();
		iteratorLL.next();
		iteratorLL.remove();
		iteratorLL.next();
		iteratorLL.remove();
		expected = new String[] {};
		computeResult(toArray(list), expected, testNumber++);

		// test 65
		list.add("P");
		list.add("C");
		list.add("M");
		iteratorLL = list.iterator();
		next = iteratorLL.next();
		next = iteratorLL.next();
		iteratorLL.remove();
		expected = new String[] { "P", "M" };
		computeResult(toArray(list), expected, testNumber++);

		//comparison();
	}

	private static Object[] toArray(LinkedList<String> list) {
		Object[] result = new Object[list.size()];
		Iterator<String> it = list.iterator();
		int index = 0;
		while (it.hasNext()) {
			result[index] = it.next();
			index++;
		}
		return result;
	}

	// pre: none
	private static boolean arraysSame(Object[] one, Object[] two) {
		boolean same;
		if (one == null || two == null) {
			same = (one == two);
		} else {
			// neither one or two are null
			assert one != null && two != null;
			same = one.length == two.length;
			if (same) {
				int index = 0;
				while (index < one.length && same) {
					same = (one[index].equals(two[index]));
					index++;
				}
			}
		}
		return same;
	}

	private static final int NUM_DOUBLINGS_OF_N = 5;
	private static final int NUM_REPEATS_OF_TEST = 100;

	// A method to be run to compare your LinkedList class
	// and the Java ArrayList class.
	public static void comparison() {
		Stopwatch s = new Stopwatch();

		int initialN = 30000;
		addEndArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
		addEndLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

		initialN = 2000;
		addFrontArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
		initialN = 10000;
		addFrontLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

		initialN = 2000;
		removeFrontArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
		initialN = 5000;
		removeFrontLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

		initialN = 10000;
		getRandomArrayList(s, initialN, NUM_DOUBLINGS_OF_N);
		initialN = 1000;
		getRandomLinkedList(s, initialN, NUM_DOUBLINGS_OF_N);

		initialN = 50000;
		getAllArrayListUsingIterator(s, initialN, NUM_DOUBLINGS_OF_N);
		getAllLinkedListUsingIterator(s, initialN, NUM_DOUBLINGS_OF_N);

		initialN = 100000;
		getAllArrayListUsingGetMethod(s, initialN, NUM_DOUBLINGS_OF_N);
		initialN = 1000;
		getAllLinkedListUsingGetMethod(s, initialN, NUM_DOUBLINGS_OF_N);

	}

	// These pairs of method illustrate a failure to use polymorphism.
	// If the students had implemented the Java list interface there
	// could be a single method. Also we could use function objects to
	// reduce the awful repetition of code.
	public static void addEndArrayList(Stopwatch s, int initialN,
			int numTests) {

		double[] totalTimes = new double[numTests];
		for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
			int n = initialN;
			for (int i = 0; i < numTests; i++) {
				ArrayList<Integer> javaList = new ArrayList<>();
				s.start();
				for (int j = 0; j < n; j++) {
					javaList.add(j);
				}
				s.stop();
				totalTimes[i] += s.time();
				n *= 2;
			}
		}
		showResults("Adding at end: ArrayList", totalTimes, initialN);
	}

	private static void showResults(String title, double[] times,
			int initialN) {
		System.out.println();
		System.out.println("Num Repeats: " + NUM_REPEATS_OF_TEST);
		System.out.println(title);
		for (double time : times) {
			System.out.print("N = " + initialN + ", total time: ");
			System.out.printf("%7.4f\n", time);
			initialN *= 2;
		}
		System.out.println();
	}

	public static void addEndLinkedList(Stopwatch s, int initialN,
			int numTests) {
		double[] totalTimes = new double[numTests];
		for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
			int n = initialN;
			for (int i = 0; i < numTests; i++) {
				LinkedList<Integer> studentList = new LinkedList<>();
				s.start();
				for (int j = 0; j < n; j++) {
					studentList.add(j);
				}
				s.stop();
				totalTimes[i] += s.time();
				n *= 2;
			}
		}
		showResults("Adding at end: LinkedList", totalTimes, initialN);
	}

	public static void addFrontArrayList(Stopwatch s, int initialN,
			int numTests) {

		double[] totalTimes = new double[numTests];
		for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
			int n = initialN;
			for (int i = 0; i < numTests; i++) {
				ArrayList<Integer> javaList = new ArrayList<>();
				s.start();
				for (int j = 0; j < n; j++) {
					javaList.add(0, j);
				}
				s.stop();
				totalTimes[i] += s.time();
				n *= 2;
			}
		}
		showResults("Adding at front: ArrayList", totalTimes, initialN);
	}

	public static void addFrontLinkedList(Stopwatch s, int initialN,
			int numTests) {
		double[] totalTimes = new double[numTests];
		for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
			int n = initialN;
			for (int i = 0; i < numTests; i++) {
				LinkedList<Integer> studentList = new LinkedList<>();
				s.start();
				for (int j = 0; j < n; j++) {
					studentList.insert(0, j);
				}
				s.stop();
				totalTimes[i] += s.time();
				n *= 2;
			}
		}
		showResults("Adding at front: LinkedList", totalTimes, initialN);
	}

	public static void removeFrontArrayList(Stopwatch s, int initialN,
			int numTests) {
		double[] totalTimes = new double[numTests];
		for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
			int n = initialN;
			for (int i = 0; i < numTests; i++) {
				ArrayList<String> javaList = new ArrayList<>();
				for (int j = 0; j < n; j++) {
					javaList.add(j + "");
				}
				s.start();
				while (!javaList.isEmpty()) {
					javaList.remove(0);
				}
				s.stop();
				totalTimes[i] += s.time();
				n *= 2;
			}
		}
		showResults("Removing from front: ArrayList", totalTimes, initialN);
	}

	public static void removeFrontLinkedList(Stopwatch s, int initialN,
			int numTests) {
		double[] totalTimes = new double[numTests];
		for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
			int n = initialN;
			for (int i = 0; i < numTests; i++) {
				LinkedList<String> studentList = new LinkedList<>();
				for (int j = 0; j < n; j++) {
					studentList.add(j + "");
				}
				s.start();
				while (studentList.size() != 0) {
					studentList.removeFirst();
				}
				s.stop();
				totalTimes[i] += s.time();
				n *= 2;
			}
		}
		showResults("removing from front: LinkedList", totalTimes, initialN);
	}

	public static void getRandomArrayList(Stopwatch s, int initialN,
			int numTests) {
		double[] totalTimes = new double[numTests];
		for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
			int n = initialN;
			int total = 0;
			Random r = new Random();
			for (int i = 0; i < numTests; i++) {
				ArrayList<Integer> javaList = new ArrayList<>();
				for (int j = 0; j < n; j++) {
					javaList.add(j);
				}
				s.start();
				for (int j = 0; j < n; j++) {
					total += javaList.get(r.nextInt(javaList.size()));
				}
				s.stop();
				totalTimes[i] += s.time();
				n *= 2;
			}
		}
		showResults("Getting random: ArrayList", totalTimes, initialN);
	}

	public static void getRandomLinkedList(Stopwatch s, int initialN,
			int numTests) {
		double[] totalTimes = new double[numTests];
		for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
			int n = initialN;
			int total = 0;
			Random r = new Random();
			for (int i = 0; i < numTests; i++) {
				LinkedList<Integer> studentList = new LinkedList<>();
				for (int j = 0; j < n; j++) {
					studentList.add(j);
				}
				s.start();
				for (int j = 0; j < n; j++) {
					total += studentList.get(r.nextInt(studentList.size()));
				}
				s.stop();
				totalTimes[i] += s.time();
				n *= 2;
			}
		}
		showResults("Getting random: LinkedList", totalTimes, initialN);
	}

	public static void getAllArrayListUsingIterator(Stopwatch s, int initialN,
			int numTests) {

		double[] totalTimes = new double[numTests];
		for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
			int n = initialN;
			int total = 0;
			for (int i = 0; i < numTests; i++) {
				ArrayList<Integer> javaList = new ArrayList<>();
				for (int j = 0; j < n; j++) {
					javaList.add(j);
				}
				Iterator<Integer> it = javaList.iterator();
				s.start();
				while (it.hasNext()) {
					total += it.next();
				}
				s.stop();
				totalTimes[i] += s.time();
				n *= 2;
			}
		}
		showResults("Getting all using iterator: ArrayList", totalTimes,
				initialN);
	}

	public static void getAllLinkedListUsingIterator(Stopwatch s, int initialN,
			int numTests) {
		double[] totalTimes = new double[numTests];
		for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
			int n = initialN;
			int total = 0;
			for (int i = 0; i < numTests; i++) {
				LinkedList<Integer> studentList = new LinkedList<>();
				for (int j = 0; j < n; j++) {
					studentList.add(j);
				}
				Iterator<Integer> it = studentList.iterator();
				s.start();
				while (it.hasNext()) {
					total += it.next();
				}
				s.stop();
				totalTimes[i] += s.time();
				n *= 2;
			}
		}
		showResults("Getting all using iterator: LinkedList", totalTimes,
				initialN);
	}

	public static void getAllArrayListUsingGetMethod(Stopwatch s, int initialN,
			int numTests) {
		double[] totalTimes = new double[numTests];
		for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
			int n = initialN;
			for (int i = 0; i < numTests; i++) {
				ArrayList<Integer> javaList = new ArrayList<>();
				for (int j = 0; j < n; j++) {
					javaList.add(j);
				}
				s.start();
				int x = 0;
				for (int j = 0; j < javaList.size(); j++) {
					x += javaList.get(j);
				}
				s.stop();
				totalTimes[i] += s.time();
				n *= 2;
			}
		}
		showResults("Getting all using get method: ArrayList", totalTimes,
				initialN);
	}

	public static void getAllLinkedListUsingGetMethod(Stopwatch s, int initialN,
			int numTests) {
		double[] totalTimes = new double[numTests];
		for (int t = 0; t < NUM_REPEATS_OF_TEST; t++) {
			int n = initialN;
			for (int i = 0; i < numTests; i++) {
				LinkedList<Integer> studentList = new LinkedList<>();
				for (int j = 0; j < n; j++) {
					studentList.add(j);
				}
				s.start();
				int x = 0;
				for (int j = 0; j < studentList.size(); j++) {
					x += studentList.get(j);
				}
				s.stop();
				totalTimes[i] += s.time();
				n *= 2;
			}
		}
		showResults("Getting all using get method: LinkedList", totalTimes,
				initialN);
	}

	// for future changes
	private static interface ArrayListOp {
		public <E> void op(ArrayList<E> list, E data);
	}

	private ArrayListOp addAL = new ArrayListOp() {
		public <E> void op(ArrayList<E> list, E data) {
			list.add(data);
		}
	};

	private ArrayListOp addFrontAL = new ArrayListOp() {
		public <E> void op(ArrayList<E> list, E data) {
			list.add(0, data);
		}
	};

	private ArrayListOp removeFrontAL = new ArrayListOp() {
		public <E> void op(ArrayList<E> list, E data) {
			list.remove(0);
		}
	};

	private static interface LinkedListOp<E> {
		public void op(LinkedList<E> list);
	}

	private static void computeResult(Object[] actual, Object[] expected,
			int testNumber) {
		if (arraysSame(actual, expected)) {
			System.out.println("Passed test " + testNumber);
		} else {
			System.out.println("Failed test " + testNumber);
		}
	}
}
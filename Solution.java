
import java.security.KeyStore.Entry;
import java.util.*;
import java.util.concurrent.PriorityBlockingQueue;

public class Solution {
	String letter;
	Integer frequency;
	Map<Character, Integer> hMap;
	PriorityQueue<Map.Entry<Character, Integer>>[] pq;

	// constructor
	public Solution() {
	}

	public void read(String input) {

		hMap = new HashMap<>();

		for (int i = 0; i < input.length(); i++) {

			Character c = input.charAt(i);
			frequency = hMap.get(c);
			if (c == ' ') {
				c = '_';
			}
			if (frequency != null) {

				Integer val = frequency + 1;
				hMap.put(c, val);
			} else {
				hMap.put(c, 1);
			}
			// System.out.println(hSet.size());

		}

		// travmap(hMap);
	}

	public void makeTreeBaby() {
		pq = new PriorityQueue[hMap.size()];
		// https://leetcode.com/problems/top-k-frequent-words/discuss/108346/My-simple-Java-solution-using-HashMap-and-PriorityQueue-O(nlogk)-time-and-O(n)-space

		for (int i = 0; i < pq.length; i++) {
			pq[i] = new PriorityQueue<>(
					(a, b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey())
							: a.getValue() - b.getValue());

		}
		pq = addEntries(pq);

		// // itForPq.next();
		// while (itForPq.hasNext()) {
		// Map.Entry mapEleEntry = (Map.Entry) itForPq.next();
		// char key = (char) mapEleEntry.getKey();
		// int val = (int) mapEleEntry.getValue();
		// if (val == 1) {

		// System.out.println(key);
		// } else
		// System.out.println(key);

		// }

	};

	public PriorityQueue[] addEntries(PriorityQueue<Map.Entry<Character, Integer>>[] pq) {
		int i = 0;

		for (Map.Entry<Character, Integer> entry : hMap.entrySet()) {

			pq[i].offer(entry);
			i++;
		}

		return pq;
	}

	public void travmap(Map<Character, Integer> hMap) {

		for (Integer i : hMap.values()) {
			System.out.println(i + "key");
		}
		for (Character character : hMap.keySet()) {

			System.out.println(character);
		}

	}

	public static void main(String[] args) {

		Solution sol = new Solution();
		sol.read("Hello class!");
		/// sol.pq[1].offer(Map.entry('c', 2));
		sol.makeTreeBaby();
		// sol.pq[1].offer(Map.entry('-', 1));
		for (int i = 0; i < sol.pq.length; i++) {
			System.out.println(sol.pq[i].poll());
		}
		// System.out.println(sol.pq[3].poll());
		// System.out.println(sol.pq[1].poll());
		// System.out.println(sol.pq[1].poll());
	}

}

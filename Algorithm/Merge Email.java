
/*
合并邮件列表
list 1: a@a.com, b@b.com
list 2: b@b.com, c@c.com
list 3: e@e.com
list 4: a@a.com
...
Combine lists with identical emails, and output tuples:
(list 1, list 2, list 4) (a@a.com, b@b.com, c@c.com)
(list 3) (e@e.com)
*/

package com.company;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MergeEmailLists {

	private List<Set<String>> mergeEmails(String[][] emails) {
		List<Set<String>> result = new ArrayList<>();
		if (emails == null || emails.length == 0 || emails[0].length == 0) {
			return result;
		}

		int m = emails.length;
		int[]
			parent =
			new int[m]; // initialize parent array, at the begining, each list is in its own group
		for (int i = 0; i < m; i++) {
			parent[i] = i;
		}

		// key: email, value: List of set numbers that email belongs to
		Map<String, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < m; i++) {
			for (String email : emails[i]) {
				if (!map.containsKey(email)) {
					List<Integer> list = new ArrayList<>();
					list.add(i);
					map.put(email, list);
				} else {
					map.get(email).add(i);
				}
			}
		}

		// union
		for (List<Integer> list : map.values()) {
			// list is already in order
			for (Integer aList : list) {
				// make larger parent node point to small parent node
				union(parent, list.get(0), aList);
			}
		}

		HashMap<Integer, Set<String>> hash = new HashMap<>();

		//initialization
		for (int i = 0; i < m; i++) {
			hash.put(i, new HashSet<>());
		}
		for (int i = 0; i < m; i++) {
			if (i != parent[i]) {
				int p = parent[i];
				if (hash.get(p).isEmpty()) {
					hash.get(p).addAll(Arrays.asList(emails[p]));
				}
				hash.get(p).addAll(Arrays.asList(emails[i]));
			} else {   // 如果parent的值指向自身，说明是单独的集合，直接加入
				hash.get(i).addAll(Arrays.asList(emails[i]));
			}
		}

		for (Set<String> set : hash.values()) {
			if (!set.isEmpty()) {
				result.add(set);
			}
		}
		return result;
	}

	private void union(int[] parent, int x, int y) {
		int parentX = getParent(parent, x);
		int parentY = getParent(parent, y);
		if (parentX < parentY) {
			parent[parentY] = parentX;
		} else if (parentX > parentY) {
			parent[parentX] = parentY;
		}
	}

	private int getParent(int[] parent, int x) {

		if(x  != parent[x]){
			return getParent(parent, parent[x]);
		}

		return x;
	}

	public static void main(String[] args) {
		String[] e0 = {"a@a.com", "b@b.com"};
		String[] e1 = {"b@b.com", "c@c.com"};
		String[] e2 = {"e@e.com"};
		String[] e3 = {"a@a.com"};
		String[][] emails = {e0, e1, e2, e3};
		MergeEmailLists test = new MergeEmailLists();
		List<Set<String>> result = test.mergeEmails(emails);
		for (Set<String> set : result) {
			System.out.println(set);
		}
	}
}

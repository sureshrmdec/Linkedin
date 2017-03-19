/*
Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
UPDATE (2017/1/20):
The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.

*/


public class Solution {
public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {

		List<List<String>> res = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		Map<String, Integer> distance = new HashMap<>();

		wordList.add(beginWord);
		wordList.add(endWord);

		bfs(map,distance,beginWord,wordList);
		List<String> r = new ArrayList<>();
		dfs(res,r ,distance,beginWord,endWord,map);

		return res;

	}


	private void dfs(List<List<String>> res, List<String> r, Map<String, Integer> distance,
					 String startWord,
					 String endWord, Map<String, List<String>> map) {

		r.add(endWord);

		if (startWord.equals(endWord)) {
			Collections.reverse(r);
			res.add(new ArrayList<String>(r));
			Collections.reverse(r);
		} else {
			for (String prev : map.get(endWord)) {
				if (distance.containsKey(prev) && distance.get(prev) + 1
												  == distance.get(endWord)) {
					dfs(res, r, distance, startWord, prev, map);
				}
			}
		}
		
		r.remove(r.size() - 1);

	}

	private void bfs(Map<String, List<String>> map, Map<String, Integer> distance, String beginWord,
					 Set<String> wordList) {

		Queue<String> q = new LinkedList<>();
		q.add(beginWord);
		distance.put(beginWord, 0);
		for (String s : wordList) {
			map.put(s, new ArrayList<>());
		}
		while (!q.isEmpty()) {

			String temp = q.poll();

			for (String s : getWords(temp, wordList)) {
				map.get(s).add(temp);
				if (!distance.containsKey(s)) {
					distance.put(s, distance.get(temp) + 1);
					q.add(s);
				}
			}

		}

	}

	private List<String> getWords(String beginWord, Set<String> wordList) {

		List<String> words = new ArrayList<>();

		for (int i = 0; i < beginWord.length(); i++) {

			for (char ch = 'a'; ch <= 'z'; ch++) {

				String temp = getWord(beginWord, ch, i);

				if (wordList.contains(temp)) {
					words.add(temp);
				}
			}
		}

		return words;

	}

	private String getWord(String beginWord, char ch, int pos) {

		char[] arr = beginWord.toCharArray();
		arr[pos] = ch;

		return new String(arr);
	}

}

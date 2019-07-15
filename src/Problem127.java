import java.util.*;

public class Problem127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList.size());
        wordSet.addAll(wordList);

        if (!wordSet.contains(endWord)) return 0;
        //Map<String, List<String>> nextWord = new HashMap<>();
        //if (!wordList.contains(beginWord)) wordList.add(beginWord);
        //nextWord = getNextWord(wordList);
        return bfs(beginWord, endWord, wordSet);
    }

    private int bfs(String begin, String end, Set<String> wordSet) {
        int count = 1;
        Queue<String> queue = new LinkedList<>();
        Set<String> meet = new HashSet<>();
        queue.add(begin);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- != 0) {
                String temp = queue.poll();
                if (temp.equals(end)) return count;
                for (int i = 0; i < temp.length(); ++i) {
                    char[] chars = temp.toCharArray();
                    for (char c = 'a'; c <= 'z'; ++c) {
                        chars[i] = c;
                        String changed = new String(chars);
                        if (meet.contains(changed) || !wordSet.contains(changed))
                            continue;
                        queue.add(changed);
                        meet.add(changed);
                    }
                }
            }
            count++;
        }
        return 0;
    }

//    private Map<String, List<String>> getNextWord(List<String> wordList) {
//        Map<String, List<String>> nextWord = new HashMap<>();
//        for (String word : wordList) {
//            nextWord.put(word, new ArrayList<>());
//            for (int i = 0; i < word.length(); ++i) {
//                char[] chars = word.toCharArray();
//                for (char c = 'a'; c <= 'z'; ++c) {
//                    chars[i] = c;
//                    String changed = new String(chars);
//                    if (!changed.equals(word) && wordList.contains(changed))
//                        nextWord.get(word).add(changed);
//                }
//            }
//        }
//        return nextWord;
//    }
}

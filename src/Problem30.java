import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words.length == 0) return res;
        int wordLen = words[0].length(), sLen = s.length();
        if (sLen < wordLen * words.length) return res;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        //由于单词长度一定，如果words中单词长度是3，那么从s的0，1，2位置每三个字母当一个单词遍历，即可遍历所有情况
        for (int start = 0; start < wordLen; ++start) {
            int position = start; //记录当前位置
            int tStart = -1; //记录该段string从哪个位置开始
            Map<String, Integer> tempMap = new HashMap<>(map);
            while (position + wordLen <= s.length()) {
                String word = s.substring(position, position + wordLen);
                if (!map.containsKey(word)) { //加入没这个单词，那么从这个单词之后开始重新遍历
                    //这个细节修改可以提速很多！！！
                    if(tStart != -1) tempMap = new HashMap<>(map);
                    tStart = -1;
                } else if (tempMap.containsKey(word)) {
                    tStart = tStart == -1 ? position : tStart; //tStart如果没记录开始位置则记录
                    if (tempMap.get(word) == 1) tempMap.remove(word);
                    else tempMap.put(word, tempMap.get(word) - 1);
                    if (tempMap.isEmpty()) res.add(tStart);
                } else {
                    while (tStart < position) {
                        String tempWord = s.substring(tStart, tStart + wordLen);
                        tStart += wordLen;
                        if (tempWord.equals(word)) {
                            //如果word和tempWord相同，那么说明从这个tStart位置往后找就行，不用把他放回map里面
                            if (tempMap.isEmpty()) res.add(tStart);
                            break;
                        }
                        else tempMap.put(tempWord, tempMap.getOrDefault(tempWord, 0)+1);
                    }
                }
                position += wordLen;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String a = "barfoofoobarthefoobarman";
        String[] b = {"bar", "foo", "the"};
        new Problem30().findSubstring(a, b);
    }
}

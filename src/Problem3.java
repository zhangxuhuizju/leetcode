import java.util.HashMap;
/*
官方题解，让代码更加优雅！
public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i); //!!!这段很巧妙
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }
 */
public class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        int result = 1;
        if (s.length() <= 1) return s.length();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int left = 0, right = 0, temp;
        while (right < s.length()) {
            if(hashMap.get(s.charAt(right)) != null) {
                temp = left;
                left = hashMap.get(s.charAt(right)) + 1;
                for (int i = temp; i < left; ++i)
                    hashMap.remove(s.charAt(i));
            }
            hashMap.put(s.charAt(right), right);
            right++;
            if (right - left > result) result = right - left;
        }
        return result;
    }
}

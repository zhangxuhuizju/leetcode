import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem68 {
    List<String> res = new ArrayList<>();
    public List<String> fullJustify(String[] words, int maxWidth) {
        int index = 0, word_count = 0, len = 0;
        while (index < words.length) {
            len += words[index].length();
            word_count++;
            if (len + word_count - 1 > maxWidth) {
                word_count--;
                len -= words[index].length();
                newLine(words, maxWidth, word_count, index-word_count, len);
                word_count = 1;
                len = words[index].length();
            }
            index++;
        }
        newLine(words, maxWidth, word_count, index-word_count, len);
        return res;
    }
    public void newLine(final String[] words, int maxWidth, int word_count, int start, int len) {
        StringBuilder sb = new StringBuilder();
        if (word_count == 1) {
            sb.append(words[start]);
            for (int i = len + 1; i <= maxWidth; ++i)
                sb.append(" ");
            res.add(sb.toString());
            return;
        }
        int[] space = new int[word_count-1];
        Arrays.fill(space, 1);
        if (word_count + start < words.length) {
            int rest = maxWidth - word_count + 1 - len, index = 0;
            while (rest > 0) {
                space[index++ % space.length]++;
                rest--;
            }
        }
        for (int i = start; i < start + word_count; ++i) {
            sb.append(words[i]);
            if (i == start + word_count - 1) continue;
            for (int j = 0; j < space[i-start]; ++j)
                sb.append(" ");
        }
        while (sb.length() < maxWidth)
            sb.append(" ");
        res.add(sb.toString());
    }
}

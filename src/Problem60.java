import java.util.ArrayList;
import java.util.List;

public class Problem60 {
    List<Integer> list = new ArrayList<>();
    public String getPermutation(int n, int k) {
        if (n == 1) return "1";
        int[] factors = new int[n];
        factors[1] = factors[0] = 1;
        list.add(1);
        for (int i = 2; i < n; ++i) {
            factors[i] = factors[i-1] * i;
            list.add(i);
        }
        list.add(n);
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            int factor = factors[n-1];
            int index = k % factor == 0 ? k / factor - 1 : k / factor;
            sb.append(list.get(index));
            list.remove(index);
            n--;
            k -= index * factor;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new Problem60().getPermutation(3, 3);
    }
}

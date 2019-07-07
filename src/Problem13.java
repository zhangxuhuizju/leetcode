public class Problem13 {
    public int romanToInt(String s) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] reps = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int res = 0;
        for (int i = 0; i != 13 && !s.isEmpty(); ++i) {
            while (s.indexOf(reps[i]) == 0) {
                res += values[0];
                s = s.substring(reps[i].length());
            }
        }
        return res;
    }
}

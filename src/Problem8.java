public class Problem8 {
    public int myAtoi(String str) {
        str = str.trim();
        if(str == null || str.length() < 1)
            return 0;
        boolean positive = true;
        int index = 0;
        if(str.charAt(0) == '-') {
            positive = false;
            index++;
        }else if(str.charAt(0) == '+') {
            index++;
        }
        double result = 0;
        while(index<str.length() && Character.isDigit(str.charAt(index))) {
            result = result*10 + (str.charAt(index)-'0');
            ++index;
        }
        if(!positive) result = -result;
        if(result>Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if(result<Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        return (int) result;
    }
}

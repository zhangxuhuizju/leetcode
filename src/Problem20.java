public class Problem20 {
    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int index = 0;
        char temp;
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stack[index++] = c;
                    break;
                case ')':
                    if (index == 0) return false;
                    temp = stack[--index];
                    if (temp != '(') return false;
                    break;
                case ']':
                    if (index == 0) return false;
                    temp = stack[--index];
                    if (temp != '[') return false;
                    break;
                case '}':
                    if (index == 0) return false;
                    temp = stack[--index];
                    if (temp != '{') return false;
                    break;
            }
        }
        return index == 0;
    }
}

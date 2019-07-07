import java.util.LinkedList;

public class Problem71 {
    public String simplifyPath(String path) {
        LinkedList<String> list = new LinkedList<>();
        String[] root = path.split("/");
        for (String s : root) {
            if (s == null || s.length() == 0 || s.equals("."))
                continue;
            else if(s.equals("..")) {
                if(list.isEmpty())
                    continue;
                else list.removeLast();
            } else  list.add(s);
        }
        if (list.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        for (String s : list)
            sb.append("/").append(s);
        return sb.toString();
    }
}

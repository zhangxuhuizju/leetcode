import java.util.*;
public class Problem126 {
    List<List<String>> res = new ArrayList<>();
    LinkedList<String> list = new LinkedList<>();

    Map<String, Set<String>> parents = new HashMap<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList.size()+1);
        wordSet.addAll(wordList);
        wordSet.add(beginWord);
        if (!wordSet.contains(endWord))
            return res;
        Map<String, List<String>> nextWord = getNextWord(wordSet);
        boolean find = bfs(beginWord, endWord, nextWord);
        if (!find)
            return res;
        dfs(beginWord, endWord);
        return res;
    }

    private Map<String, List<String>> getNextWord(Set<String> wordSet) {
        Map<String, List<String>> nextWord = new HashMap<>();
        for (String word : wordSet) {
            List<String> next = new ArrayList<>();
            for (int i = 0; i < word.length(); ++i) {
                char[] chars = word.toCharArray();
                for (char c = 'a'; c <= 'z'; ++c) {
                    chars[i] = c;
                    String changed = new String(chars);
                    if (!word.equals(changed) && wordSet.contains(changed))
                        next.add(changed);
                }
            }
            nextWord.put(word, new ArrayList<>(next));
        }
        return nextWord;
     }

    private boolean bfs(String begin, String end, Map<String, List<String>> nextWord) {
        boolean find = false;
        Queue<String> queue = new LinkedList<>();
        Set<String> meet = new HashSet<>();
        queue.add(begin);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> layerMeet = new HashSet();
            while (size-- != 0) {
                String temp = queue.poll();
                if (temp.equals(end)) find = true;
                for (String s : nextWord.get(temp)) {
                    if (meet.contains(s)) continue;
                    layerMeet.add(s);
                    queue.add(s);
                    if (parents.getOrDefault(s, null) == null)
                        parents.put(s, new HashSet<>());
                    parents.get(s).add(temp);
                }
            }
            meet.addAll(layerMeet);
            if (find) return true;
        }
        return false;
    }

    private void dfs(String begin, String now) {
        list.addFirst(now);
        if (now.equals(begin)) {
            res.add(new ArrayList<>(list));
            list.removeFirst();
            return;
        }
        for (String s : parents.get(now))
            dfs (begin, s);
        list.removeFirst();
    }

    public static void main(String[] args) {
        String[] ss = {"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"};
        System.out.println(new Problem126().findLadders("cet", "ism", Arrays.asList(ss)));
    }
}

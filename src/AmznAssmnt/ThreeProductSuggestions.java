package AmznAssmnt;
import java.util.*;

class ThreeProductSuggestions {
    class TrieNode {
        Map<Character, TrieNode> children;
        List<String> products;
        boolean isWord;

        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
            products = new ArrayList<>();
            isWord = false;
        }
    }

    TrieNode root;
    String prefix;
    //int numProducts, List<String> repository, String customerQuery

    public List<List<String>> threeProductSuggestions(int numProducts, List<String> repository, String customerQuery) {
        root = new TrieNode();
        prefix = "";
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < numProducts; i++) {
            add(repository.get(i), 1);
        }
        int len = customerQuery.length();
        //System.out.println(len);
        int h=1;
        char[] charArr = customerQuery.toCharArray();
        prefix=prefix+charArr[0];
        for (int i = 1; i < len; i++) {
            //System.out.println(h++);
            prefix = prefix + charArr[i];
            //System.out.println(prefix);
            TrieNode curr = root;
            for (char cc : prefix.toCharArray()) {
                TrieNode next = curr.children.get(cc);
                if (next == null) {
                    return new ArrayList<>();
                }
                curr = next;
            }
            PriorityQueue<String> pq = new PriorityQueue<>((a, b) ->  a.compareTo(b));
            pq.addAll(curr.products);
            int k = 3;
            List<String> res = new ArrayList<>();
            while (!pq.isEmpty() && k > 0) {
                res.add(pq.poll());
                k--;
            }
            //System.out.println(Arrays.asList(res));
            result.add(res);
        }

        return result;
    }

    public void add(String s, int count) {
        TrieNode curr = root;
        for (char c : s.toCharArray()) {
            TrieNode next = curr.children.get(c);
            if (next == null) {
                next = new TrieNode();
                curr.children.put(c, next);
            }
            curr = next;
            curr.products.add(s);
        }
        curr.isWord = true;
    }

    public static void main(String[] args){
        ThreeProductSuggestions tps = new ThreeProductSuggestions();
        int testNumProducts = 5;
        List<String> testRepository = new ArrayList<>();
        testRepository.add("mouse");
        testRepository.add("monitor");
        testRepository.add("mousepad");
        testRepository.add("moneypot");
        testRepository.add("mobile");
        String testQuery = "mouse";
        List<List<String>> result= tps.threeProductSuggestions(testNumProducts,testRepository,testQuery);
        for(List<String> l: result) {
            System.out.println(Arrays.asList(l));
        }
    }
}

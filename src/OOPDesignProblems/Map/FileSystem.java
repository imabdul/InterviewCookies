package OOPDesignProblems.Map;

/**
 * https://leetcode.com/problems/design-in-memory-file-system/
 *
 * Design an in-memory file system to simulate the following functions:
 *
 * ls: Given a path in string format. If it is a file path, return a list that only contains this file's name. If it is a directory path, return the list of file and directory names in this directory. Your output (file and directory names together) should in lexicographic order.
 *
 * mkdir: Given a directory path that does not exist, you should make a new directory according to the path. If the middle directories in the path don't exist either, you should create them as well. This function has void return type.
 *
 * addContentToFile: Given a file path and file content in string format. If the file doesn't exist, you need to create that file containing given content. If the file already exists, you need to append given content to original content. This function has void return type.
 *
 * readContentFromFile: Given a file path, return its content in string format.
 *
 *
 *
 * Example:
 *
 * Input:
 * ["FileSystem","ls","mkdir","addContentToFile","ls","readContentFromFile"]
 * [[],["/"],["/a/b/c"],["/a/b/c/d","hello"],["/"],["/a/b/c/d"]]
 *
 * Output:
 * [null,[],null,null,["a"],"hello"]
 *
 * Explanation:
 * filesystem
 *
 *
 * Note:
 *
 * You can assume all file or directory paths are absolute paths which begin with / and do not end with / except that the path is just "/".
 * You can assume that all operations will be passed valid parameters and users will not attempt to retrieve file content or list a directory or file that does not exist.
 * You can assume that all directory names and file names only contain lower-case letters, and same names won't exist in the same directory.
 *
 */

import java.util.*;
class FileSystem {
    TrieNode root;
    public FileSystem() {
        root = new TrieNode("/");
    }

    public List<String> ls(String path) {
        TrieNode node = traverse(path);
        List<String> res = new ArrayList<>();
        if(node.isFile) res.add(node.name);
        else {
            for(String child : node.children.keySet()){
                res.add(child);
            }
        }
        return res;
    }

    public void mkdir(String path) {
        traverse(path);

    }

    public void addContentToFile(String filePath, String content) {
        TrieNode node = traverse(filePath);
        node.isFile=true;
        node.content.append(content);
    }

    public String readContentFromFile(String filePath) {
        TrieNode node = traverse(filePath);
        return node.content.toString();
    }

    private TrieNode traverse(String path){
        TrieNode curr = root;
        String [] arr = path.split("/");
        // start from index 1 as 0th element is ""
        for(int i=1; i< arr.length; i++){
            if(!curr.children.containsKey(arr[i])){
                TrieNode node = new TrieNode(arr[i]);
                curr.children.put(arr[i], node);
            }
            curr= curr.children.get(arr[i]);
        }
        return curr;
    }

    class TrieNode{
        String name;
        StringBuilder content;
        //Idea is TreeMap is holding only children. Meaning, it will have entry in case of directory. File cannot have children, therefore, retrieve filename from name attribute by checking isFile flag.
        boolean isFile;
        //Treemap is only when the output is required in lexicographical order. Otherwise any map would do
        Map<String,TrieNode> children;

        public TrieNode(String name){
            this.name = name;
            this.content = new StringBuilder();
            this.children = new TreeMap<String, TrieNode>();
        }
    }

    public static void main(String[] Args){
        FileSystem fs = new FileSystem();
        System.out.println(Arrays.asList(fs.ls("/"))); //expected null
        fs.mkdir("/a/b/c");
        fs.addContentToFile("/a/b/c/d","hello");
        System.out.println(Arrays.asList(fs.ls("/"))); //expected [a]
        System.out.println(fs.readContentFromFile("/a/b/c/d")); // expected "hello"

    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */

package OOPDesignProblems;

/**
 * Note: This is a companion problem to the System Design problem: Design TinyURL.
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.
 *
 * Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work.
 * You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 */

import java.util.*;
public class EncodeAndDecodeTinyURL {
    String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    Map<String, String> map = new HashMap();
    Random rand = new Random();
    String key = getRand();

    private String getRand(){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<6; i++){
            sb.append(alphabet.charAt(rand.nextInt(62)));
        }
        return sb.toString();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        while(map.containsKey(key)){
            key=getRand();
        }
        map.put(key,longUrl);
        return "https://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl.replace("https://tinyurl.com/", ""));
    }

    public static void main(String[] args){
        EncodeAndDecodeTinyURL ed = new EncodeAndDecodeTinyURL();
        System.out.println(ed.encode("https://leetcode.com/problems/design-tinyurl"));
        System.out.println(ed.decode(ed.encode("https://leetcode.com/problems/design-tinyurl"))); //should return "https://leetcode.com/problems/design-tinyurl"
    }
}

/**
 *
 * Algorithm
 * -----------
 * In this case, again, we make use of the set of numbers and alphabets to generate the coding for the given URLs, similar to Approach 2.
 * But in this case, the length of the code is fixed to 6 only. Further, random characters from the string to form the characters of the code.
 * In case, the code generated collides with some previously generated code, we form a new random code.
 *
 * Performance Analysis
 * -----------------------
 *
 * The number of URLs that can be encoded is quite large in this case, nearly of the order (10+26*2)^6
 *
 * The length of the encoded URLs is fixed to 6 units, which is a significant reduction for very large URLs.
 *
 * The performance of this scheme is quite good, due to a very less probability of repeated same codes generated.
 *
 * We can increase the number of encodings possible as well, by increasing the length of the encoded strings. Thus, there exists a tradeoff between the length of the code and the number of encodings possible.
 *
 * Predicting the encoding isn't possible in this scheme since random numbers are used.
 */

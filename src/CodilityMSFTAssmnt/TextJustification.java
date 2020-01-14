package CodilityMSFTAssmnt;


import java.util.*;
import java.util.List;

/**
 * created by Abdul Malik
 *
 * https://leetcode.com/problems/text-justification/
 * LeetCode Hard Problem, asked in Msft online codility assessment
 *
 *
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 *
 * The solution is based on this following explanation
 * https://leetcode.com/problems/text-justification/discuss/24876/Simple-Java-Solution
 *
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int index=0;
        int len = words.length;
        List<String> lines = new ArrayList<>();
        //looping through start word to the last word in words
        while(index<len){ //this is to write each line at a time
            int last=index+1;
            int count=words[index].length();
            while(last<len){ //keeping words withIn maxWidth
                if(count+words[last].length()+1 > maxWidth) break;
                count+=words[last].length()+1;
                last++;
            }

            //difference in last and index, -1 is cause one less in space than number of words
            int diff = last-index-1;
            StringBuilder sb = new StringBuilder();

            //if it's a last line or only one word exists in the input array
            //left justified
            if(last==len || diff==0){
                for (int i=index;i<last; i++){
                    sb.append(words[i] + " ");
                }
                sb.deleteCharAt(sb.length()-1);
                for(int i=sb.length();i<maxWidth;i++){
                    sb.append(" ");
                }
            }

            else{//other general cases or middle justified
                int spaces = (maxWidth-count)/diff;
                int remain = (maxWidth-count)%diff;
                for(int i=index; i<last; i++){
                    sb.append(words[i]);
                    if(i<last-1){
                        for(int j=0;j<=(spaces + (i-index<remain?1:0));j++){
                            sb.append(" ");
                        }
                    }
                }
            }
            //all conditions met, add line to the list
            lines.add(sb.toString());
            //important step, update index to last
            index = last;
        }
        return lines;
    }
    public static void main(String [] args){
        TextJustification t = new TextJustification();
        String [] words1 = {"What","must","be","acknowledgment","shall","be"};
        List<String> result1 = t.fullJustify(words1,16);
        System.out.println(Arrays.asList(result1)); //expected [[What   must   be, acknowledgment  , shall be        ]]


        String [] words2 = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> result2 = t.fullJustify(words2,16);
        System.out.println(Arrays.asList(result2)); // expected [[This    is    an, example  of text, justification.  ]]

        String [] words3 = {"Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"};
        List<String> result3 = t.fullJustify(words3,20);
        System.out.println(Arrays.asList(result3)); // expected [[Science  is  what we, understand      well, enough to explain to, a  computer.  Art is, everything  else  we, do                  ]]


    }

}
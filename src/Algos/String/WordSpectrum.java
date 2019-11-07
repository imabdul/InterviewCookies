package Algos.String;

/**
 * Incorrect Solution at this moment. Didn't see the requirement properly. Current implementation in on the basis ASCII weight of the character
 * before, after, inside we need to determine in such a way that '' < 'A' < 'a' < 'B' < 'b' < .... 'Z' < 'z'.
 * Hackerrank assessment problem
 *
 * input:
     * Apple Pear
     * Aa //first of the sequence of words
     * Aq
     * App
     * Apple
 *
 * Output:
     * before  // as Aa < Apple
     * inside  // as Aq > Apple && Aq < Pear
     * before  // as App < Apple
     * inside  // as Apple == Apple && Apple < Pear
 *
 * input:
 *      EG KtP
 *      Rys
 *      hMo
 *      dLQ
 *      JrF
 *
 * output:
 *      after  // as Rys > KtP
 *      inside  // as hMo > EG && hMo < KtP
 *      before  // as dLQ < EG
 *      inside  // as JrF > EG && hMo < KtP
 *
 */

public class WordSpectrum {
    public String getType(String start, String end, String word){
        char[] startArr = start.toCharArray();
        char[] endArr = end.toCharArray();
        //int len = startArr.length + endArr.length;
        char[] wordArr = word.toCharArray();
        String result = "after";
        for(int i=0;i<wordArr.length; i++){
            if(wordArr[i]-startArr[i]<0) {
                result = "before";
                break;
            }
            if(wordArr[i]-startArr[i]>0) {
                result = "inside";
                break;
            }

        }

        if(wordArr.length<startArr.length && result.equals("after")) return "before";

        for(int i=0;i<wordArr.length; i++){

            if(!result.equals("before") && wordArr[i]-endArr[i]<0) {
                result = "inside";
                break;
            }
            if(wordArr[i]-endArr[i]>0) {
                result = "after";
                break;
            }
        }
        return result;
    }
    public static void main(String[] Args){

        WordSpectrum ws = new WordSpectrum();
        System.out.println(ws.getType("Apple", "Pear", "Aa"));
        System.out.println(ws.getType("Apple", "Pear", "Aq"));
        System.out.println(ws.getType("Apple", "Pear", "App"));
        System.out.println(ws.getType("Apple", "Pear", "Apple"));

        System.out.println(ws.getType("EG", "KtP", "Rys"));
        System.out.println(ws.getType("Apple", "Pear", "hMo"));
        System.out.println(ws.getType("Apple", "Pear", "dLQ"));
        System.out.println(ws.getType("Apple", "Pear", "JrF"));

        //System.out.println("Rys"-"KtP");

    }
}

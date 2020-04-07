package RandomAssessmentProblems;

/**
 * Created by abdul on 4/6/20.
 * Asked in Meraki
 */
import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class RepeatedSubstringOf8Characters {

    public List<String> sol(List<String> input){

        List<String> result = new ArrayList<>();
        for(String s: input){
            //System.out.println("hello");
            result.add( solution(s));
        }

        return result;
    }

    public String solution(String s){
        Set<String> set = new HashSet<>();
        int constant=8;
        for(int i=0; i<s.length()-9;i++){
            String tmp= s.substring(i,i+constant);
            if(set.contains(tmp)){
                return tmp;
            }
            set.add(tmp);
        }

        return "no match found";

    }
    public static void main(String[] Args){
        String csvFile = "~/Documents/Projects/ProblemSolving/InterviewCookies/Book1.xlsx";
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";

        try {

            br = new BufferedReader(new FileReader(csvFile));
            int i=0;
            List<String> input = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                // use comma as separator
                //String[] strArr = line.split(cvsSplitBy);
                //System.out.println("hello");
                input.add(line);
                //System.out.println(i++ + "["+ line + "]");

            }
            RepeatedSubstringOf8Characters rs = new RepeatedSubstringOf8Characters();
            List<String> result = rs.sol(input);
            System.out.println("SIZE---->"+ input.size());
            for(String s: result) {
                if(!s.equals("no match found")){
                    System.out.println("RESULT ------> " + s);
                }
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}

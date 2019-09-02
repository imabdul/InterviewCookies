package OOPDesignProblems;

/**
 * https://leetcode.com/problems/design-log-storage-system/
 *
 * You are given several logs that each log contains a unique id and timestamp.
 * Timestamp is a string that has the following format: Year:Month:Day:Hour:Minute:Second, for example, 2017:01:01:23:59:59.
 * All domains are zero-padded decimal numbers.
 *
 * Design a log storage system to implement the following functions:
 *
 * void Put(int id, string timestamp): Given a log's unique id and timestamp, store the log in your storage system.
 *
 *
 * int[] Retrieve(String start, String end, String granularity): Return the id of logs whose timestamps are within the range from start to end.
 * Start and end all have the same format as timestamp. However, granularity means the time level for consideration.
 * For example, start = "2017:01:01:23:59:59", end = "2017:01:02:23:59:59", granularity = "Day",
 * it means that we need to find the logs within the range from Jan. 1st 2017 to Jan. 2nd 2017.
 *
 * Example 1:
 * put(1, "2017:01:01:23:59:59");
 * put(2, "2017:01:01:22:59:59");
 * put(3, "2016:01:01:00:00:00");
 * retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year"); // return [1,2,3], because you need to return all logs within 2016 and 2017.
 * retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour"); // return [1,2], because you need to return all logs start from 2016:01:01:01 to 2017:01:01:23, where log 3 is left outside the range.
 * Note:
 * There will be at most 300 operations of Put or Retrieve.
 * Year ranges from [2000,2017]. Hour ranges from [00,23].
 * Output for Retrieve has no order required.
 */
import java.util.*;

public class LogSystem {
    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String s1,String s2){
                int s1i = s1.indexOf(' ');
                int s2i = s2.indexOf(' ');
                char s1fc = s1.charAt(s1i+1);
                char s2fc = s2.charAt(s2i+1);

                //handling comparison of digit-logs after identifier
                if(s1fc<='9'){
                    if(s2fc<='9') return 0;
                    return 1;
                }
                if(s2fc<='9') return -1;

                //handling comparison of letter-logs and then identifiers if letter-logs are equal
                int val = s1.substring(s1i+1).compareTo(s2.substring(s2i+1));
                return  val==0 ? s1.substring(0,s1i).compareTo(s2.substring(0,s2i)) : val;
            }
        };

        Arrays.sort(logs,comp);
        return logs;
    }

    public static void main(String[] args) {
        String[] logs= new String[] {"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"};
        LogSystem ls = new LogSystem();
        System.out.println(Arrays.asList(ls.reorderLogFiles(logs))); // expected [g1 act car, a8 act zoo, ab1 off key dog, a1 9 2 3 1, zo4 4 7]
    }
}

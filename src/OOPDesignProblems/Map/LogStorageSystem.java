package OOPDesignProblems.Map;

/**
 * https://leetcode.com/problems/design-log-storage-system/
 *
 * You are given several logs that each log contains a unique id and timestamp. Timestamp is a string that has the following format: Year:Month:Day:Hour:Minute:Second, for example, 2017:01:01:23:59:59. All domains are zero-padded decimal numbers.
 *
 * Design a log storage system to implement the following functions:
 *
 * void Put(int id, string timestamp): Given a log's unique id and timestamp, store the log in your storage system.
 *
 *
 * int[] Retrieve(String start, String end, String granularity): Return the id of logs whose timestamps are within the range from start to end. Start and end all have the same format as timestamp. However, granularity means the time level for consideration. For example, start = "2017:01:01:23:59:59", end = "2017:01:02:23:59:59", granularity = "Day", it means that we need to find the logs within the range from Jan. 1st 2017 to Jan. 2nd 2017.
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
class LogStorageSystem {
    //min and max will allow us in using submap property of Navigable map based on the grain
    String min, max;

    //to store grain and corresponding index
    HashMap<String, Integer> map;
    // to store timestamp and logId. List because multiple Ids can have same timestamp.
    TreeMap<String, List<Integer>> logs;
    public LogStorageSystem() {
        min="2000:01:01:00:00:00";
        max="2099:12:31:23:59:59";
        map = new HashMap<>();
        map.put("Year", 4);
        map.put("Month", 7);
        map.put("Day", 10);
        map.put("Hour", 13);
        map.put("Minute", 16);
        map.put("Second", 19);
        logs = new TreeMap<>();
    }

    public void put(int id, String timestamp) {
        if(!logs.containsKey(timestamp))logs.put(timestamp, new LinkedList<>());
        logs.get(timestamp).add(id);
    }

    public List<Integer> retrieve(String s, String e, String gra) {
        int index = map.get(gra);
        String start= s.substring(0,index)+min.substring(index);
        String end= e.substring(0,index)+max.substring(index);

        //Navigable map will allow us to get the log ids falling in the given range. This has Red-Black Tree implementation. So sorting and filtering will O(N).
        //This could have been implemented just with the help of an ArrayList but Time complexity would have been gone for a toss with O(N). since that requires full list scan to find the ids in the given range.
        NavigableMap<String, List<Integer>> sub = logs.subMap(start, true, end, true);
        List<Integer> result = new LinkedList<>();
        for(Map.Entry<String, List<Integer>> entry: sub.entrySet()){
            result.addAll(entry.getValue());
        }
        return result;
    }

    public static void main(String[] args){
        LogStorageSystem ls = new LogStorageSystem();
        ls.put(1,"2017:01:01:23:59:59");
        ls.put(2,"2017:01:01:22:59:59");
        ls.put(3,"2016:01:01:00:00:00");
        System.out.println(Arrays.asList(ls.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Year"))); //expected [3,2,1]
        System.out.println(Arrays.asList(ls.retrieve("2016:01:01:01:01:01","2017:01:01:23:00:00","Hour"))); //expected [2,1]

       /* String test = "/a/b/c";
        String[] test1 = test.split("/");
        System.out.println(Arrays.asList(test1));*/

    }

}

/**
 * Your LogSystem object will be instantiated and called as such:
 * LogSystem obj = new LogSystem();
 * obj.put(id,timestamp);
 * List<Integer> param_2 = obj.retrieve(s,e,gra);
 */

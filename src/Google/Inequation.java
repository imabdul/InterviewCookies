package Google;

/**
 * Created by tkmab9v on 8/10/20.
 *
 *
 * You are given a list of simple inequations (a>b, c<d). The sign can be either ">" or "<".
 Given a list of inequations, write a function to determine whether there exist feasible solutions to these inequations.

 Each inequation is represented as a tuple of three strings (var1, sign, var2), where var1 and var2 are both variable names and the sign can be either ">" or "<".
 E.g. [("a", "<", "b")]

 public boolean solvable(List<List<String>> inequations) {

 }


 class ListNode {
 char val;
 ListNode next;
 }


 [["a", "<", "b"]] --> True
 [a<b] --> True

 [["a", ">", "b"], ["a", "<", "b"]] --> False
 [a>b, b>a] --> False

 [a<b, b<c, c<a] --> False


 c->b->a
 ^     |
 |-----|

 a<b, c<b, a<d, d<c, c<a

 a<-d<-c<-b<-a
 a<-b

 c<-a


 a<b, c<b, b<d, b<e

 c
 |
 a<-b<-e
 ^
 |
 d


 Hint: Solved by Directed acyclic graph. return false if you find a cycle.
 */
public class Inequation {
}

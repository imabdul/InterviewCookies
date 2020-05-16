package OOPDesignProblems;

/**
 * Faq AMZN Onste
 *
 *  you have following APIs available to use:
 *  List<Person> getFriends(Person p);
 *  List<Item> findPurchasedItems(Person p)
 *
 *  api need to be implemented :-> List<Item> getNextItemsToPurchase(Person p){
 *      //write code here
 *  }
 *
 *  return List<Item> that person is going to buy based on following:
 *      1. items purchased by Friends but not the person himself.
 *      2. result list should have items in the order of most times purchased to least times by friends.
 *
 *
 *      Example:
 *      m -> [c,c,a,a,d]
 *      x -> [a,e,d]
 *      y -> [c,a,e]
 *      z -> [e,d]
 *
 *      z -> m,n (friends)
 *      m -> y (friends) , now since m is friends with y, you need to look for products purchased by y as well, basically you need to consider friends of friends
 *
 *      so when you execute getNextItemsToPurchase(z)
 *
 *      result must be: [a,c]
 *
 *      explanation: since a has count of 4, a will come in result list first and c comes second as it has count of 3
 */

public class NextItemsToPurchase {
}

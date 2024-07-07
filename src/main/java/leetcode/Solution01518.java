package leetcode;

/**
 * 1518. Water Bottles
 * <a href="https://leetcode.com/problems/water-bottles">Web link</a> |
 * Easy
 */

public class Solution01518 {

    public int numWaterBottles(int numBottles, int numExchange) {
        int toDrink = numBottles;
        int consumed = toDrink;
        while (toDrink >= numExchange) {
            int newToDrink = toDrink / numExchange;
            int emptyLeft = toDrink % numExchange;
            consumed += newToDrink;
            toDrink = newToDrink + emptyLeft;
        }
        return consumed;
    }
}

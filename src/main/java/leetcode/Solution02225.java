package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-players-with-zero-or-one-losses/
 * 2225. Find Players With Zero or One Losses
 * Medium
 * You are given an integer array matches where matches[i] = [winneri, loseri] indicates that the player winneri defeated player loseri in a match.
 * <p>
 * Return a list answer of size 2 where:
 * <p>
 * answer[0] is a list of all players that have not lost any matches.
 * answer[1] is a list of all players that have lost exactly one match.
 * The values in the two lists should be returned in increasing order.
 * <p>
 * Note:
 * <p>
 * You should only consider the players that have played at least one match.
 * The testcases will be generated such that no two matches will have the same outcome.
 * <p>
 * Example 1:
 * <p>
 * Input: matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
 * Output: [[1,2,10],[4,5,7,8]]
 * Explanation:
 * Players 1, 2, and 10 have not lost any matches.
 * Players 4, 5, 7, and 8 each have lost one match.
 * Players 3, 6, and 9 each have lost two matches.
 * Thus, answer[0] = [1,2,10] and answer[1] = [4,5,7,8].
 * Example 2:
 * <p>
 * Input: matches = [[2,3],[1,3],[5,4],[6,4]]
 * Output: [[1,2,5,6],[]]
 * Explanation:
 * Players 1, 2, 5, and 6 have not lost any matches.
 * Players 3 and 4 each have lost two matches.
 * Thus, answer[0] = [1,2,5,6] and answer[1] = [].
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= matches.length <= 105
 * matches[i].length == 2
 * 1 <= winneri, loseri <= 105
 * winneri != loseri
 * All matches[i] are unique.
 */
public class Solution02225 {

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Player> matchesMap = new HashMap<>();
        for (int[] match : matches) {
            // winner should be added to the map if not present
            matchesMap.computeIfAbsent(match[0], key -> new Player());

            Player loser = matchesMap.computeIfAbsent(match[1], key -> new Player());
            loser.losses++;
        }

        List<Integer> zeroLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();
        for (Map.Entry<Integer, Player> entry : matchesMap.entrySet()) {
            Player player = entry.getValue();
            if (player.losses == 0) {
                zeroLoss.add(entry.getKey());
            } else if (player.losses == 1) {
                oneLoss.add(entry.getKey());
            }
        }

        zeroLoss.sort(null);
        oneLoss.sort(null);

        return List.of(zeroLoss, oneLoss);
    }

    private static class Player {
        int losses;
    }

}

package leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/find-all-people-with-secret/description/?envType=daily-question&envId=2024-02-24
 * 2092. Find All People With Secret
 * Hard
 */

public class Solution02092 {

    // Time: O(n * log(n))
    // Space: O(n)
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Set<Integer> secrets = new LinkedHashSet<>();
        secrets.add(0);
        secrets.add(firstPerson);

        Map<Integer, Map<Integer, Set<Integer>>> timeToPerson = new HashMap<>();
        for (int[] meeting : meetings) {
            int time = meeting[2];
            int first = meeting[0];
            int second = meeting[1];
            Map<Integer, Set<Integer>> participantsAtTime = timeToPerson.computeIfAbsent(time, k -> new HashMap<>());
            Set<Integer> adjToFirst = participantsAtTime.computeIfAbsent(first, k -> new HashSet<>());
            adjToFirst.add(second);
            Set<Integer> adjToSecond = participantsAtTime.computeIfAbsent(second, k -> new HashSet<>());
            adjToSecond.add(first);
        }

        timeToPerson.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    Set<Integer> visited = new HashSet<>();
                    Map<Integer, Set<Integer>> participantsAtTime = entry.getValue();
                    for (var participantEntry : participantsAtTime.entrySet()) {
                        var sharingUser = participantEntry.getKey();
                        if (secrets.contains(sharingUser)) {
                            dfs(sharingUser, participantsAtTime, secrets, visited);
                        }
                    }
                });

        return new ArrayList<>(secrets);
    }

    private void dfs(Integer sharingUser, Map<Integer, Set<Integer>> participantsAtTime,
                     Set<Integer> secrets, Set<Integer> visited) {
        if (visited.contains(sharingUser)) {
            return;
        }
        visited.add(sharingUser);
        secrets.add(sharingUser);
        Set<Integer> adjParticipants = participantsAtTime.get(sharingUser);
        if (adjParticipants == null) {
            return;
        }
        for (Integer adj : adjParticipants) {
            if (adj.equals(sharingUser)) {
                continue;
            }
            dfs(adj, participantsAtTime, secrets, visited);
        }
    }

}
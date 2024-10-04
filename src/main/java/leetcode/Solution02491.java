package leetcode;

/**
 * 2491. Divide Players Into Teams of Equal Skill
 * <a href="https://leetcode.com/problems/divide-players-into-teams-of-equal-skill">Web link</a> |
 * Medium
 */

public class Solution02491 {

    public long dividePlayers(int[] skill) {
        int[] skillFreq = new int[1001];

        int total = 0;
        for (int x : skill) {
            skillFreq[x]++;
            total += x;
        }
        if (total % (skill.length / 2) != 0) {
            return -1;
        }

        int perTeamSkill = total / (skill.length / 2);
        long chemistry = 0;

        for (int s : skill) {
            int partnerVal = perTeamSkill - s;
            if (skillFreq[partnerVal] == 0) {
                return -1;
            }
            chemistry += (long) s * partnerVal;
            skillFreq[partnerVal]--;
        }

        return chemistry / 2;
    }

}
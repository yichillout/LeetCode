package com.company.amazon.oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountMaximumTeams {

    public static int countMaximumTeams(List<Integer> skill, int teamSize, int maxDiff) {
        Collections.sort(skill);
        int i = 0;
        int count = 0;
        int n = teamSize - 1;
        while (i < skill.size() - teamSize) {
            int s1 = skill.get(i);
            int s2 = skill.get(i + n);
            if (s2 - s1 <= maxDiff) {
                count++;
                i += n;
            } else {
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> skills = new ArrayList<>(Arrays.asList(3, 4, 3, 1, 6, 5));
        System.out.println(countMaximumTeams(skills, 3, 2));
    }
}

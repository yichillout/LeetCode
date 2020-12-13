package com.jasper.math;

import com.annotation.Math;

@Math
public class LC1526_MinimumNumberOfIncrementsOnSubarraysToFormATargetArray {

    public int minNumberOperations(int[] target) {
        int totalOperations = target[0];
        int operationsWeCanReuse = target[0];

        for (int i = 1; i < target.length; ++i) {
            if (target[i] <= operationsWeCanReuse) { // Case #1
                operationsWeCanReuse = target[i];
            } else { // Case #2
                totalOperations += target[i] - operationsWeCanReuse;
                operationsWeCanReuse = target[i];
            }
        }
        return totalOperations;
    }
}

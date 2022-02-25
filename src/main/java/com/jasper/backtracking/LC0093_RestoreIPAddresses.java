package com.jasper.backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC0093_RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        dfs(s, new ArrayList<>(), result);
        return result;
    }

    private void dfs(String remainingStr, List<String> path, List<String> result) {
        if (path.size() > 4) {
            return;
        }

        if (remainingStr.equals("") && path.size() == 4) {
            String str = "";
            for (String p : path) {
                str += p + ".";
            }
            result.add(str.substring(0, str.length() - 1));
            return;
        }

        for (int i = 1; i <= remainingStr.length() && i <= 3; i++) {
            String str = remainingStr.substring(0, i);
            if (str.startsWith("0") && str.length() > 1) {
                continue;
            }
            int num = Integer.parseInt(str);
            if (num >= 0 && num <= 255) {
                path.add(str);
                dfs(remainingStr.substring(i), path, result);
                path.remove(path.size() - 1);
            }
        }
    }
}

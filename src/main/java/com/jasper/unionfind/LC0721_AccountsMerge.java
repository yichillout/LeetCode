package com.jasper.unionfind;

import java.util.*;

public class LC0721_AccountsMerge {

    class UnionFind {

        Map<String, String> parents;

        public UnionFind(Set<String> emailSet) {
            parents = new HashMap<>();

            for (String email : emailSet) {
                parents.put(email, email);
            }
        }

        public String find(String email) {
            if (!parents.get(email).equals(email)) {
                parents.put(email, find(parents.get(email)));
                return parents.get(email);
            }

            return parents.get(email);
        }

        public boolean union(String e1, String e2) {
            String p1 = find(e1);
            String p2 = find(e2);

            if (!p1.equals(p2)) {
                parents.put(p1, p2);
                return true;
            }

            return false;
        }

        public Map<String, List<String>> getMap() {

            Map<String, List<String>> hm = new HashMap<>();

            for (Map.Entry<String, String> entry : parents.entrySet()) {
                String p = find(entry.getKey());
                if (!hm.containsKey(p)) {
                    hm.put(p, new ArrayList<String>());
                    hm.get(p).add(entry.getKey());
                } else {
                    hm.get(p).add(entry.getKey());
                }
            }

            return hm;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, String> e2u = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            String user = account.get(0);

            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (!e2u.containsKey(email)) {
                    e2u.put(email, user);
                }
            }
        }

        UnionFind uf = new UnionFind(e2u.keySet());

        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);

            for (int j = 1; j < account.size() - 1; j++) {
                String email1 = account.get(j);
                String email2 = account.get(j + 1);

                uf.union(email1, email2);
            }
        }

        Map<String, List<String>> resMap = uf.getMap();

        List<List<String>> result = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : resMap.entrySet()) {
            String user = e2u.get(entry.getKey());

            List<String> tmp = new ArrayList<>();
            tmp.add(user);
            tmp.addAll(entry.getValue());

            Collections.sort(tmp);

            result.add(tmp);
        }

        return result;
    }
}

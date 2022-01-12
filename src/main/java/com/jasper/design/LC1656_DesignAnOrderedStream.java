package com.jasper.design;

import java.util.ArrayList;
import java.util.List;

class OrderedStream {
    int curIndex;
    String[] data;

    public OrderedStream(int n) {
        data = new String[n];
    }

    public List<String> insert(int idKey, String value) {
        List<String> res = new ArrayList<>();

        data[idKey - 1] = value;
        while (curIndex < data.length && data[curIndex] != null) {
            res.add(data[curIndex]);
            curIndex++;
        }

        return res;
    }
}

public class LC1656_DesignAnOrderedStream {
}

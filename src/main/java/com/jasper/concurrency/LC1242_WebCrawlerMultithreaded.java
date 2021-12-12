package com.jasper.concurrency;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

interface HtmlParser {
    public List<String> getUrls(String url);
}

public class LC1242_WebCrawlerMultithreaded {

    ExecutorService es;

    public List<String> crawl(String startUrl, HtmlParser htmlParser) {

        es = Executors.newFixedThreadPool(10, r -> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        });


        Set<String> visited = new HashSet();
        Queue<Future<List<String>>> q = new LinkedList();
        String url = startUrl.split("/")[2];
        q.add(es.submit(() -> htmlParser.getUrls(startUrl)));
        visited.add(startUrl);

        try {
            while (true) {
                if (q.isEmpty()) {
                    break;
                }

                List<String> l = q.poll().get().stream().filter(x -> x.contains(url)).collect(Collectors.toList());

                for (String s : l) {
                    if (visited.contains(s)) {
                        continue;
                    }
                    visited.add(s);
                    q.add(es.submit(() -> htmlParser.getUrls(s)));
                }
            }
        } catch (InterruptedException | ExecutionException e) {

        }

        return new ArrayList<>(visited);
    }
}

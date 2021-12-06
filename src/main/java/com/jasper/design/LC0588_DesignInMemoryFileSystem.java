package com.jasper.design;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class FileSystem {

    private FileNode root;

    public FileSystem() {
        root = new FileNode("");
    }

    public List<String> ls(String path) {
        return findNode(path).getList();
    }

    public void mkdir(String path) {
        findNode(path);
    }

    public void addContentToFile(String filePath, String content) {
        findNode(filePath).addContent(content);
    }

    public String readContentFromFile(String filePath) {
        return findNode(filePath).getContent();
    }

    //-- private method section --//
    private FileNode findNode(String path) {
        String[] files = path.split("/");

        FileNode cur = root;
        for (String file : files) {
            if (file.length() == 0) {
                continue;
            }

            cur.children.putIfAbsent(file, new FileNode(file));
            cur = cur.children.get(file);

            if (cur.isFile()) {
                break;
            }
        }

        return cur;
    }

    // Private class
    private class FileNode {
        private TreeMap<String, FileNode> children;
        private StringBuilder file; // content
        private String name;

        public FileNode(String name) {
            children = new TreeMap<>();
            file = new StringBuilder();
            this.name = name;
        }

        public String getContent() {
            return file.toString();
        }

        public String getName() {
            return name;
        }

        public void addContent(String content) {
            file.append(content);
        }

        public boolean isFile() {
            return file.length() > 0;
        }

        public List<String> getList() {
            List<String> list = new ArrayList<>();
            if (isFile()) {
                list.add(getName());
            } else {
                list.addAll(children.keySet());
            }

            return list;
        }
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */

public class LC0588_DesignInMemoryFileSystem {
}

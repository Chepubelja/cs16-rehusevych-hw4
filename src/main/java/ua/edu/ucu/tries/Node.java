package ua.edu.ucu.tries;


import java.util.ArrayList;

class Node {
    private Integer val;
    private static int R = 26;
    private Node[] next = new Node[R];
    private static int a = 97;
    Integer getVal() {
        return val;
    }
    Node get(Node x, String key, Integer depth)
    {
        if (x == null) {
            return null;
        }
        if (depth == key.length()) {
            return x;
        }
        char c = key.charAt(depth);
        return get(x.next[c- a], key, depth + 1);
    }

    Node put(Node x, String key, Integer val, Integer depth)
    {
        if (x == null) {
            x = new Node();
        }
        if (depth == key.length()) {
            x.val = val;
            return x;
        }
        char c = key.charAt(depth);
        if (x.next[c- a] == null) {
            x.next[c- a] = new Node();
        }
        x.next[c- a] = put(x.next[c- a], key, val, depth + 1);
        return x;
    }

    ArrayList<String> dfs(Node x, String tmpWord, ArrayList<String> resList) {
        if (x != null) {
            if (x.getVal() != null && x.getVal() > 0) {
                resList.add(tmpWord);
            }
            for (int i = 0; i < R; i++) {
                dfs(x.next[i], tmpWord + (char) (i+ a), resList);
            }
        }
        return resList;
    }

    int size(Node x, String tmpWord) {
        ArrayList<String> newSize = new ArrayList<>();
        if (x != null)
            if (x.getVal() != null && x.getVal() > 0)
            for (int i = 0; i < R; i++) {
                dfs(x.next[i], tmpWord + (char) (i+ a), newSize);
        }
        return newSize.size();
    }
}


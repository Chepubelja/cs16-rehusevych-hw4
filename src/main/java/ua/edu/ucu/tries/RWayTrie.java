package ua.edu.ucu.tries;

import java.util.ArrayList;

public class RWayTrie implements Trie {
    private Node root;

    public RWayTrie(){
        root = new Node();
    }
    private Integer get(String key)
    {
        Node x = root.get(root, key, 0);
        if (x == null) {
            return null;
        }
        return x.getVal();
    }
    private Integer put(String key, Integer val)
    {
        Node x = root.put(root, key, val, 0);
        if (x == null) {
            return null;
        }
        return x.getVal();
    }
    @Override
    public void add(Tuple tuple) {
        put(tuple.getTerm(), tuple.getTerm().length());
    }

    @Override
    public boolean contains(String word) {
        if ((get(word) == null) || (get(word) != word.length())){
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String word) {
        if (get(word) == null || put(word, 0) != word.length()){
            return false;
        }
        return true;
    }

    @Override
    public Iterable<String> words() {
        ArrayList<String> wordsList = new ArrayList<>();
        root.DFS(root, "", wordsList);
        return wordsList;
    }

    @Override
    public Iterable<String> wordsWithPrefix(String s) {
        ArrayList<String> wordsList = new ArrayList<>();
        root.DFS(root.get(root, s, 0), s, wordsList);
        return wordsList;
    }

    @Override
    public int size() {
        return root.size(root);
    }
}

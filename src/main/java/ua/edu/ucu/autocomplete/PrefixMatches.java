package ua.edu.ucu.autocomplete;

import ua.edu.ucu.tries.Trie;
import ua.edu.ucu.tries.Tuple;

import java.util.ArrayList;

/**
 *
 * @author andrii
 */
public class PrefixMatches {

    private Trie trie;
    PrefixMatches(Trie trie){
        this.trie = trie;
    }

    int load(String... strings) {
        int amount = 0;
        for (String OneString: strings) {
            for (String string: OneString.split(" ")) {
                if (string.length() > 2) {
                    trie.add(new Tuple(string, string.length()));
                    amount++;
                }
            }
        }
        return amount;
    }

    public boolean contains(String word) {
        return trie.contains(word);
    }

    public boolean delete(String word) {
        return trie.delete(word);
    }
    Iterable<String> wordsWithPrefix(String pref) {
        return trie.wordsWithPrefix(pref);
    }

    ArrayList<String> wordsWithPrefix(String pref, int k) {
        ArrayList<String> words = (ArrayList<String>) trie.wordsWithPrefix(pref);
        ArrayList<String> neededWords = new ArrayList<>();
        for (String word : words){
            if (word.length() - pref.length() < k){
                neededWords.add(word);
            }
        }
        return neededWords;
    }

    public int size() {
        return trie.size();
    }
}

package dsaprep;
import java.util.*;

public class TrieImpl {

    TrieNode root;

    static class TrieNode {
        char value;
        boolean wordEnd;
        List<TrieNode> neighbours;

        TrieNode(){}
        TrieNode(char value){
            this.value = value;
            this.neighbours = new ArrayList<>();
        }
        TrieNode containsNeighbour(char value){
//            System.out.println(value +""+ neighbours);
            if(neighbours==null) return null;
            for(TrieNode neighbour : neighbours){
                if(neighbour.value == value) return neighbour;
            }
            return null;
        }
        TrieNode setNeighbour(char value){
            var neighbr = new TrieNode(value);
            if(this.neighbours == null) this.neighbours = new ArrayList<>();
            this.neighbours.add(neighbr);
            return neighbr;
        }
    }


    public TrieImpl() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode ptr = root;
        for(int i = 0; i<word.length(); i++){
            TrieNode wordFound = ptr.containsNeighbour(word.charAt(i));
            if(wordFound == null){
                ptr = ptr.setNeighbour(word.charAt(i));
//                System.out.println(word.charAt(i) + "not found");
            } else {
//                System.out.println(word.charAt(i) + "found");
                ptr = wordFound;
            }
        }

        if(ptr != root) ptr.wordEnd = true;
    }

    public boolean search(String word) {
        TrieNode ptr = root;
        for(int i = 0; i<word.length(); i++){
            TrieNode wordFound = ptr.containsNeighbour(word.charAt(i));
            if(wordFound == null){
                return false;
            } else {
//                System.out.println(word.charAt(i) + "found");
                ptr = wordFound;
            }
        }
        return ptr.wordEnd;

    }

    public boolean startsWith(String prefix) {
        TrieNode ptr = root;
        for(int i = 0; i<prefix.length(); i++){
            TrieNode wordFound = ptr.containsNeighbour(prefix.charAt(i));
            if(wordFound == null){
                return false;
            } else {
//                System.out.println(prefix.charAt(i) + "found");
                ptr = wordFound;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abcdefghijklmnopqrstuvwxyza";

        var t = new TrieImpl();
        t.insert(s);
        t.insert("abcdf");
        System.out.println(t.search("abcdf"));
        System.out.println(t.startsWith("abc"));
        System.out.println(t.search("abcdefghijk"));
        System.out.println(t.startsWith("abcdefghijk"));
    }

}

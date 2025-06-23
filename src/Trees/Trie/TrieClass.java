package Trees.Trie;

public class TrieClass {

    private TrieNode root;

    public TrieClass() {
        root = new TrieNode();
    }

    // Insert a word into Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';  // Convert 'a'-'z' to index 0-25
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    // Search for a word in the Trie
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isEndOfWord;
    }

    public static void main(String[] args) {
        TrieClass trie = new TrieClass();
        trie.insert("apple");


        trie.search("apple");
    }
}

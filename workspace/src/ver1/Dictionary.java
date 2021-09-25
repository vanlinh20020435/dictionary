package ver1;

import java.util.*;

public class Dictionary {
    List<Word> library = new ArrayList<>();

    public List<Word> getLibrary() {
        return library;
    }

    public void addWord(Word word) {
        library.add(word);
    }
}

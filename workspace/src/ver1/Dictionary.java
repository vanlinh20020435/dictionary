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
    public void removeWord(int index) {
        library.remove(index);
    }

    public void editWord(int index,Word word){
        library.set(index,word);
    }
}

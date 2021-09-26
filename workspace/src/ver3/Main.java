package ver3;

import ver1.Word;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DictionaryCommandline dictionaryCommandline=new DictionaryCommandline();
        List<Word> library=dictionaryCommandline.dictionarySearcher("he");
        for(Word word:library){
            System.out.println(word.getWord_target() + " is: " +word.getWord_explain());
        }
    }
}

package ver1;

import java.util.*;
import java.io.*;

public class DictionaryManagement {
    //Thêm từ mới
    public Dictionary insertFromCommandline() {
        Dictionary dictionary = new Dictionary();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String word_target = sc.nextLine();
            String word_explain = sc.nextLine();
            dictionary.addWord(new Word(word_target, word_explain));
        }
        return dictionary;
    }
}


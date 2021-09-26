package ver3;

import ver1.Dictionary;
import ver1.Word;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class DictionaryManagement {
    private Dictionary dictionary = new Dictionary();

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    /**
     * Thêm từ mới.
     */
    public void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String word_target = sc.nextLine();
            String word_explain = sc.nextLine();
            dictionary.addWord(new Word(word_target, word_explain));
        }
    }

    /**
     * Thêm từ mới vào file.
     */
    public void insertFromFile() {
        if (dictionary.getLibrary().isEmpty()) {
            loadFromFile();                     //kiểm tra xem đã tải từ điển hay chưa.
        }
        File file = new File("data/dictionaries.txt");
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file, true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            Scanner sc = new Scanner(System.in);
            System.out.println("Số từ bạn muốn nhập: ");
            int n = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < n; i++) {
                String word_target = sc.nextLine();
                String word_explain = sc.nextLine();
                if (dictionaryLookup(word_target) != -1) {
                    System.out.println("Từ này đã có trong từ điển");
                    continue;
                }
                try {
                    outputStreamWriter.write(word_target);
                    outputStreamWriter.write("\t");
                    outputStreamWriter.write(word_explain);
                    outputStreamWriter.write("\n");
                    dictionary.addWord(new Word(word_target, word_explain));
                } catch (IOException e) {
                    System.out.println("word is null");
                }
            }

            try {
                outputStreamWriter.flush();
            } catch (IOException e) {
                System.out.println("file is null");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Tải danh sách từ từ file.
     */
    public void loadFromFile() {
        File file = new File("data/dictionaries.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String word_target = sc.next();
                String word_explain = sc.nextLine();
                dictionary.addWord(new Word(word_target, word_explain));
            }
        } catch (FileNotFoundException e) {
            System.out.println("file is null");
        }
    }

    /**
     * Tìm từ.
     */
    public int dictionaryLookup(String word) {
        if (dictionary.getLibrary().isEmpty()) {
            loadFromFile();                     //kiểm tra xem đã tải từ điển hay chưa.
        }
        List<Word> library = dictionary.getLibrary();
        for (Word w : library) {
            if (word.equals(w.getWord_target())) {
                return library.indexOf(w);
            }
        }
        return -1;
    }

    /**
     * Xóa từ.
     */
    public void dictionaryRemove(String word){
        int index=dictionaryLookup(word);
        if(index==-1) System.out.println("Không có từ này trong từ điển");
        else dictionary.removeWord(index);
    }

    /**
     * Sửa từ.
     */
    public void dictionaryEdit(Word word){
        int index=dictionaryLookup(word.getWord_target());
        if(index==-1) System.out.println("Không có từ này trong từ điển");
        else dictionary.editWord(index,word);
    }

    /**
     * Xuất dữ liệu trong từ điển ra file.
     */
    public void dictionaryExportToFile(){
        if (dictionary.getLibrary().isEmpty()) {
            loadFromFile();                     //kiểm tra xem đã tải từ điển hay chưa.
        }
        File file = new File("data/dictionaries.txt");
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            for (Word word:dictionary.getLibrary()) {
                try {
                    outputStreamWriter.write(word.getWord_target());
                    outputStreamWriter.write("\t");
                    outputStreamWriter.write(word.getWord_explain());
                    outputStreamWriter.write("\n");
                } catch (IOException e) {
                    System.out.println("word is null");
                }
            }

            try {
                outputStreamWriter.flush();
            } catch (IOException e) {
                System.out.println("file is null");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}


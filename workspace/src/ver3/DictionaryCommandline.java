package ver3;

import ver1.Word;

import java.util.ArrayList;
import java.util.List;

public class DictionaryCommandline {
    private DictionaryManagement dictionaryManagement = new DictionaryManagement();

    public DictionaryManagement getDictionaryManagement() {
        return dictionaryManagement;
    }

    //hiện danh sách từ
    public void showAllWords() {
        if (dictionaryManagement.getDictionary().getLibrary().isEmpty()) {
            dictionaryManagement.loadFromFile();                     //kiểm tra xem đã tải từ điển hay chưa.
        }
        List<Word> library = dictionaryManagement.getDictionary().getLibrary();
        System.out.println("No\t| English\t\t| Vietnamese");
        for (int i = 0; i < library.size(); i++) {
            System.out.println((i + 1) + "\t| " + library.get(i).getWord_target() + "\t\t\t| " + library.get(i).getWord_explain());
        }
    }

    /**
     * Ktra từ có bắt đầu bằng chuỗi.
     */
    public boolean checkWordStartBy(String word,String s){
        if(word.startsWith(s)) return true;
        else return false;
    }

    public void dictionaryBasic() {
        dictionaryManagement.insertFromCommandline(); //nhập danh sách từ
        showAllWords();//hiện danh sách từ
    }

    public void dictionaryAdvanced() {
        dictionaryManagement.insertFromFile(); //nhap tu moi vao file
        showAllWords();
        int index = dictionaryManagement.dictionaryLookup("hello");
        if(index==-1){
            System.out.println("Từ này không có trong từ điển");
            return;
        }
        Word word = dictionaryManagement.getDictionary().getLibrary().get(index);
        System.out.println(word.getWord_target() + " is: " +word.getWord_explain());
    }

    /**
     * Tìm các từ được bắt đầu bằng 1 chuỗi s.
     */
    public List<Word> dictionarySearcher(String s){
        if (dictionaryManagement.getDictionary().getLibrary().isEmpty()) {
            dictionaryManagement.loadFromFile();                     //kiểm tra xem đã tải từ điển hay chưa.
        }
        List<Word> library = new ArrayList<>();
        for(Word word:dictionaryManagement.getDictionary().getLibrary()){
            if(checkWordStartBy(word.getWord_target(),s)){
                library.add(word);
            }
        }
        return library;
    }

}

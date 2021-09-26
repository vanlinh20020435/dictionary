package ver3;

import ver1.Word;

import java.util.List;

public class DictionaryCommandline {
    private DictionaryManagement dictionaryManagement = new DictionaryManagement();
    //hiện danh sách từ
    public void showAllWords() {
        if(dictionaryManagement.getDictionary().getLibrary().size()==0){
            dictionaryManagement.loadFromFile();                     //kiểm tra xem đã tải từ điển hay chưa.
        }
        List<Word> library = dictionaryManagement.getDictionary().getLibrary();
        System.out.println("No\t| English\t\t| Vietnamese");
        for (int i = 0; i < library.size(); i++) {
            System.out.println((i + 1) + "\t| " + library.get(i).getWord_target() + "\t\t\t| " + library.get(i).getWord_explain());
        }
    }

    public void dictionaryBasic() {
        dictionaryManagement.insertFromCommandline(); //nhập danh sách từ
        showAllWords();//hiện danh sách từ
    }

    public void  dictionaryAdvanced() {
        dictionaryManagement.insertFromFile(); //nhap tu moi vao file
        showAllWords();
        dictionaryManagement.dictionaryLookup("hello");
    }
}

package ver2;

import ver1.Word;

import java.util.List;

public class DictionaryCommandline {
    private DictionaryManagement dictionaryManagement = new DictionaryManagement();

    //hiện danh sách từ
    public void showAllWords() {
        if (dictionaryManagement.getDictionary().getLibrary().isEmpty()) {
            dictionaryManagement.loadFromFile();                     //kiểm tra xem đã tải từ điển hay chưa.
        }
        List<Word> library = dictionaryManagement.getDictionary().getLibrary();
        System.out.format("%-5s %-2s %-15s %2s %-15s\n", "NO", "|", "English","|", "Vietnamese");
        for (int i = 0; i < library.size(); i++) {
            System.out.format("%-5s %-2s %-15s %2s %-15s\n", (i + 1), "|", library.get(i).getWord_target(),"|", library.get(i).getWord_explain());
        }
    }

    public void dictionaryBasic() {
        dictionaryManagement.insertFromCommandline(); //nhập danh sách từ
        showAllWords();//hiện danh sách từ
    }

    public void dictionaryAdvanced() {
        dictionaryManagement.insertFromFile(); //nhap tu moi vao file
        showAllWords();
        int index = dictionaryManagement.dictionaryLookup("hello");
        Word word = dictionaryManagement.getDictionary().getLibrary().get(index);
        System.out.println(word.getWord_target() + " is: "+word.getWord_explain());
    }
}

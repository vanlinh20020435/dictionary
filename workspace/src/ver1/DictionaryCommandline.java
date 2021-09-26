package ver1;

import java.util.List;

public class DictionaryCommandline {
    //hiện danh sách từ
    public void showAllWords(Dictionary dictionary) {
        List<Word> library = dictionary.getLibrary();
        System.out.format("%-5s %-2s %-15s %2s %-15s\n", "NO", "|", "English","|", "Vietnamese");
        for (int i = 0; i < library.size(); i++) {
            System.out.format("%-5s %-2s %-15s %2s %-15s\n", (i + 1), "|", library.get(i).getWord_target(),"|", library.get(i).getWord_explain());
        }
    }

    public void dictionaryBasic() {
        DictionaryManagement dictionaryManagement = new DictionaryManagement();
        Dictionary dictionary = dictionaryManagement.insertFromCommandline(); //nhập danh sách từ
        showAllWords(dictionary);//hiện danh sách từ
    }
}

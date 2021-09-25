package ver1;

import java.util.List;

public class DictionaryCommandline {
    //hiện danh sách từ
    public void showAllWords(Dictionary dictionary) {
        List<Word> library = dictionary.getLibrary();
        System.out.println("No\t| English\t\t| Vietnamese");
        for (int i = 0; i < library.size(); i++) {
            System.out.println((i + 1) + "\t| " + library.get(i).getWord_target() + "\t\t\t| " + library.get(i).getWord_explain());
        }
    }

    public void dictionaryBasic() {
        DictionaryManagement dictionaryManagement = new DictionaryManagement();
        Dictionary dictionary = dictionaryManagement.insertFromCommandline(); //nhập danh sách từ
        showAllWords(dictionary);//hiện danh sách từ
    }
}

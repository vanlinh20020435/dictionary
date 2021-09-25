package ver1;

public class Word {
    private String word_target; //từ mới
    private String word_explain; //giải nghĩa

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    public String getWord_target() {
        return word_target;
    }

    public String getWord_explain() {
        return word_explain;
    }

    /**
     * hàm khởi tạo.
     */
    public Word() {
        word_target = "";
        word_explain = "";
    }

    /**
     * hàm khởi tạo 1 biến.
     */
    public Word(Word s) {
        word_target = "";
        word_explain = "";
    }

    /**
     * hàm khởi tạo 2 biến.
     */
    public Word(String word_target, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
    }
}

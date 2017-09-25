import java.util.Comparator;

public class LineStorage {

    private String line;
    private long line_id;
    private static long idCounter = 0;

    public LineStorage(String pSentence) {
        line_id = idCounter++;
        line = pSentence;
    }

    public long getLine_id() {
        return line_id;
    }

    public void setLine_id(int line_id) {
        this.line_id = line_id;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

}

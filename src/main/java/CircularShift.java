import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CircularShift implements ICircularShift {

    private  List<String> lines;
    private LineStorage lineStorage;

    public CircularShift(LineStorage pLineStorage)
    {
        this.lineStorage = pLineStorage;
    }

    @Override
    public List<String> getLines() {
        return lines;
    }


    @Override
    public void generateCircularShift()
    {
        lines = new ArrayList();

        String upcase = lineStorage.getLine().toUpperCase().trim();
        List<String> words = new ArrayList(Arrays.asList(upcase.split(" ")));

        int lastIndex = words.size() - 1;

        lines.add(upcase);
        for (int i = 0; i < lastIndex ; ++i) {
            words.add(lastIndex,words.remove(0));
            lines.add(arrToString(words));
        }
    }

    private static String arrToString(List<String> arr){
        StringBuilder builder = new StringBuilder();
        for (String node: arr) {
            builder.append(node);
            builder.append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

}

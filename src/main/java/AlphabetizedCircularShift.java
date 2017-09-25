import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AlphabetizedCircularShift implements IAlphabetizedCircularShift {

    private static List<String> lines= new ArrayList<>();

    private static List<String> sorted_lines = new ArrayList();

    public AlphabetizedCircularShift(List<String> pLines) {
        lines.addAll(pLines);
    }

    @Override
    public void generateAlphabetizedCircularShift(){
        Collections.sort(lines);

    }

 /**   private List<String> merge(List<String> sorted, List<String> new_sorted) {
        List<String> whole_sorted = new ArrayList<>();
        int sortedIndex = 0;
        int nSortedIndex = 0;
        int wholeIndex = 0;

        while (sortedIndex < sorted.size() && nSortedIndex < new_sorted.size()) {
            if ( (sorted.get(sortedIndex).compareTo(new_sorted.get(nSortedIndex))) < 0) {
                whole_sorted.set(wholeIndex, sorted.get(sortedIndex));
                sortedIndex++;
            } else {
                whole_sorted.set(wholeIndex, new_sorted.get(nSortedIndex));
                nSortedIndex++;
            }
            wholeIndex++;
        }

        List<String> rest;
        int restIndex;
        if (sortedIndex >= sorted.size()) {
            rest = new_sorted;
            restIndex = nSortedIndex;
        } else {
            rest = sorted;
            restIndex = sortedIndex;
        }

        for (int i=restIndex; i<rest.size(); i++) {
            whole_sorted.set(wholeIndex, rest.get(i));
            wholeIndex++;
        }
        return whole_sorted;
    }**/
    @Override
    public List<String> getLines() {
        return lines;
    }

    @Override
    public void reset() {
        lines = new ArrayList<>();
    }
}

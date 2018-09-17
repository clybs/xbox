package xbox;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/**
 *
 * @author cliburnsolano
 */
public class Screen {

    /**
     *
     * @param boxContents
     */
    public void display(List<ArrayList<String>> boxContents) {
        boxContents.stream().map((ArrayList<String> row) -> {
            for (Iterator<String> iteratorCol = row.iterator(); iteratorCol.hasNext();) {
                System.out.print(iteratorCol.next());
            }
            return row;
        }).forEachOrdered((_item) -> System.out.println(""));
    }
}

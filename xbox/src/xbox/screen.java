package xbox;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author cliburnsolano
 */
public class screen {

    public void display(List<ArrayList<String>> boxContents) {
        boxContents.stream().map((row) -> {
            for (Iterator<String> iteratorCol = row.iterator(); iteratorCol.hasNext();) {
                System.out.print(iteratorCol.next());
            }
            return row;
        }).forEachOrdered((_item) -> {
            System.out.println("");
        });
    }
}

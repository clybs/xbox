package xbox;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cliburnsolano
 */
public class box {

    private int columns;
    private int rows;
    private String spacer = "x";
    private String borderTopBottom = "-";
    private String borderSides = "|";
    
    private final int MIN_COLUMNS = 3;
    private final int MIN_ROWS = 3;

    public String getBorderTopBottom() {
        return borderTopBottom;
    }

    public void setBorderTopBottom(String borderTopBottom) {
        this.borderTopBottom = borderTopBottom;
    }

    public String getBorderSides() {
        return borderSides;
    }

    public void setBorderSides(String borderSides) {
        this.borderSides = borderSides;
    }

    public box(int columns, int rows, String spacer) {
        this.columns = columns;
        this.rows = rows;
        this.spacer = spacer;
        
        // Check if within boundaries
        if (this.rows < MIN_ROWS) {
            this.rows = MIN_ROWS;
        }
        if (this.columns < MIN_COLUMNS) {
            this.columns = MIN_COLUMNS;
        }
    }

    public String getSpacer() {
        return spacer;
    }

    public void setSpacer(String spacer) {
        this.spacer = spacer;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
        
        // Check if within boundaries
        if (this.columns < MIN_COLUMNS) {
            this.columns = MIN_COLUMNS;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
        
        // Check if within boundaries
        if (this.rows < MIN_ROWS) {
            this.rows = MIN_ROWS;
        }
    }

    private List<ArrayList<String>> createBorder(List<ArrayList<String>> boxContents) {
        ArrayList<String> topBottom = new ArrayList<>();

        // Create the top bottom borders
        for (int i = 0; i < columns + 2; i++) {
            topBottom.add(borderTopBottom);
        }

        // Now we add the borders
        for (int i = 0; i < rows; i++) {
            boxContents.get(i).add(0, borderSides);
            boxContents.get(i).add(boxContents.get(i).size(), borderSides);
        }

        // Now add the top and bottom borders
        boxContents.add(0, topBottom);
        boxContents.add(boxContents.size(), topBottom);

        return boxContents;
    }

    public List<ArrayList<String>> getBox() {
        // Create the box
        List<ArrayList<String>> boxRow = new ArrayList<>();

        for (int j = 0; j < rows; j++) {
            ArrayList<String> boxCol = new ArrayList<>();

            for (int i = 0; i < columns; i++) {
                boxCol.add(spacer);
            }

            boxRow.add(boxCol);
        }

        // Create the border
        return createBorder(boxRow);
    }

    @Override
    public String toString() {
        return "box{" + "columns=" + columns + ", rows=" + rows + ", spacer=" + spacer + ", borderTopBottom=" + borderTopBottom + ", borderSides=" + borderSides + '}';
    }
}

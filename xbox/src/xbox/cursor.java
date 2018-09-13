package xbox;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author cliburnsolano
 */
public class cursor {

    private boolean borderless = true;
    private String pointer = "X";
    private int xPos;
    private int yPos;
    private int xMax;
    private int yMax;
    private List<ArrayList<String>> boxContents;

    public cursor(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public boolean isBorderless() {
        return borderless;
    }

    public void setBorderless(boolean borderless) {
        this.borderless = borderless;
    }

    public void setBoxContents(List<ArrayList<String>> boxContents) {
        this.boxContents = boxContents;
    }

    public String getPointer() {
        return pointer;
    }

    public void setPointer(String pointer) {
        this.pointer = pointer;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos += xPos;

        // Check if borderless
        if (borderless) {
            if (this.xPos < 0) {
                this.xPos = xMax - 1;
            }
            if (this.xPos > xMax - 1) {
                this.xPos = 0;
            }
        } else {
            if (this.xPos < 0) {
                this.xPos = 0;
            }
            if (this.xPos > xMax - 1) {
                this.xPos = xMax - 1;
            }
        }
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos += yPos;

        // Check if borderless
        if (borderless) {
            if (this.yPos < 0) {
                this.yPos = yMax - 1;
            }
            if (this.yPos > yMax - 1) {
                this.yPos = 0;
            }
        } else {
            if (this.yPos < 0) {
                this.yPos = 0;
            }
            if (this.yPos > yMax - 1) {
                this.yPos = yMax - 1;
            }
        }
    }

    public int getxMax() {
        return xMax;
    }

    public void setxMax(int xMax) {
        this.xMax = xMax;
    }

    public int getyMax() {
        return yMax;
    }

    public void setyMax(int yMax) {
        this.yMax = yMax;
    }

    private boolean isNotTouchingBorders(int rowIndex, int colIndex, Iterator<String> iteratorCol, ArrayList<String> row) {
        boolean sameX = colIndex == (xPos + 1);
        boolean sameY = rowIndex == (yPos + 1);
        boolean notTopBorder = rowIndex != 0;
        boolean notBottomBorder = rowIndex != row.size() - 1;
        boolean notLeftBorder = colIndex != 0;
        boolean notRightBorder = iteratorCol.hasNext();

        return sameX && sameY && notTopBorder && notBottomBorder && notLeftBorder && notRightBorder;
    }

    public List<ArrayList<String>> getBoxContents() {
        // Place the x in the box
        int i = 0;

        for (ArrayList<String> row : boxContents) {
            int j = 0;

            for (Iterator<String> iteratorCol = row.iterator(); iteratorCol.hasNext();) {
                iteratorCol.next();

                // Check if not touching borders
                boolean isNotTouchingBorder = isNotTouchingBorders(i, j, iteratorCol, row);
                if (isNotTouchingBorder) {
                    row.set(j, pointer);
                }

                j++;
            }
            i++;
        }

        return boxContents;
    }
}

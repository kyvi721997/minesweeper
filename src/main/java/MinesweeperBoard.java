import java.util.LinkedList;
import java.util.List;

// o(n log n)

/**
 1. Rule of game:
 The user has to find the mines using numeric hints that indicate how many mines are directly adjacent (horizontally, vertically, diagonally) to a square.
 2. Decomposed from the rule:
    2.1 With current position, we have indicated the next and previous row, column is the same.
    2.2 Default condition is array have size >= 0 and value in the index have length > 0.
    2.3 Loop 2 iteration with row and column to get current position and check current is not mine, we can use rule 2.1.
 3. Test:
    - First: I do not parse List<String> to List<List<String> and use substring.
    - Second: Parse List<String> to List<List<String>> and use replace.
 **/
class MinesweeperBoard {
    List<String> inputBoard;
    private int ROWS = 0;
    private int COLS = 0;
    private final String MINE_CHAR = "*";

    public MinesweeperBoard(List<String> input) {
        this.inputBoard = new LinkedList<>(input);
    }

    public List<String> withNumbers() {
        long start = System.currentTimeMillis();
        //First check condition
        if (this.inputBoard.size() > 0) {
            getWidthHeight();
            // Case just one element
            findMines();
        }
        long end = System.currentTimeMillis();
        System.out.println("Time exe: " + (end - start));
        return this.inputBoard;
    }

    void getWidthHeight() {
        System.out.println("BOARD GAME INPUT: " + this.inputBoard);
        this.ROWS = this.inputBoard.size();
        this.COLS = this.inputBoard.get(this.inputBoard.size() - 1).length();
        System.out.println("BOARD ROW: " + this.ROWS);
        System.out.println("BOARD HEIGHT: " + this.COLS);
    }

    void findMines() {
        for (int row = 0; row < this.ROWS; row++) {
            for (int col = 0; col < this.COLS; col++) {
                if (!isMine(row, col)) {
                    String original = this.inputBoard.get(row);
                    int numMine = this.countNearMines(row, col);
                    if (numMine == 0) {
                        continue;
                    }

                    String value = original.substring(0, col) + numMine;
                    if (col + 1 < this.COLS) {
                        value += original.substring(col + 1, this.COLS);
                    }
                    this.inputBoard.set(row, original.replace(original, value));
                }
            }
        }
    }

    boolean checkValueIsValidInArray(int row, int col){
        return (row >= 0) && (row < this.ROWS) && (col >= 0) && (col < this.COLS);
    }

    int countNearMines(int row, int col) {

        int count = 0;

        int preRow = row - 1;
        int nextRow = row + 1;

        int preCol = col - 1;
        int nextCol = col + 1;

        // Check with previous Row and current column
        if (checkValueIsValidInArray(preRow, col) && isMine(preRow, col)) count++;

        // Check with previous Row and next column
        if (checkValueIsValidInArray(preRow, nextCol) && isMine(preRow, nextCol)) count++;

        // Check with previous Row and previous column
        if (checkValueIsValidInArray(preRow, preCol) && isMine(preRow, preCol)) count++;

        // Check with next Row and current column
        if (checkValueIsValidInArray(nextRow, col) && isMine(nextRow, col)) count++;

        // Check with next Row and next column
        if (checkValueIsValidInArray(nextRow, nextCol) && isMine(nextRow, nextCol)) count++;

        // Check with next Row and previous column
        if (checkValueIsValidInArray(nextRow, preCol) && isMine(nextRow, preCol)) count++;

        // Check with current row and next column
        if (checkValueIsValidInArray(row, nextCol) && isMine(row, nextCol)) count++;

        // Check with current row and previous column
        if (checkValueIsValidInArray(row, preCol) && isMine(row, preCol)) count++;

        return count;
    }

    boolean isMine(int row, int col) {
        return Character.toString(this.inputBoard.get(row).charAt(col)).equals(this.MINE_CHAR);
    }
}

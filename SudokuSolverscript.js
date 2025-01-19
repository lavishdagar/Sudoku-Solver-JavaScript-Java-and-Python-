const solve = (board) => {
    let row = -1;
    let col = -1;
    let isEmpty = true;

    // Find an empty cell
    for (let i = 0; i < board.length; i++) {
        for (let j = 0; j < board[i].length; j++) {
            if (board[i][j] === 0) {
                row = i;
                col = j;
                isEmpty = false;
                break;
            }
        }
        if (!isEmpty) {
            break;
        }
    }

    // Base case: no empty cells
    if (isEmpty) {
        return true;
    }

    // Try numbers 1 through 9
    for (let num = 1; num <= 9; num++) {
        if (isSafe(board, row, col, num)) {
            board[row][col] = num;
            if (solve(board)) {
                return true;
            }
            board[row][col] = 0; // Backtrack
        }
    }

    return false; // Trigger backtracking
};

const isSafe = (board, row, col, num) => {

    for (let x = 0; x < board.length; x++) {
        if (board[row][x] === num) {
            return false;
        }
    }


    for (let x = 0; x < board.length; x++) {
        if (board[x][col] === num) {
            return false;
        }
    }


    let sqrt = Math.sqrt(board.length);
    let rowStart = row - (row % sqrt);
    let colStart = col - (col % sqrt);

    for (let i = rowStart; i < rowStart + sqrt; i++) {
        for (let j = colStart; j < colStart + sqrt; j++) {
            if (board[i][j] === num) {
                return false;
            }
        }
    }

    return true;
};

let board =[[3,0,6,5,0,8,4,0,0],
[5,2,0,0,0,0,0,0,0],
[0,8,7,0,0,0,0,3,1],
[0,0,3,0,0,0,0,6,8],
[0,0,0,0,4,0,0,0,0],
[0,0,0,0,1,0,0,0,0],
[0,0,1,0,0,0,7,8,0],
[0,0,0,0,0,0,0,0,0],
[0,0,0,0,0,0,0,0,0]];
if (solve(board)) {
    console.log(board);
} else {
    console.log("No solution exists");
}

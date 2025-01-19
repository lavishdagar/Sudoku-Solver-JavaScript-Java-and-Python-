import math
board=[[3,0,6,5,0,8,4,0,0],
[5,2,0,0,0,0,0,0,0],
[0,8,7,0,0,0,0,3,1],
[0,0,3,0,0,0,0,6,8],
[0,0,0,0,4,0,0,0,0],
[0,0,0,0,1,0,0,0,0],
[0,0,1,0,0,0,7,8,0],
[0,0,0,0,0,0,0,0,0],
[0,0,0,0,0,0,0,0,0]];


def solve(board):
    row=-1
    col=-1
    empty=False
    for i in range(len(board)):
        for j in range(len(board)):
            if board[i][j]==0:
                row=i
                col=j
                empty=True
                break
        if empty:
            break
    if not empty:
        return True
    for target in range(1,10):
        if isSafe(board,row,col,target):
            board[row][col]=target
            if solve(board):
                return True
        else:
            board[row][col]=0
    return False
def isSafe(board,row,col,target):
    for i in range(9):
        if board[row][i]==target or board[i][col]==target:
            return False
    sqrt=int(math.sqrt(len(board)))
    rowstart=row-(row%sqrt)
    colend=col-(col%sqrt)
    for i in range(sqrt):
        for j in range(sqrt):
            if board[i+rowstart][j+colend]==target:
                return False    
    return True
if solve(board):
    for i in range(len(board)):
        for j in range(len(board)):
            print(board[i][j],end=" ")
        print()
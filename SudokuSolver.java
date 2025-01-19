package index7;

public class SudokuSolver{
    public static void main(String[] args){
        int[][] board={{3,0,6,5,0,8,4,0,0},
                       {5,2,0,0,0,0,0,0,0},
                       {0,8,7,0,0,0,0,3,1},
                       {0,0,3,0,0,0,0,6,8},
                       {0,0,0,0,4,0,0,0,0},
                       {0,0,0,0,1,0,0,0,0},
                       {0,0,1,0,0,0,7,8,0},
                       {0,0,0,0,0,0,0,0,0},
                       {0,0,0,0,0,0,0,0,0}};
        if(solve(board)){
            for(int i=0;i<board.length;i++){
                for(int j=0;j<board.length;j++){
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("No solution exists");
        }

    }
    static boolean solve(int[][] board){
        int n=board.length;
        int row=-1;
        int col=-1;
        boolean emptyLeft=true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
               if(board[i][j]==0){
                 row=i;
                 col=j;
                emptyLeft=false;
                    break;
                }
            }
            if(!emptyLeft){
                break;
            }

        }
        if(emptyLeft){
            return true;
        }
        for(int num=1;num<=n;num++){
            if(isSafe(board,row,col,num)){
                board[row][col]=num;
                if(solve(board)){
                    return true;
                }
                else{
                    board[row][col]=0;
                }
            }
        }
        return false;
    }

    

    static boolean isSafe(int[][] board,int row,int col,int num){
        for(int i=0;i<board.length;i++){
            if(board[row][col]==num){
                return false;
            }
            
        }
        for(int[] nums:board){
            if(nums[col]==num){
                return false;
            }  
        }
        int sqrt=(int)(Math.sqrt(board.length));
        int start=row-row%sqrt;
        int end=col-col%sqrt;
        for(int i=start;i<start+sqrt;i++){
            for(int j=end;j<end+sqrt;j++){
                if(board[i][j]==num){
                    return false;
                }
            }
        }
        return true;
    }

}
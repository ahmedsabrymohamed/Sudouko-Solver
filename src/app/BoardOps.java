package app;
import java.util.ArrayList;

class BoardOps implements BoardBulider {

  
   
   
  

    public void fillBoard(ArrayList<Integer> data,int board [][][][]) throws DataFitException {
        int indx = 0;
        if (data.size() > 81) {
            throw new DataFitException(DataFitException.ExceptionType.LARGER);
        } else if (data.size() < 81) {
            throw new DataFitException(DataFitException.ExceptionType.SMALLER);
        }
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                for (int k = 0; k < 3; k++)
                    for (int l = 0; l < 3; l++) {
                        board[i][k][j][l] = data.get(indx);
                        indx++;
                    }


    }

  
   
    protected boolean checkSet(int board [][][][],short[] set,int ...indces){
        if(board[indces[0]][indces[1]][indces[2]][indces[3]]==0)
        return false;
        if (set[board[indces[0]][indces[1]][indces[2]][indces[3]] - 1] > 0)
            return true;
        else{

        }
        set[board[indces[0]][indces[1]][indces[2]][indces[3]] - 1]++;
        return false;
    }
    protected void createState(short[] row,short[] col,short[] block){
       
    }

    public boolean checkGridOnce(int board [][][][],BoardState bState) {
        short[] row;
        short[] col;
        short[] block;
        bState=new BoardState();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                row = new short[9];
                col = new short[9];
                block = new short[9];
                for (int k = 0; k < 3; k++)
                    for (int l = 0; l < 3; l++) {
                       if(checkSet(board, row, i,k,j,l)||checkSet(board, col, k,i,l,j)||
                       checkSet(board, block, i,j,k,l))
                       return false;
                      
                        
                            
                    }
            }

        return true;
    }

}
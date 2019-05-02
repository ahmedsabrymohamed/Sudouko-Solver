package app;
import java.util.ArrayList;
interface BoardBulider{
    
    boolean checkGridOnce(int board [][][][]);
    void fillBoard(ArrayList<Integer> data,int board [][][][])throws DataFitException;
    
}
package app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static java.lang.System.out;
import java.util.ArrayList;

public class App {

    static final String IN_PATH = "/home/los/Desktop/java/Pro1/src/app/SudoukoIN.txt";
    static final String OUT_PATH = "/home/los/Desktop/java/Pro1/src/app/SudoukOUT.txt";

    public static void main(String[] args) {

        BoardBulider bb = new BoardOps();
        Board board = new Board();

        try (FileInputStream fin = new FileInputStream(IN_PATH);
                FileOutputStream fou = new FileOutputStream(OUT_PATH);) {
            ArrayList<Integer> data = new ArrayList<>();
            int ch;
            do {
                 ch=fin.read();
                if(ch>='0'&&ch<='9'){
                    data.add((ch - '0'));
                }
                
            } while (ch  > -1);
            if(data.size()>0)
            bb.fillBoard(data, board.getBoard());
            display(board.getBoard(), fou);
            out.println((bb.checkGridOnce(board.getBoard()) ? "CORRECT" : "WRONG"));
           
        } catch (Exception e) {
            
            e.printStackTrace();
        }

    }

    static void display(int grid[][][][], FileOutputStream fou) throws IOException {

        fou.write(("-------------------------------------\n").getBytes());
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {

                fou.write(("| ").getBytes());
                for (int k = 0; k < 3; k++)
                    for (int l = 0; l < 3; l++) {
                        fou.write((grid[i][k][j][l] + " | ").getBytes());

                    }
                fou.write(("\n-------------------------------------\n").getBytes());
            }

    }

}

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Matus on 20.03.2016.
 */
public class Loader {

    private InputStream is;
    private String file;

    public Loader(String file){
        this.file = file;
    }

    public int[][] load() throws IOException {

        Scanner scanner = new Scanner(new File(file));
        short size;
        size = scanner.nextShort();
        int[][]matrix = new int[size][size];

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(scanner.hasNextInt()){
                    matrix[i][j] = scanner.nextInt();
                }
            }
        }

        return matrix;

    }
}

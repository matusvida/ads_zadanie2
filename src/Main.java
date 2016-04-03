import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matus on 28.03.2016.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("vstup.txt");
        String path = file.getAbsolutePath();
        File file1 = new File("vstup.txt");
        String path1 = file1.getAbsolutePath();
        int distance = 0;

        List<Integer> visitedCities = new ArrayList<Integer>();
        Loader loader = new Loader(path);
        int[][] matrix = loader.load();

//        Loader loader1 = new Loader(path1);
        int[][] matrix1 = new int[17][17];//loader1.load();

        for(int i=0;i<matrix1.length;i++){
            for(int j=0;j<matrix1.length;j++){
                matrix1[i][j] = matrix[i][j];
            }
        }

//        Greedy greedy = new Greedy(matrix);
//        visitedCities = greedy.doGreedy();
//
//        Writer writer = new Writer();
//        writer.write(visitedCities);

        HeldKarp heldKarp = new HeldKarp();
        long start = System.currentTimeMillis();
        distance = heldKarp.minDistance(matrix1);
        long end = System.currentTimeMillis();
        System.out.println("time is: " + ((end-start)/1000)+"s");

        System.out.println("vzdialenost je " + distance);
//
    }
}

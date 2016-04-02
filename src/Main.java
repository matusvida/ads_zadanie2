import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Matus on 28.03.2016.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("vstup1.txt");
        String path = file.getAbsolutePath();
        File file1 = new File("vstup1.txt");
        String path1 = file1.getAbsolutePath();

        List<Integer> visitedCities = new ArrayList<Integer>();
        Loader loader = new Loader(path);
        int[][] matrix = loader.load();

        Loader loader1 = new Loader(path1);
        int[][] matrix1 = loader1.load();

//        Greedy greedy = new Greedy(matrix);
//        visitedCities = greedy.doGreedy();
//
//        Writer writer = new Writer();
//        writer.write(visitedCities);
//
        HeldKarp heldKarp = new HeldKarp(matrix1);
        heldKarp.findPath();
    }
}

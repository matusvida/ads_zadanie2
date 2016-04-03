import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Matus on 28.03.2016.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("vstup.txt");
        String path = file.getAbsolutePath();
        File file1 = new File("vstup1.txt");
        String path1 = file1.getAbsolutePath();
        int minCost = 0;

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

        TravelingSalesmanHeldKarp ht = new TravelingSalesmanHeldKarp();
        minCost = ht.minCost(matrix);
//        new Thread(() ->{
//
//        }).start();

        System.out.println("Min cost is " + minCost);
//
        HeldKarp heldKarp = new HeldKarp(matrix);
        //heldKarp.findPath();
    }
}

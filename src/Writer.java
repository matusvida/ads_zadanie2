import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by Matus on 30.03.2016.
 */
public class Writer {

    public Writer(){}

    public void write(List<Integer> visitedCities) throws IOException {

        FileWriter fw = new FileWriter("greedyOutput.txt");
        for(int city : visitedCities){
            fw.write(city+1+"\n");
        }
        fw.close();
    }
}

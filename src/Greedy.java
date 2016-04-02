import java.util.*;

import org.apache.commons.lang.ArrayUtils;


/**
 * Created by Matus on 30.03.2016.
 */
public class Greedy {

    int[][]matrix;

    public Greedy(int [][] matrix){
        this.matrix = matrix;
    }

    public List<Integer> doGreedy(){

        int size = matrix.length;
        int minimum;
        int indexOfNextCity = 0;
        int currentIndexOfCity = 0;
        int indexOfMinimum = 1;
        int result = 0;
        List<Integer> visited = new ArrayList<Integer>();
        List<Integer> distances = new ArrayList<Integer>();

        //nastavime nulu na 10000 aby sa nebrala do uvahy ako minimum
        matrix = changeZeros(matrix);

        //pridame prve mesto
        visited.add(indexOfNextCity);

        while(visited.size() != matrix.length){
            //najdenie minima
            minimum = setMinimum(indexOfNextCity);
            currentIndexOfCity = indexOfNextCity;
            //najdenie indexu minima
            indexOfNextCity = getIndexOfNextCityByMinimum(minimum, indexOfNextCity, visited);
            //ak sa uz mesto nachadza v prejdenych, najdeme dalsie minimum a ziskame index dalsieho mesta
            while(visited.contains(indexOfNextCity)){
                minimum = setNextMinimum(currentIndexOfCity, indexOfNextCity, indexOfMinimum);
                indexOfNextCity = getIndexOfNextCityByMinimum(minimum, currentIndexOfCity, visited);
                indexOfMinimum++;
            }
            indexOfMinimum = 1;
            System.out.println(minimum);
            distances.add(minimum);
            result += minimum;
            visited.add(indexOfNextCity);
//            Collections.sort(visited);
        }

        if(visited.size() == matrix.length){
            indexOfNextCity = visited.get(visited.size()-1);
            System.out.println(matrix[indexOfNextCity][0]);
            result += matrix[indexOfNextCity][0];
            visited.add(indexOfNextCity);
        }

        System.out.println("Result is: "+result);

        return visited;
    }

    private int setMinimum(int rowIndex){

        int minimum;
        List list = Arrays.asList(ArrayUtils.toObject(matrix[rowIndex]));

        minimum = (int)Collections.min(list);

        return minimum;
    }

    private int setNextMinimum(int rowIndex, int indexOfNextCity, int indexOfMinimum){

        int minimum;
        List list = Arrays.asList(ArrayUtils.toObject(matrix[rowIndex]));

        Collections.sort(list);

        return (int)list.get(indexOfMinimum);
    }

    private int[][] changeZeros(int[][] matrix){

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                if(matrix[i][j] == 0) {
                    matrix[i][j] = 10000;
                }
            }
        }
        return matrix;
    }

    private int getIndexOfNextCityByMinimum(int minimum, int index, List<Integer> visited){

        int indexOfMinimum = 0;
        while(matrix[index][indexOfMinimum] != minimum){// || visited.contains(indexOfMinimum)){
//            if(visited.contains(indexOfMinimum)){
//                break;
//            }
            indexOfMinimum++;
        }

        return indexOfMinimum;
    }
}


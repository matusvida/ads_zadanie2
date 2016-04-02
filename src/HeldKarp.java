import org.apache.commons.lang.ArrayUtils;

import java.util.*;

/**
 * Created by Matus on 30.03.2016.
 */
public class HeldKarp {

    private int[][] matrix;
    private int[] firstLine;
    private int distance;
    private List<Integer> visitedCities = new ArrayList<Integer>();

    public HeldKarp(int[][]matrix){
        this.matrix = matrix;
        firstLine = new int[matrix.length];
        for(int i=0;i<matrix.length;i++){
            firstLine[i] = matrix[0][i];
        }
    }

    public void findPath(){

        List<Integer> path = new ArrayList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> distances = new ArrayList<Integer>();
        List<Integer> copyOfList = new ArrayList<Integer>();

        // VYRIESIT UKLADANIE DISTANCE A HLADAT MINIMUM V MNOZINE HODNOT DISTANCE
        for(int g=0; g<matrix.length; g++) {
            for (int s = 1; s < matrix.length; s++) {
                for (int j = 1; j < matrix.length; j++) {
                    if (s != j) {
                        list.add(j);
                        copyOfList.add(j);
                        setDistance(0);
                        g(s, copyOfList);
                        distances.add(getDistance());
                        System.out.println(distance);
                    }
                }
            }
            path.add(g, Collections.min(distances));
            for(int indexOfMinimum=0;indexOfMinimum<distances.size();indexOfMinimum++){
                if(distances.get(indexOfMinimum) == path.get(g)) {
                    copyOfList.add(list.get(indexOfMinimum));
                    break;
                }
            }
            distances.clear();

        }
    }

    public void g(int index1, List<Integer> index2){

        int temp = 0;
        int swap=0;
        if(index2.size() == 0){
            distance += firstLine[index1];
        }
        else{
            for(int i=0 ;i<index2.size();i++){
                temp = index2.get(0);
                if(index2.size()<=1) {
                    index2.remove(0);
                    setDistance(getDistance() + matrix[index1][temp]);
                    g(temp, index2);
                }
                else{
                    setDistance(getDistance() + matrix[index1][temp]);
                    temp=index2.get(0);
                    index2.remove(0);
                    g(temp, index2);
//                    swap=index2.get(i);
//                    index2.set(i, index2.get(i+1));
//                    index2.set(i+1, swap);
//                    temp = index2.get(i);

                }

            }

        }
//        return distance;
    }

    public void g1(int index1, List<Integer> index2) {

        int temp = 0;
        int swap=0;
        if(index2.size() == 0){
            distance += firstLine[index1];
        }
        else{
            for(int i=1;i<index2.size();i++){
                setDistance(getDistance()+matrix[index1][index2.get(i-1)]);
//                setDistance(getDistance()+matrix[]);
            }
        }
    }

    private int setMinimum(int rowIndex){

        int minimum;
        List list = Arrays.asList(ArrayUtils.toObject(matrix[rowIndex]));
        minimum = (int) Collections.min(list);

        return minimum;
    }


    class TwoDimentionalArrayList<T> extends ArrayList<ArrayList<T>> {
        public void addToInnerArray(int index, T element) {
            while (index >= this.size()) {
                this.add(new ArrayList<T>());
            }
            this.get(index).add(element);
        }

        public void addToInnerArray(int index, int index2, T element) {
            while (index >= this.size()) {
                this.add(new ArrayList<T>());
            }

            ArrayList<T> inner = this.get(index);
            while (index2 >= inner.size()) {
                inner.add(null);
            }

            inner.set(index2, element);
        }
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}

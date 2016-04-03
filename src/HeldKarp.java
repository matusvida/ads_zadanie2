import org.apache.commons.lang.ArrayUtils;

import java.lang.reflect.Array;
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
        visitedCities.add(0);
    }

    public void findPath(){

        List<Integer> path = new ArrayList<Integer>();
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> distances = new ArrayList<Integer>();
        ArrayList<Integer> copyOfList = new ArrayList<Integer>();
        List<Integer> copyListTemp = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> perm= new ArrayList<ArrayList<Integer>>();

        for(int g=0; g<matrix.length; g++) {
            if(g==0) {
                for (int s = 1; s < matrix.length; s++) {
                    for (int j = 1; j < matrix.length; j++) {
                        if (s != j) {
                            list.add(j);
                            if (copyOfList.size() > 1) {
                                copyOfList.set(g, j);
                            } else {
                                copyOfList.add(g, j);
                            }
                            copyListTemp.addAll(copyOfList);

                            perm = permutations(copyOfList);
                            if (g < 1) {
                                if (copyOfList.size() == 0) {
                                    copyOfList.addAll(copyListTemp);
                                }
                                g(s, copyOfList);
                                distances.add(getDistance());
                                setDistance(0);
                            } else {
                                for (int t = 0; t < perm.size(); t++) {
                                    if (copyOfList.size() == 0) {
                                        copyOfList.addAll(copyListTemp);
                                    }
                                    g(s, perm.get(t));
                                    distances.add(getDistance());
                                    setDistance(0);
                                }
                            }
                            System.out.println(distance);
                            copyListTemp.clear();
                        }
                    }
                }
            }
            path.add(g, Collections.min(distances));
            for(int indexOfMinimum=0;indexOfMinimum<distances.size();indexOfMinimum++){
                if(distances.get(indexOfMinimum) == path.get(g)) {
                    copyOfList.add(list.get(indexOfMinimum));
                    visitedCities.add(list.get(indexOfMinimum+1));
                    visitedCities.add(list.get(indexOfMinimum));
                    break;
                }
            }
            distances.clear();

        }
    }

    public void g(int index1, List<Integer> index2){

        int temp = 0;
//        List<Integer> index2 = new ArrayList<Integer>();
//        for(int k=0;k<index2List.size();k++){
//            index2.add(k, index2List.get(k));
//        }
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

    private List<Integer> permute(java.util.List<Integer> arr, int k){
        List<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();
        List<Integer> inner = new ArrayList<Integer>();
        for(int i = k; i < arr.size(); i++){
            java.util.Collections.swap(arr, i, k);
            inner.addAll(arr);
            permutations.add((ArrayList) inner);
            permute(arr, k + 1);
            java.util.Collections.swap(arr, k, i);

        }
        if (k == arr.size() -1){
            System.out.println(java.util.Arrays.toString(arr.toArray()));
        }
        return arr;
    }

    private ArrayList<ArrayList<Integer>> permutations(ArrayList<Integer> input) {

        ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();

        if (input.size() == 0) {
            permutations.add(new ArrayList<Integer>());
            return permutations;
        }

        Integer firstElement = input.remove(0);

        ArrayList<ArrayList<Integer>> recursiveReturn = permutations(input);
        for (ArrayList<Integer> li : recursiveReturn) {

            for (int index = 0; index <= li.size(); index++) {
                ArrayList<Integer> temp = new ArrayList<Integer>(li);
                temp.add(index, firstElement);
                permutations.add(temp);
            }

        }
        return permutations;
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

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}

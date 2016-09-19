package com.coursera.algorithm;

import java.util.Arrays;
import java.util.List;

import com.coursera.algorithm.sorting.MergeSort;
import com.coursera.algorithm.sorting.QuickSort;
import com.coursera.algorithm.sorting.QuickSortPivot.ChooseFirstElement;
import com.coursera.algorithm.sorting.QuickSortPivot.ChooseLastElement;
import com.coursera.algorithm.sorting.QuickSortPivot.ChooseMedianOfThreeElement;

import com.coursera.algorithm.sorting.QuickSortPivot.IChoosePivotDelegate;
import com.coursera.algorithm.utils.UtilTool;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//System.out.println(Integer.MAX_VALUE);
    	List<Integer> test = Arrays.asList(5,4,3,2,1,6);
    	/*String fileName = "C:\\java_projects\\stanfordalgorithm\\data\\NumberOfInversionsIntegerArray.txt";
    	List<Integer> testa = UtilTool.readDataFromFile(fileName);
    	System.out.println(testa.size());
    	System.out.print(MergeSort.getInversionNumber(testa));*/
    	System.out.println(3/2);
    	IChoosePivotDelegate<Integer> choosePivotDelegate = new ChooseFirstElement<Integer>();
    	
    	QuickSort<Integer> quickSort = new QuickSort<Integer>(choosePivotDelegate);
        //quickSort.sort(test, 0, test.size()-1);
    	String fileName = "C:\\java_projects\\stanfordalgorithm\\data\\QuickSort.txt";
    	List<Integer> testa = UtilTool.readDataFromFile(fileName);    	
    	System.out.println(testa.size());
    	
    	System.out.println(quickSort.getComparisonNumber(testa, 0, testa.size()-1));
    	testa = UtilTool.readDataFromFile(fileName);
    	choosePivotDelegate = new ChooseLastElement<Integer>();
    	quickSort = new QuickSort<Integer>(choosePivotDelegate);
    	System.out.println(quickSort.getComparisonNumber(testa, 0, testa.size()-1));
    	
    	testa = UtilTool.readDataFromFile(fileName);
    	choosePivotDelegate = new ChooseMedianOfThreeElement<Integer>();
    	quickSort = new QuickSort<Integer>(choosePivotDelegate);
    	System.out.println(quickSort.getComparisonNumber(testa, 0, testa.size()-1));
    }
   
}

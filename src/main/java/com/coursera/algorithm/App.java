package com.coursera.algorithm;

import java.util.Arrays;
import java.util.List;

import com.coursera.algorithm.sorting.MergeSort;
import com.coursera.algorithm.utils.UtilTool;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println(Integer.MAX_VALUE);
    	List<Integer> test = Arrays.asList(1,3,5,2,4,6);
    	String fileName = "C:\\java_projects\\stanfordalgorithm\\data\\NumberOfInversionsIntegerArray.txt";
    	List<Integer> testa = UtilTool.readDataFromFile(fileName);
    	System.out.println(testa.size());
    	System.out.print(MergeSort.getInversionNumber(testa));
    	for(int i = 0; i < test.size(); i ++)
		{
			// System.out.println( test.get(i) );
		}
              
    }
   
}

package com.coursera.algorithm;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.coursera.algorithm.graph.Edge;
import com.coursera.algorithm.graph.Graph;
import com.coursera.algorithm.graph.KargerMinCut;
import com.coursera.algorithm.graph.SCC;
import com.coursera.algorithm.graph.SCCGraph;
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
    	//System.out.println(3/2);
//    	IChoosePivotDelegate<Integer> choosePivotDelegate = new ChooseFirstElement<Integer>();
//    	
//    	QuickSort<Integer> quickSort = new QuickSort<Integer>(choosePivotDelegate);
//        //quickSort.sort(test, 0, test.size()-1);
//    	String fileName = "/Users/xiaoyang/Documents/workspace/stanfordalgorithm/data/QuickSort.txt";
//    	List<Integer> testa = UtilTool.readDataFromFile(fileName);    	
//    	System.out.println(testa.size());
//    	
//    	System.out.println(quickSort.getComparisonNumber(testa, 0, testa.size()-1));
//    	testa = UtilTool.readDataFromFile(fileName);
//    	choosePivotDelegate = new ChooseLastElement<Integer>();
//    	quickSort = new QuickSort<Integer>(choosePivotDelegate);
//    	System.out.println(quickSort.getComparisonNumber(testa, 0, testa.size()-1));
//    	
//    	testa = UtilTool.readDataFromFile(fileName);
//    	choosePivotDelegate = new ChooseMedianOfThreeElement<Integer>();
//    	quickSort = new QuickSort<Integer>(choosePivotDelegate);
//    	System.out.println(quickSort.getComparisonNumber(testa, 0, testa.size()-1));
    	
//    	String fileName = "/Users/xiaoyang/Documents/workspace/stanfordalgorithm/data/KargerMinFinal.txt";
////    	fileName = "/Users/xiaoyang/Documents/workspace/stanfordalgorithm/data/KargerMinSecond.txt";
////    	fileName = "/Users/xiaoyang/Documents/workspace/stanfordalgorithm/data/KargerMinThird.txt";
////    	fileName = "/Users/xiaoyang/Documents/workspace/stanfordalgorithm/data/KargerMinFourth.txt";
//    	List<String> testb = UtilTool.readLineFromFile(fileName);
//    	int nodeCount = testb.size();
//    	
//    	Graph<Integer> graph = new Graph<Integer>();
//    	for(int i = 1; i <= nodeCount; i++)
//    	{
//    		graph.addNode(i);
//    		graph.getAdjacentNodesDic().put(i, new ArrayList<Integer>());
//    	}
//    	for(String line:testb)
//    	{
//    		String[] nodes = line.split("\t");
//    		for(int i = 0; i < nodes.length;i++)
//    		{
//    			if(i == 0) continue;
//    			int start = Integer.parseInt(nodes[0]);
//    			int end = Integer.parseInt(nodes[i]);
//    			Edge<Integer> edge = new Edge<Integer>(start,end);
//    			graph.addEdge(edge);
//    			graph.getAdjacentNodesDic().get(start).add(end);
//    		}
//    	}
//    	for(int node: graph.getNodes())
//    	{
//    		System.out.print(node+ " ");
//    		for(int endNode: graph.getAdjacentNodesDic().get(node))
//    		{
//    			System.out.print(endNode+ " ");
//    		}
//    		System.out.println();
//    	}
//    	for(Edge<Integer> edgeItem:graph.getEdges())
//		{
//			//System.out.println("#Start@"+edgeItem.getStart()+"#End@"+edgeItem.getEnd());
//		}
//    	int result= Integer.MAX_VALUE;
//    	for(int execute = 0; execute<200;execute++)
//    	{
//    		//int value = 2;
//    		int value = KargerMinCut.getCut(graph);
//    		
//    		if(result> value){
//    			result = value;
//    			for(Edge<Integer> edgeItem:graph.getEdges())
//    			{
//    				//System.out.println("#Start"+edgeItem.getStart()+"#End"+edgeItem.getEnd());
//    			}
//    		}
//    		graph = new Graph<Integer>();
//    		for(int i = 1; i <= nodeCount; i++)
//        	{
//        		graph.addNode(i);
//        		graph.getAdjacentNodesDic().put(i, new ArrayList<Integer>());
//        	}
//    		for(String line:testb)
//        	{
//        		String[] nodes = line.split("\t");
//        		for(int i = 0; i < nodes.length;i++)
//        		{
//        			if(i == 0) continue;
//        			int start = Integer.parseInt(nodes[0]);
//        			int end = Integer.parseInt(nodes[i]);
//        			Edge<Integer> edge = new Edge<Integer>(start,end);
//        			graph.addEdge(edge);
//        			graph.getAdjacentNodesDic().get(start).add(end);
//        		}
//        	}
//    	}
//    	System.out.println(result/2);
    	//System.out.println(KargerMinCut.getMinCut(graph, 100));
    	//String fileName = "/Users/xiaoyang/Documents/workspace/stanfordalgorithm/data/SCCtestCase1.txt";
    	
    	
    	String fileName = "/Users/xiaoyang/Documents/workspace/stanfordalgorithm/data/SCC.txt";
    	List<String> lineList = UtilTool.readLineFromFile(fileName);
    	SCCGraph g = new SCCGraph(875714);
    	//SCCGraph g = new SCCGraph(12);
    	for(String line:lineList)
    	{    		
    		String[] nodes = line.split(" ");
    		if(nodes.length==2)
    		{
    			int start = Integer.parseInt(nodes[0]);
    			int end = Integer.parseInt(nodes[1]);    			
    			g.insertEdge(start, end);
    		}
    	}
    	//g.Output();
    	SCC scc = new SCC(g);
    	scc.DFS_LOOP();
    	//scc.outputFinishTime();
    	scc.output();
    }
   
}

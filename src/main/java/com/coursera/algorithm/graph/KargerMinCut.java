package com.coursera.algorithm.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.coursera.algorithm.utils.IO.DeepCopy;
public class KargerMinCut {
	private static Random randomGenerator = new Random();
	public static int getCut(Graph<Integer> graph)
	{
		
		if(graph == null) return Integer.MAX_VALUE;
		Map<Integer,List<Integer>> adjacentNodesDic;
		//adjacentNodesDic = graph.getAdjacentNodesDic();
		int nodeCount = graph.getNodes().size();
		int edgeCount = graph.getEdges().size();
		if(nodeCount < 3) return edgeCount;
		while(nodeCount>2)
		{
			//random choose edges
			if(edgeCount<2) return edgeCount;
			int edgeIndex = randomGenerator.nextInt(edgeCount-1);
			Edge<Integer> chooseEdge = graph.getEdges().get(edgeIndex);
			int mergeNode = chooseEdge.getStart();
			int mergedNode = chooseEdge.getEnd();
//			System.out.println(mergedNode);
//			System.out.println(mergeNode);
			//List<Integer> mergeAdjacentNodes = adjacentNodesDic.get(mergeNode);
			//List<Integer> mergedAdjacentNodes = adjacentNodesDic.get(mergedNode);
			//merge or contract into a single node, set end node as merged node
			//remove self loop
			
			//remove merged node 
			for(int containedNode:graph.getAdjacentNodesDic().get(mergedNode))
			{
				//remove mergedNode from adjacent node list
				graph.getAdjacentNodesDic().get(containedNode).remove(Integer.valueOf(mergedNode));	
				Edge<Integer> newEdge = new Edge<Integer>(mergeNode,containedNode);
				//graph.addEdge(newEdge);
				if(containedNode != mergeNode)
				{				
					if(!graph.getAdjacentNodesDic().get(containedNode).contains(mergeNode))
					{
						//add new edge
						graph.getAdjacentNodesDic().get(containedNode).add(mergeNode);
						graph.getAdjacentNodesDic().get(mergeNode).add(containedNode);
						
					}
					
				}
				else
				{
					
				}
			}
			
			graph.removeNode(mergedNode);
			graph.getAdjacentNodesDic().remove(mergedNode);
			if(true)
			{
				List<Edge<Integer>> deletedEdges = new ArrayList<Edge<Integer>>();
				for(Edge<Integer> itemEdge: graph.getEdges())
				{
					if((itemEdge.getStart() == mergedNode&&itemEdge.getEnd() == mergeNode)
							||(itemEdge.getEnd() == mergedNode&&itemEdge.getStart() == mergeNode))
						deletedEdges.add(itemEdge);		
					else if(itemEdge.getStart() == mergedNode)
						itemEdge.setStart(mergeNode);
					else if(itemEdge.getEnd() == mergedNode)
						itemEdge.setEnd(mergeNode);
				}
				for(Edge<Integer> deletedEdge: deletedEdges)
				{
					graph.getEdges().remove(deletedEdge);
				}
			}
			edgeCount = graph.getEdges().size();
			nodeCount --;
//			System.out.println("#edge"+edgeCount);
//			System.out.println("#node:"+nodeCount);
			
//			for(int testNode: graph.getNodes())
//	    	{
//	    		System.out.print(testNode+" ");
//	    		for(int endNodetest: graph.getAdjacentNodesDic().get(testNode))
//	    		{
//	    			System.out.print(endNodetest+ " ");
//	    		}
//	    		System.out.println();
//	    	}
//			for(Edge<Integer> edgeItem:graph.getEdges())
//			{
//				System.out.print("(#Start"+edgeItem.getStart()+"#End"+edgeItem.getEnd() + ")");
//			}
		}
		
		return edgeCount;
	}
}

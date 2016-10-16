package com.coursera.algorithm.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SCCGraph {
	private int nodes;
	private Map<Integer,List<Integer>> inEdges;
	private Map<Integer,List<Integer>> outEdges;
	private Map<Integer,Boolean> exploredMapping;
	
	private SCCGraph(){
		setNodes(0);
		
		inEdges = (new HashMap<Integer, List<Integer>>());
		outEdges = (new HashMap<Integer,List<Integer>>());
		exploredMapping = new HashMap<Integer,Boolean>();
	}

	public SCCGraph(int nodes)
	{
		this();
		setNodes(nodes);		
	}
	
	public void insertEdge(int start, int end)
	{
		getInEdges().get(end).add(start);
		getOutEdges().get(start).add(end);
	}
	
	public int getNodes() 
	{
		return nodes;
	}

	public void setNodes(int nodes) 
	{
		if(nodes<1) nodes = 0;
		this.nodes = nodes;
		for(int i = 1; i <=nodes; i++)
		{
			inEdges.put(i, new ArrayList<Integer>());
			outEdges.put(i, new ArrayList<Integer>());
			exploredMapping.put(i, false);
		}
	}
	
	public void setExplored(int node)
	{
		if(node<1) return;
		exploredMapping.put(node, true);
	}
	
	public Boolean getExplored(int node)
	{
		if(node<1) return false;
		return exploredMapping.get(node);
	}
	public void resetExplored()
	{
		for(int i = 1; i <=nodes; i++)
		{
			exploredMapping.put(i, false);
		}
	}

	public Map<Integer,List<Integer>> getInEdges() {
		return inEdges;
	}


	public Map<Integer,List<Integer>> getOutEdges() {
		return outEdges;
	}

	
	public void Output() {
		for(int i = 1; i <= nodes;i++)
		{
			StringBuilder sb = new StringBuilder();
			sb.append(i);
			sb.append(":");
			for(int edge: inEdges.get(i)) 
			{
				sb.append(edge);
				sb.append("\t");
			}
			sb.append("\n");
			sb.append(i);
			sb.append(":");
			for(int edge: outEdges.get(i)) 
			{
				sb.append(edge);
				sb.append("\t");
			}
			System.out.println(sb.toString());
		}
	}

	
}

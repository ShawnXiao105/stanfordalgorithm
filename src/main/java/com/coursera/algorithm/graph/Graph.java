package com.coursera.algorithm.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph<T> {
	private List<Integer> nodeList;
	private List<Edge<T>> edges;
	private Map<Integer,List<Integer>> adjacentNodesDic;
	public Graph()
	{
		nodeList = new ArrayList<Integer>();
		edges = new ArrayList<Edge<T>>();
		adjacentNodesDic = new HashMap<Integer, List<Integer>>();
	}
	public void addEdge(Edge<T> edge)
	{
		if(edge==null) return;
		//self loop
		if(edge.getStart()== edge.getEnd()) return;
		this.edges.add(edge);
	}
	public void addNode(int node)
	{
		if(node<1||nodeList.contains(node)) return;
		this.nodeList.add(node);
	}
	public void removeNode(int node)
	{
		if(node<1||!nodeList.contains(node)) return;
		nodeList.remove(Integer.valueOf(node));
	}
	
	public List<Integer> getNodes() {
		return nodeList;
	}
	public void setNodes(List<Integer> nodeList){
		if(nodeList == null) return;
		this.nodeList = nodeList;
	}
	public List<Edge<T>> getEdges() {
		return edges;
	}
	public void setEdges(List<Edge<T>> edges){
		if(edges == null) return;
		this.edges = edges;
	}
	public Map<Integer,List<Integer>> getAdjacentNodesDic() {
		return adjacentNodesDic;
	}
	public void setAdjacentNodesDic(Map<Integer,List<Integer>> dic){
		this.adjacentNodesDic = dic;
	}
	@Override
	public String toString() {
		
		return super.toString();
	}
	
	
}

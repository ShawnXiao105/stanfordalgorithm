package com.coursera.algorithm.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class SCC {
	private List<Integer> leaderList;
	private List<Integer> nodeFinishTimeList;
	private List<Integer> finishTimeList;
	private Integer t = 0;
	private Integer s = -1;
	private SCCGraph g;
	public SCC(SCCGraph g)
	{
		this.g = g;
		//first element is dump element
		leaderList = new ArrayList<Integer>();
		finishTimeList = new ArrayList<Integer>();
		nodeFinishTimeList  = new ArrayList<Integer>();
		finishTimeList.add(0);
		for(int i = 0; i <=g.getNodes();i++)
		{
			leaderList.add(i);
			//finishTimeList.add(0);
			nodeFinishTimeList.add(0);
		}
	}
	
	private void DFSFirst(int i)
	{
		g.setExplored(i);
		for(int adjNode: g.getInEdges().get(i))
		{
			if(!g.getExplored(adjNode))
				DFSFirst(adjNode);
		}
		//t++;
		finishTimeList.add(i);
		//System.out.println("Add this node to finishtime"+i);
	}
	
	private void DFSFirstNonRecursive(int i)
	{
		Stack<Integer> st = new Stack<Integer>();
		st.push(i);
		while(!st.isEmpty())
		{
			int v = st.pop();
			if(!g.getExplored(v))
			{
				g.setExplored(v);
				st.push(v);
				for(int w:g.getInEdges().get(v))
				{
					if(!g.getExplored(w))
					{
						st.push(w);
						//g.setExplored(w);
					}
				}
			}
			else
			{
				if(nodeFinishTimeList.get(v)==0)
				{
					t = t + 1;
					finishTimeList.add(v);
					nodeFinishTimeList.set(v, t);
					
				}
				//System.out.println("Add this node to finishtime"+v);
			}
		}
	}
	private void DFSFirstTest(int i)
	{
		Stack<Integer> st = new Stack<Integer>();
		st.push(i);
		System.out.println("Push" + i);
		g.setExplored(i);
		while(!st.isEmpty())
		{
			int v = st.peek();
			Boolean hasEdges = false;
			for(int w:g.getInEdges().get(v))
			{
				if(!g.getExplored(w))
				{
					g.setExplored(w);
					st.push(w);
					System.out.println("Push" + w);
					hasEdges = true;
				}
			}
			if(!hasEdges)
			{
				finishTimeList.add(st.pop());
				System.out.println("Pop" + v);
				System.out.println("Add this node to finishtime"+v);
			}
			
		}
	}
	private void DFSSecondNonRecursive(int i)
	{
		Stack<Integer> st = new Stack<Integer>();
		st.push(i);
		while(!st.isEmpty())
		{
			int v = st.pop();
			if(!g.getExplored(v))
			{
				leaderList.set(v, s);
				g.setExplored(v);
				st.push(v);
				for(int w:g.getOutEdges().get(v))
				{
					if(!g.getExplored(w))
						st.push(w);
				}
			}
			
		}
	}
	private void DFSSecond(int i)
	{
		g.setExplored(i);
		leaderList.set(i, s);
		for(int adjNode: g.getOutEdges().get(i))
		{
			if(!g.getExplored(adjNode))
				DFSSecond(adjNode);
		}
	}
	
	public void DFS_LOOP()
	{
		//first DFS to G-reversed
		for(int node = g.getNodes(); node>0; node--)
		{
			if(!g.getExplored(node))
				//DFSFirst(node);
				DFSFirstNonRecursive(node);
		}
//		for(int node = 1; node <= g.getNodes();node++)
//		{
//			if(!g.getExplored(node))
//				DFSFirst(node);
//		}
		g.resetExplored();
		//second DFS to G
		for(int finishTime = g.getNodes(); finishTime>0; finishTime--)
		{
			int node = finishTimeList.get(finishTime);
			if(!g.getExplored(node))
			{
				s = node;
				//DFSSecond(node);
				DFSSecondNonRecursive(node);
			}
		}
	}

	public List<Integer> getLeaderList() {
		return leaderList;
	}

	public void outputFinishTime()
	{
		for(int i = 1; i <=g.getNodes();i++)
		{
			System.out.println(i + " - " + finishTimeList.get(i));
		}
	}
	public void output(){
		Map<Integer,Integer> SCCGroup = new HashMap<Integer,Integer>();
		List<Integer> nodeCounts = new ArrayList<Integer>();
		for(int node:getLeaderList())
		{
			if(SCCGroup.containsKey(node))
				SCCGroup.put(node,SCCGroup.get(node) + 1);
			else
				SCCGroup.put(node, 1);
		}
		for(Map.Entry<Integer, Integer> entry: SCCGroup.entrySet())
		{
			 if(entry.getKey() != 0)
			 {
				 nodeCounts.add(entry.getValue());	
			 }
		}
		nodeCounts.sort(null);
		int nLargeSize = 5;
		if(nodeCounts.size()<5)
		{
			nLargeSize = nodeCounts.size();
		}
		for(int i = 0; i < nLargeSize; i ++)
		{
			System.out.println(nodeCounts.get(nodeCounts.size() - i - 1));
		}
	}
}

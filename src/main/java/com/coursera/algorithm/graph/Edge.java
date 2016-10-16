package com.coursera.algorithm.graph;

public class Edge<T> {
	private T value;
	private int start;
	private int end;
	public Edge()
	{
		start = 0;
		end = 0;
	}
	public Edge(int start,int end)
	{	
		setStart(start);
		setEnd(end);
		
	}
	public Edge(int start,int end,T value)
	{
		this(start, end);
		this.setValue(value);
	}
	
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		if(start < 0) this.start = 0;
		this.start = start;
	}
	
	public int getEnd() {
		return end;
	}
	
	public void setEnd(int end) {
		if(end <0) this.end = 0;
		this.end = end;
	}
	
	
}

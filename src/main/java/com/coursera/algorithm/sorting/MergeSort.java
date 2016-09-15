package com.coursera.algorithm.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
	public static <T extends Comparable<T>> void sort(List<T> data)
	{
		if(data == null ||data.size() == 0)
			return;
		int begin = 0;
		int end = data.size() - 1;
		mergeSort(data,begin,end);
	}
	
	public static <T extends Comparable<T>> long getInversionNumber(List<T> data)
	{
		if(data == null ||data.size() == 0)
			return 0;
		int begin = 0;
		int end = data.size() - 1;
		return mergeSortInversion(data,begin,end);
	}
	
	private static <T extends Comparable<T>> long mergeSortInversion(List<T> data, int begin, int end)
	{
		if(data == null ||data.size() == 0)
			return 0;
		//just one element
		else if(begin == end)
			return 0;
		int middle = begin + (end - begin)/2 + 1;		
		return mergeSortInversion(data,begin,middle-1) +mergeSortInversion(data,middle,end) + mergeInversion(data,begin,end);
	}
	
	private static <T extends Comparable<T>> void mergeSort(List<T> data, int begin, int end)
	{
		if(data == null ||data.size() == 0)
			return;
		//just one element
		else if(begin == end)
			return;
		int middle = begin + (end - begin)/2 + 1;		
		mergeSort(data,begin,middle-1);
		mergeSort(data,middle,end);
		merge(data,begin,end);
	}
	
	
	private static <T extends Comparable<T>> void merge(List<T> data, int begin, int end)
	{	
		//just one element
		if(begin == end)
			return;
		int middle = begin +  (end - begin)/2 + 1;
		int length = end - begin + 1;
		int i = begin,j = middle;
		
		List<T> out = new ArrayList<T>(length);
		for(int m = 0; m < length; m ++)
		{			
			if(i == middle)
			{
				out.add(data.get(j));
				j++;
			}
			else if(j == end + 1)
			{
				out.add(data.get(i));
				i++;
			}
			else if( data.get(i).compareTo(data.get(j))>0)
			{
				out.add(data.get(j));
				j++;
			}
			else if(data.get(i).compareTo(data.get(j))<=0)
			{
				out.add(data.get(i));
				i++;
			}
		}
		for(int m = 0, n = begin;m < length;m++,n ++)
		{			
			data.set(n, out.get(m)) ;
		}		
	}
	private static <T extends Comparable<T>> long mergeInversion(List<T> data, int begin, int end)
	{	
		//just one element
		if(begin == end)
			return 0;
		long result = 0;
		int middle = begin +  (end - begin)/2 + 1;
		int length = end - begin + 1;
		int i = begin,j = middle;
		
		List<T> out = new ArrayList<T>(length);
		for(int m = 0; m < length; m ++)
		{			
			if(i == middle)
			{
				out.add(data.get(j));
				j++;
			}
			else if(j == end + 1)
			{
				out.add(data.get(i));
				i++;
			}
			else if( data.get(i).compareTo(data.get(j))>0)
			{
				out.add(data.get(j));
				result = result + (middle - i);
				
				j++;
			}
			else if(data.get(i).compareTo(data.get(j))<=0)
			{
				out.add(data.get(i));
				i++;
			}
		}
		for(int m = 0, n = begin;m < length;m++,n ++)
		{			
			data.set(n, out.get(m)) ;
		}	
		return result;
	}
}

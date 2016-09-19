package com.coursera.algorithm.sorting;

import java.util.List;

import com.coursera.algorithm.sorting.QuickSortPivot.IChoosePivotDelegate;

public class QuickSort<T extends Comparable<T>> {
	private IChoosePivotDelegate<T> choosePivotDelegate = null;
	
	public QuickSort(IChoosePivotDelegate<T> choosePivotDelegate)
	{
		this.choosePivotDelegate = choosePivotDelegate;
	}
	
	public void sort(List<T> data, int left, int right)
	{
		if(left >= right)
			return;
		int pIndex = partition(data,left,right);
		System.out.println(pIndex);
		sort(data,left, pIndex - 1);
		sort(data,pIndex + 1, right);
	}
	
	public long getComparisonNumber(List<T> data, int left, int right)
	{
		if(left >= right)
			return 0 ;
		int pIndex = partition(data,left,right);
		//System.out.println(pIndex);
		return right - left + getComparisonNumber(data,left, pIndex - 1) + getComparisonNumber(data,pIndex + 1, right);		
	}
	
	private int partition(List<T> data, int left, int right)
	{
		//printLeftAndRight(left, right);
		int pIndex = choosePivotDelegate.getPivotIndex(data,left, right);
		
		swap(data,left,pIndex);
		T p = data.get(left);
		int i = left + 1;
		for(int j = left + 1; j<=right; j++)
		{
			if(p.compareTo(data.get(j))>0)
			{
				swap(data,i,j);
				i++;
			}
		}
		swap(data,left,i-1);
		//print(data);
		return i-1;
	}
	
	private <T> void swap(List<T> data, int i, int j)
	{
		T temp = data.get(i);
		data.set(i, data.get(j));
		data.set(j, temp);
	}
	
	private void printLeftAndRight(int left, int right)
	{
		System.out.println(String.format("Left - %s|Right - %s",left, right));
	}
	private <T> void print(List<T> data)
	{
		for(int i = 0; i < data.size(); i ++)
        {
        	System.out.print(data.get(i));
        }
		System.out.println();
	}
}

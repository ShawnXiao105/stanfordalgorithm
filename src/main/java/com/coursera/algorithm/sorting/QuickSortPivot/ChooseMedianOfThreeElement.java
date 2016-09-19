package com.coursera.algorithm.sorting.QuickSortPivot;

import java.util.List;

public class ChooseMedianOfThreeElement<T extends Comparable<T>> implements IChoosePivotDelegate<T>{

	@Override
	public  int getPivotIndex(List<T> data, int left, int right) {
		return getMedianofThree(data,left,(right+left)/2,right);
	}
	
	private int getMedianofThree(List<T> data, int first, int median, int last)
	{
		T firstVal = data.get(first);
		T medianVal = data.get(median);
		T lastVal = data.get(last);
		if(firstVal.compareTo(medianVal)>=0)
		{
			if(firstVal.compareTo(lastVal)>=0)
			{
				if(medianVal.compareTo(lastVal)>=0)
				{
					return median;
				}
				else
				{
					return last;
				}
			}
			else
			{
				return first;
			}
		}
		else
		{
			if(medianVal.compareTo(lastVal)>=0)
			{
				if(firstVal.compareTo(lastVal)>0)
				{
					return first;
				}
				else
					return last;				
			}
			else
			{
				return median;
			}
		}
	}

}

package com.coursera.algorithm.sorting.QuickSortPivot;

import java.util.List;



public class ChooseLastElement<T> implements IChoosePivotDelegate<T> {

	@Override
	public int getPivotIndex(List<T>data,int left, int right) {
		return right;		
	}

}

package com.coursera.algorithm.sorting.QuickSortPivot;

import java.util.List;

public interface IChoosePivotDelegate<T> {
	int  getPivotIndex(List<T> data,int left, int right);
}

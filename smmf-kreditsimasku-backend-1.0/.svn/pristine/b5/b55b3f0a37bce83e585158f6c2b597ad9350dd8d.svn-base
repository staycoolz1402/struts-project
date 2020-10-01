package com.mpe.common;

import java.util.Comparator;

import com.ams.mufins.model.View;


public class ViewComparator implements Comparator<View> {
	
	public enum SortBy {VIEWNAME, PARENTVIEWNAME}
	
	private SortBy sortBy;
	
	@Override
	public int compare(View view1, View view2) {
		if(sortBy == SortBy.PARENTVIEWNAME){
			if(view1.getParentViewName().equalsIgnoreCase(view2.getParentViewName())){
				if(view1.getId() > view2.getId()) return 1;
				else if(view1.getId() == view2.getId()) return 0;
				else return -1;
			}
			else return view1.getParentViewName().compareToIgnoreCase(view2.getParentViewName());
		}
		else {
			if(view1.getViewName().equalsIgnoreCase(view2.getViewName())) {
				if(view1.getId() > view2.getId()) return 1;
				else if(view1.getId() == view2.getId()) return 0;
				else return -1;
			}
			else return view1.getViewName().compareToIgnoreCase(view2.getViewName());
		}
	}

	public SortBy getSortBy() {
		return sortBy;
	}

	public void setSortBy(SortBy sortBy) {
		this.sortBy = sortBy;
	}	
	
	
}
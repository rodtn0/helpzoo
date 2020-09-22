package com.project.helpzoo.admin.model.vo;

public class AFundingCategory {
	
	private String category;
	private int proportion;
	
public AFundingCategory() {
	// TODO Auto-generated constructor stub
}

public AFundingCategory(String category, int proportion) {
	super();
	this.category = category;
	this.proportion = proportion;
}

public String getCategory() {
	return category;
}

public void setCategory(String category) {
	this.category = category;
}

public int getProportion() {
	return proportion;
}

public void setProportion(int proportion) {
	this.proportion = proportion;
}

@Override
public String toString() {
	return "AFundingCategory [category=" + category + ", proportion=" + proportion + "]";
}



}

package hcmute.models;

import java.io.Serializable;

public class CategoryModel implements Serializable{
	private static final long serialVersionUID = 1L;
	private int cateID;
	private String cateName;
	private String images;
	public CategoryModel(){
		super();
	}
	public CategoryModel(int cateID, String cateName, String images) {
		super();
		this.cateID = cateID;
		this.cateName = cateName;
		this.images = images;
	}
	public int getCateID() {
		return cateID;
	}
	public void setCateID(int cateID) {
		this.cateID = cateID;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public String getInmages() {
		return images;
	}
	public void setImages(String inmages) {
		this.images = inmages;
	}
	@Override
	public String toString() {
		return "CategoryModel [cateID=" + cateID + ", cateName=" + cateName + ", images=" + images + "]";
	}
	
}

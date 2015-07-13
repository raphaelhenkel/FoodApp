package model;
//Data transfer object, creating profile properties
import java.util.ArrayList;
import java.util.List;
// future versions will use more properties, such as weight and eating habits
public class ProfileDto {
	private int id;
	private String name;
	private int weight;
	private int height;
	private int birthday;
	private int calories;
	private int daycalories;
	private boolean vegetarian;
	
	private List<Integer> likedFoodIds = new ArrayList<Integer>();
	private List<Integer> dislikedFoodIds = new ArrayList<Integer>();
	
	public List<Integer> getLikedFoodIds() {
		return likedFoodIds;
	}
	public  void setLikedFoodIds(List<Integer> likedFoodIds) {
		this.likedFoodIds = likedFoodIds;
	}
	public List<Integer> getDislikedFoodIds() {
		return dislikedFoodIds;
	}
	public void setDislikedFoodIds(List<Integer> dislikedFoodIds) {
		this.dislikedFoodIds = dislikedFoodIds;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getBirthday() {
		return birthday;
	}
	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public int getDaycalories() {
		return daycalories;
	}
	public void setDaycalories(int daycalories) {
		this.daycalories = daycalories;
	}
	public boolean isVegetarian() {
		return vegetarian;
	}
	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}



	
}

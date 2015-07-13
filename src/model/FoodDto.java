package model;
//data transfer object, getting the object properties
public class FoodDto {
	private int id;
	private String name;
	private int imageResource;
	private int calories;
	private int sugarContent;
	private FoodCategoryDto category;
	
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
	public int getImageResource() {
		return imageResource;
	}
	public void setImageResource(int imageResource) {
		this.imageResource = imageResource;
	}
	public int getCalories() {
		return calories;
	}
	public void setCalories(int calories) {
		this.calories = calories;
	}
	public int getSugarContent() {
		return sugarContent;
	}
	public void setSugarContent(int sugarContent) {
		this.sugarContent = sugarContent;
	}
	public FoodCategoryDto getCategory() {
		return category;
	}
	public void setCategory(FoodCategoryDto category) {
		this.category = category;
	}
	@Override
	public String toString() {
		return "FoodDto [name=" + name + ", category=" + category + "]";
	}
}

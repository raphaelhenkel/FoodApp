package model;
//Data transfer object, getting time dependencies 
public class FoodCategoryDto {
	private String name;
	private int startHour;
	private int endHour;
	
	public FoodCategoryDto(String name, int startHour, int endHour) {
		this.name = name;
		this.startHour = startHour;
		this.endHour = endHour;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStartHour() {
		return startHour;
	}
	public void setStartHour(int startHour) {
		this.startHour = startHour;
	}
	public int getEndHour() {
		return endHour;
	}
	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}

	@Override
	public String toString() {
		return "FoodCategoryDto [name=" + name + ", startHour=" + startHour
				+ ", endHour=" + endHour + "]";
	}
}

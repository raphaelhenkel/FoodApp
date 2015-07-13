package data;
//data access layer, setting the time properties
import model.FoodCategoryDto;

public class FoodCategoryDal implements DalInterface {
	protected FoodCategoryDto getBreakfast(){
		FoodCategoryDto breakfast = new FoodCategoryDto("Breakfast",0,11);
		return breakfast;
	}
	protected FoodCategoryDto getLunch(){
		FoodCategoryDto lunch = new FoodCategoryDto("Lunch",12,15);
		return lunch;
	}
	protected FoodCategoryDto getDinner(){
		FoodCategoryDto dinner = new FoodCategoryDto("Dinner",15,23);
		return dinner;
	}
	
	@Override
	public void reset() {
		// nothing to do
	}
}

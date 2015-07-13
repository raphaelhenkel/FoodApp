package service;
//contains business logic for MainActivity
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import android.util.Log;
import data.FoodDal;
import model.FoodCategoryDto;
import model.FoodDto;
import model.FoodListDto;

public class FoodService {

	private FoodDal foodDal = new FoodDal();
	
	/**
	 * A a list with THREE random food objects.
	 * @return
	 */
	public FoodListDto getRandomList(){
		return this.getRandomList(3);
	}
	
	/**
	 * Get ONE random food object.
	 * @return
	 */
	public FoodDto getRandom(){
		
		//get all food
		FoodListDto foodListDto = this.getRandomList(1);
		
		if(foodListDto!=null && foodListDto.getList()!=null && !foodListDto.getList().isEmpty()){
			//return first entry
			return foodListDto.getList().get(0);
		}

		return null;
	}
	
	/**
	 * Get a list with random food objects.<br />
	 * To choose the food, the current time will be applied.
	 * @param requiredSize
	 * @return
	 */
	private FoodListDto getRandomList(int requiredSize){
		
		//get all food
		FoodListDto foodListDto = this.foodDal.loadAllFoodEntries();
		
		//get current time
		Calendar now = Calendar.getInstance();
		int currentHour = now.get(Calendar.HOUR_OF_DAY);
		System.out.println("Current Hour: "+currentHour);
		
		//filter food by time
		List<FoodDto> validFood = new ArrayList<FoodDto>();
		for(FoodDto currentFood : foodListDto.getList()){
			System.out.println("Current Food: "+currentFood.getName());
			FoodCategoryDto currentCategory = currentFood.getCategory();
			if(currentCategory!=null){
				if(currentCategory.getStartHour()<=currentHour){
					if(currentCategory.getEndHour()>=currentHour){
						validFood.add(currentFood);
						System.out.println("Accepted.");
					}else{
						System.out.println("It is too late.");
					}
				}else{
					System.out.println("It is too early.");
				}
			}else{
				System.out.println("No category available");
			}
		}
		
		//randomly pick 3 kinds
		Collections.shuffle(validFood);
		if(validFood.size()>requiredSize){
			validFood=validFood.subList(0, requiredSize);
		}
		
		FoodListDto resultList =new FoodListDto();
		resultList.setList(validFood);

		return resultList;
	}
	
	public FoodDto loadFood(int id){
		return this.foodDal.getFood(id);
	}
	
	/**
	 * Get next food.
	 * @param currentId
	 * @return
	 */
	public FoodDto getNext(int currentId){
		int nextFoodId = currentId+1;
		FoodDto nextFood = this.foodDal.getFood(nextFoodId);
		return nextFood;
	}
	
	/**
	 * Get previous food.
	 * @param currentId
	 * @return
	 */
	public FoodDto getPrevious(int currentId){
		int previousFoodId = currentId-1;
		FoodDto nextFood = this.foodDal.getFood(previousFoodId);
		return nextFood;
	}
	
	/**
	 * Check if the given food ID belongs to the first entry.
	 * @param foodId
	 * @return
	 */
	public boolean isFirst(int foodId){
		int previousId=foodId-1;
		FoodDto previousFood = this.foodDal.getFood(previousId);
		
		if(previousFood==null){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Check if the given food ID belongs to the first entry.
	 * @param foodId
	 * @return
	 */
	public boolean isLast(int foodId){
		int nextId=foodId+1;
		FoodDto nextFood = this.foodDal.getFood(nextId);
		
		if(nextFood==null){
			return true;
		}else{
			return false;
		}
	}
}

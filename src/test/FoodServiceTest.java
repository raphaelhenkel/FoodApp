package test;

import org.junit.Test;
import org.junit.Assert;

import model.FoodDto;
import service.FoodService;

public class FoodServiceTest {
	//trying JUnit test, throws error
	private FoodService foodService = new FoodService();
	
	@Test
	public void testLoadDto(){
		FoodDto food = this.foodService.loadFood(0);
		
		Assert.assertTrue("LOAD OK",food!=null && food.getName()!=null && food.getName()=="test");
	}
	
}

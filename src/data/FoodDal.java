package data;
//data access layer, setting the food properties
import java.util.ArrayList;
import java.util.List;

import com.example.foodapp_1.R;

import model.FoodDto;
import model.FoodListDto;

public class FoodDal implements DalInterface{
	
	private FoodCategoryDal foodCategoryDal=new FoodCategoryDal();
	
	public FoodListDto loadAllFoodEntries(){
		List<FoodDto> list = new ArrayList<FoodDto>();

		for(int i=1;this.getFood(i)!=null;i++){
			list.add(this.getFood(i));
		}
		
		//fill food list object
		FoodListDto foodListDto =new FoodListDto();
		foodListDto.setList(list);
		
		return foodListDto;
	}
	
	public FoodDto getFood(int id){
		FoodDto food = new FoodDto();
		food.setId(id);
		
		switch(id){
		case 1:
			food.setCalories(200);
			food.setName("Wurstbrot");
			food.setSugarContent(8);
			food.setCategory(foodCategoryDal.getBreakfast());
			food.setImageResource(R.drawable.ic_wurstbrot);
			break;
		case 2:
			food.setCalories(10);
			food.setName("Apfel");
			food.setSugarContent(1);
			food.setCategory(foodCategoryDal.getBreakfast());
			food.setImageResource(R.drawable.apfel);
			break;
		case 3:
			food.setCalories(500);
			food.setName("Spaghetti");
			food.setSugarContent(0);
			food.setCategory(foodCategoryDal.getLunch());
			food.setImageResource(R.drawable.ic_nudelnmittomatensauce);
			break;
		case 4:
			food.setCalories(600);
			food.setName("Schnitzel");
			food.setSugarContent(30);
			food.setCategory(foodCategoryDal.getLunch());
			food.setImageResource(R.drawable.schnitzel);
			break;
		case 5:
			food.setCalories(500);
			food.setName("Steak");
			food.setSugarContent(0);
			food.setCategory(foodCategoryDal.getDinner());
			food.setImageResource(R.drawable.ic_steak);
			break;
		case 6:
			food.setCalories(120);
			food.setName("Grillwurst");
			food.setSugarContent(200);
			food.setCategory(foodCategoryDal.getDinner());
			food.setImageResource(R.drawable.ic_grillwurst);
			break;
		case 7:
			food.setCalories(100);
			food.setName("Salat mit Schafskaese");
			food.setSugarContent(10);
			food.setCategory(foodCategoryDal.getDinner());
			food.setImageResource(R.drawable.ic_salatmitschafskaese);
			break;
		case 8:
			food.setCalories(60);
			food.setName("Muesli");
			food.setSugarContent(10);
			food.setCategory(foodCategoryDal.getBreakfast());
			food.setImageResource(R.drawable.ic_muesli);
			break;
		case 9:
			food.setCalories(200);
			food.setName("Bacon mit Ei");
			food.setSugarContent(10);
			food.setCategory(foodCategoryDal.getBreakfast());
			food.setImageResource(R.drawable.ic_baconmitei);
			break;
		case 10:
			food.setCalories(300);
			food.setName("Bouletten");
			food.setSugarContent(10);
			food.setCategory(foodCategoryDal.getLunch());
			food.setImageResource(R.drawable.ic_bouletten);
			break;
		case 11:
			food.setCalories(100);
			food.setName("Brot mit Ei");
			food.setSugarContent(10);
			food.setCategory(foodCategoryDal.getDinner());
			food.setImageResource(R.drawable.ic_brotmitei);
			break;
		case 12:
			food.setCalories(80);
			food.setName("Brot mit Frischkaese");
			food.setSugarContent(10);
			food.setCategory(foodCategoryDal.getBreakfast());
			food.setImageResource(R.drawable.ic_brotmitfrischkaese);
			break;
		case 13:
			food.setCalories(300);
			food.setName("Burger");
			food.setSugarContent(10);
			food.setCategory(foodCategoryDal.getDinner());
			food.setImageResource(R.drawable.ic_burger);
			break;
		case 14:
			food.setCalories(150);
			food.setName("Eiersalat");
		
			food.setSugarContent(10);
			food.setCategory(foodCategoryDal.getDinner());
			food.setImageResource(R.drawable.ic_eiersalat);
			break;
		case 15:
			food.setCalories(150);
			food.setName("Frikadellenbroetchen");
			food.setSugarContent(10);
			food.setCategory(foodCategoryDal.getBreakfast());
			food.setImageResource(R.drawable.ic_frikadellenbroetchen);
			break;
		case 16:
			food.setCalories(100);
			food.setName("Hackbroetchen");
			food.setSugarContent(10);
			food.setCategory(foodCategoryDal.getDinner());
			food.setImageResource(R.drawable.ic_hackbroetchen);
			break;
		case 17:
			food.setCalories(100);
			food.setName("Marmeladenbrot");
			food.setSugarContent(10);
			food.setCategory(foodCategoryDal.getBreakfast());
			food.setImageResource(R.drawable.ic_marmeladenbrot);
			break;
		case 18:
			food.setCalories(300);
			food.setName("Mexikanischer Couscoussalat");
			food.setSugarContent(10);
			food.setCategory(foodCategoryDal.getLunch());
			food.setImageResource(R.drawable.ic_mexikanischercouscoussalat);
			break;
		case 19:
			food.setCalories(250);
			food.setName("Seelachsfilet");
			food.setSugarContent(10);
			food.setCategory(foodCategoryDal.getLunch());
			food.setImageResource(R.drawable.ic_seelachsfilet);
			break;
		case 20:
			food.setCalories(300);
			food.setName("Tortelliniauflauf");
			food.setSugarContent(10);
			food.setCategory(foodCategoryDal.getLunch());
			food.setImageResource(R.drawable.ic_tortelloniauflauf);
			break;
		case 21:
			food.setCalories(160);
			food.setName("Vegetarischer Reis");
			food.setSugarContent(10);
			food.setCategory(foodCategoryDal.getLunch());
			food.setImageResource(R.drawable.ic_vegetarischerreis);
			break;
		case 22:
			food.setCalories(180);
			food.setName("Vegetarisches Schnitzel");
			food.setSugarContent(10);
			food.setCategory(foodCategoryDal.getLunch());
			food.setImageResource(R.drawable.ic_vegetarischesschnitzel);
			break;	
		case 23:
			food.setCalories(150);
			food.setName("Thunfischbrot");
			food.setSugarContent(10);
			food.setCategory(foodCategoryDal.getBreakfast());
			food.setImageResource(R.drawable.ic_tunfischbrot);
			break;
		case 24:
			food.setCalories(100);
			food.setName("Nutellabrot");
			food.setSugarContent(10);
			food.setCategory(foodCategoryDal.getBreakfast());
			food.setImageResource(R.drawable.ic_nutellabrot);
		case 25:
			food.setCalories(90);
			food.setName("Tomatensuppe");
			food.setSugarContent(10);
			food.setCategory(foodCategoryDal.getDinner());
			food.setImageResource(R.drawable.ic_tomatensuppe);
			break;
		default:
			return null;
		}
		//TODO implement others
		
		return food;
	}

	@Override
	public void reset() {
		// nothing to do
	}
	
}

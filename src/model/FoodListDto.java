package model;
//Data transfer object, creating food list
import java.util.List;

public class FoodListDto {
	private List<FoodDto> list;

	public List<FoodDto> getList() {
		return list;
	}

	public void setList(List<FoodDto> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "FoodListDto [list=" + list + "]";
	}
	
}

package data;
//data access layer, setting the profile properties
import model.ProfileDto;

public class ProfileInformationDal  implements DalInterface{

	
	private static ProfileDto profile = new ProfileDto();
	
	
	/**
	 * Like the given food.
	 * @param foodId
	 */
	public void likeFood(Integer foodId){
		profile.getLikedFoodIds().add(foodId);
	}
	
	/**
	 * Unlike the given food.
	 * @param foodId
	 */
	public void unlikeFood(Integer foodId){
		profile.getLikedFoodIds().remove(foodId);
	}
	/**
	 * Dislike the given food.
	 * @param foodId
	 */
	public void dislikeFood(Integer foodId){
		profile.getDislikedFoodIds().add(foodId);
	}
	/**
	 * Undislike the given food.
	 * @param foodId
	 */
	public void undislikeFood(Integer foodId){
		profile.getDislikedFoodIds().remove(foodId);
	}


	/**
	 * Get the consumed calories.
	 * @return
	 */
	public int getConsumedCalories() {
		return profile.getCalories();
	}

	/**
	 * Set the consumed calories.
	 * @param consumedCalories
	 */
	public void setConsumedCalories(int consumedCalories) {
		profile.setCalories(profile.getCalories()+consumedCalories);
	}

	@Override
	public void reset() {
		profile.getDislikedFoodIds().clear();
		profile=new ProfileDto();
	}
	
	public ProfileDto getProfile(){
		return profile;
	}
}

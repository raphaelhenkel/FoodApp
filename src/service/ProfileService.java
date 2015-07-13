package service;
//contains business logic for ProfileActivity
import java.util.ArrayList;
import java.util.List;

import model.FoodDto;
import model.ProfileDto;
import data.ProfileInformationDal;

public class ProfileService {

	private ProfileInformationDal profileInformationDal = new ProfileInformationDal();
	
	/**
	 * Like the given food.
	 * @param foodId
	 */
	public void likeFood(Integer foodId){
		this.profileInformationDal.likeFood(foodId);
	}
	
	/**
	 * Unlike the given food.
	 * @param foodId
	 */
	public void unlikeFood(Integer foodId){
		this.profileInformationDal.unlikeFood(foodId);
	}
	
	/**
	 * Check if the given food is liked by the user.
	 * @param foodId
	 * @return
	 */
	public boolean isLiked(Integer foodId){
		//get profile
		ProfileDto profile = this.profileInformationDal.getProfile();
		if(profile!=null && profile.getLikedFoodIds()!=null){
			return profile.getLikedFoodIds().contains(foodId);
		}
		
		return false;
	}
	/**
	 * Dislike the given food.
	 * @param foodId
	 */
	public void dislikeFood(Integer foodId){
		this.profileInformationDal.dislikeFood(foodId);
	}
	/**
	 * Undislike the given food.
	 * @param foodId
	 */
	public void undislikeFood(Integer foodId){
		this.profileInformationDal.undislikeFood(foodId);
	}
	/**
	 * Check if the given food is disliked by the user.
	 * @param foodId
	 * @return
	 */
	public boolean isDisliked(Integer foodId){
		//get profile
		ProfileDto profile = this.profileInformationDal.getProfile();
		if(profile!=null && profile.getDislikedFoodIds()!=null){
			return profile.getDislikedFoodIds().contains(foodId);
		}
		return false;
	}
	
	public boolean consume(FoodDto food){
		if(food!=null){
			this.profileInformationDal.setConsumedCalories(food.getCalories());
			return true;
		}
		return false;
	}
	
	/**
	 * Get the profile of the current user.
	 */
	public ProfileDto getProfile(){
		return this.profileInformationDal.getProfile();
	}
	
	/**
	 * Save the given name to the profile.
	 * @param name
	 * @return
	 */
	public boolean saveName(String name){
		ProfileDto profile = this.profileInformationDal.getProfile();
		if(profile!=null){
			profile.setName(name);
			return true;
		}
		return false;
	}
}
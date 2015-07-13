package controller;

import model.FoodDto;
import service.FoodService;
import service.ProfileService;
import android.R.layout;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodapp_1.R;
/**
 * FoodApp
 * The right food recommendation at the right time
 *
 * @author  Ulrike Schulz, Alexander Wöhler, Raphael Henkel
 * @version 0.3 
 */
public class MainActivity extends Activity {

	private FoodService foodService = new FoodService();
	private ProfileService profileService = new ProfileService();
	
	private int currentFoodId =0;
	
	@Override
	protected void onStart() {
		super.onStart();
		
		this.loadFood(this.foodService.getRandom());
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	/** Called when the user clicks the refresh button */
	public void refreshButton(View view) {
		// starting generator
		FoodDto food=foodService.getRandom();
		
		this.loadFood(food);
	}
	
	/** Called when the user clicks the refresh button */
	private void loadFood(FoodDto foodToLoad) {
		if(foodToLoad==null){
			//TODO load default or show error
		}else{
			// set the name in the corresponding text view
			TextView textViewMealName = (TextView) findViewById(R.id.textViewMealName);
			textViewMealName.setText(foodToLoad.getName());
			
			// set the image
			ImageView imageView1 = (ImageView) findViewById(R.id.imageViewprofilbild);
	
			Bitmap bImage = BitmapFactory.decodeResource(this.getResources(),
					foodToLoad.getImageResource());
			imageView1.setImageBitmap(bImage);
			
			//disable back button when the first element has been loaded
			ImageButton backButton = (ImageButton) this.findViewById(R.id.imageButtonBack);
			if(this.foodService.isFirst(foodToLoad.getId())){
				backButton.setEnabled(false);
				backButton.setClickable(false);
			}else{
				backButton.setEnabled(true);
				backButton.setClickable(true);
			}
			
			//disable next button when the last element has been loaded
			ImageButton nextButton = (ImageButton) this.findViewById(R.id.imageButtonNext);
			if(this.foodService.isLast(foodToLoad.getId())){
				nextButton.setEnabled(false);
				nextButton.setClickable(false);
			}else{
				nextButton.setEnabled(true);
				nextButton.setClickable(true);
			}

			//load correct like image
			ImageButton likeButton = (ImageButton) this.findViewById(R.id.imageButtonLike);
			Bitmap likeImage = null;
			if(this.profileService.isLiked(foodToLoad.getId())){
				likeImage= BitmapFactory.decodeResource(this.getResources(),
						R.drawable.ic_action_good_green);
			}else{
				likeImage= BitmapFactory.decodeResource(this.getResources(),
						R.drawable.ic_action_good);
			}
			likeButton.setImageBitmap(likeImage);
			
			this.currentFoodId=foodToLoad.getId();
			
			//load correct dislike image
			ImageButton dislikeButton = (ImageButton) this.findViewById(R.id.imageButtonDislike);
			Bitmap dislikeImage = null;
			if(this.profileService.isDisliked(foodToLoad.getId())){
				dislikeImage= BitmapFactory.decodeResource(this.getResources(),
						R.drawable.ic_action_bad_red);
			}else{
				dislikeImage= BitmapFactory.decodeResource(this.getResources(),
						R.drawable.ic_action_bad);
			}
			dislikeButton.setImageBitmap(dislikeImage);
			
			this.currentFoodId=foodToLoad.getId();			
			
			//show KCAL
			TextView textViewKcal = (TextView) findViewById(R.id.textViewKcal);
			textViewKcal.setText("Kcal: "+foodToLoad.getCalories());
			
		}
	}

	/** Called when the user clicks the foreward button */
	public void forwardButton(View view) {
		FoodDto nextFood = this.foodService.getNext(this.currentFoodId);
		this.loadFood(nextFood);
	}

	/** Called when the user clicks the back button */
	public void backButton(View view) {
		FoodDto previousFood = this.foodService.getPrevious(this.currentFoodId);
		this.loadFood(previousFood);
		
	}

	/** Called when the user clicks the badbutton */
	public void badButton(View view) {
		CharSequence text= null;
		boolean isDisliked = this.profileService.isDisliked(this.currentFoodId);
		Context context = getApplicationContext();
		
		ImageButton dislikeButton = (ImageButton) this.findViewById(R.id.imageButtonDislike);
		Bitmap dislikeImage = null;
		
		if(isDisliked){
			this.profileService.undislikeFood(this.currentFoodId);
			text="Dieses Essen ist nun nicht mehr als Dislike gespeichert";
			dislikeImage= BitmapFactory.decodeResource(this.getResources(),
					R.drawable.ic_action_bad);
		}else{
			this.profileService.dislikeFood(this.currentFoodId);
			text="Dieses Essen ist nun als Dislike gespeichert";
			dislikeImage= BitmapFactory.decodeResource(this.getResources(),
					R.drawable.ic_action_bad_red);
		}
		//load correct image
		dislikeButton.setImageBitmap(dislikeImage);
		//CharSequence text = "Als unerwünscht gespeichert";
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}

	/** Called when the user clicks the goodbutton */
	public void goodButton(View view) {
		CharSequence text = null;
		boolean isLiked = this.profileService.isLiked(this.currentFoodId);
		Context context = getApplicationContext();
		
		ImageButton likeButton = (ImageButton) this.findViewById(R.id.imageButtonLike);
		Bitmap likeImage = null;
		
		if(isLiked){
			this.profileService.unlikeFood(this.currentFoodId);
			text="Dieses Essen ist nun nicht mehr als Favorit gespeichert";
			likeImage= BitmapFactory.decodeResource(this.getResources(),
					R.drawable.ic_action_good);
		}else{
			this.profileService.likeFood(this.currentFoodId);
			text="Dieses Essen ist nun als Favorit gespeichert";
			likeImage= BitmapFactory.decodeResource(this.getResources(),
					R.drawable.ic_action_good_green);
		}

		//load correct image
		likeButton.setImageBitmap(likeImage);
		
		//Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
		
	}

	/** Called when the user clicks the Accept button */
	public void acceptButton(View view) {

		FoodDto food = this.foodService.loadFood(this.currentFoodId);
		
		if(food!=null){
			
			if(this.profileService.consume(food)){
				Intent intent = new Intent(this, ProfileActivity.class);
				startActivity(intent);
			}else{
				CharSequence text= null;
				text="Leider ist ein Fehler aufgetreten.";
				int duration = Toast.LENGTH_SHORT;
				Context context = getApplicationContext();
				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
			}
			
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			//called when user clicks settings in the ActionBar
			int duration = Toast.LENGTH_SHORT;

			Context context=getApplicationContext();
			CharSequence text="Alles perfekt eingestellt!";
			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
			return true;

		}
		// Starting Profile Activity through touch on ActionBar 
		if (id == R.id.action_profile) {
			Intent intent = new Intent(this, ProfileActivity.class);
			startActivity(intent);
			return true;

		}

		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */

	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}

	}

}

package controller;

import com.example.foodapp_1.R;

import model.FoodDto;
import model.ProfileDto;
import service.FoodService;
import service.ProfileService;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class ProfileActivity extends Activity {

	private ProfileService profileService = new ProfileService();
	private FoodService foodService = new FoodService();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_profile);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		//load profile data
		ProfileDto myProfile = this.profileService.getProfile();
		if(myProfile!=null){
			//show kcal
			TextView textViewMealName = (TextView) findViewById(R.id.textViewKcalDisplay);
			textViewMealName.setText(myProfile.getCalories() + " kcal");
		
			//show likes
			String likesAsText = null;
			if(myProfile.getLikedFoodIds()==null|| myProfile.getLikedFoodIds().isEmpty()){
				likesAsText = "Keine Likes gefunden...";
			}else{
				likesAsText = "Likes: \n";
				for(Integer foodId : myProfile.getLikedFoodIds()){
					FoodDto food = foodService.loadFood(foodId);
					likesAsText+=" - "+food.getName()+"\n";
				}

			TextView textViewLikeDisplay = (TextView) findViewById(R.id.textViewLikeDisplay);
			textViewLikeDisplay.setText(likesAsText);
			
			//show name

			EditText editTextName = (EditText) findViewById(R.id.editTextName);
			editTextName.setText(myProfile.getName());
			}
			
			//show dislikes
			String dislikesAsText = null;
			if(myProfile.getDislikedFoodIds()==null|| myProfile.getDislikedFoodIds().isEmpty()){
				dislikesAsText = "Keine Dislikes gefunden...";
			}else{
				dislikesAsText = "Dislikes: \n";
				for(Integer foodId : myProfile.getDislikedFoodIds()){
					FoodDto food = foodService.loadFood(foodId);
					dislikesAsText+=" - "+food.getName()+"\n";
				}
			TextView textViewDislikeDisplay = (TextView) findViewById(R.id.textViewDislikeDisplay);
			textViewDislikeDisplay.setText(dislikesAsText);
				
			//show name

			EditText editTextName = (EditText) findViewById(R.id.editTextName);
			editTextName.setText(myProfile.getName());
			}
	}
			
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile, menu);
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
		}else if (id == R.id.action_main) {
			//called when user clicks mainActivity in the ActionBar
			Intent intent = new Intent(this, MainActivity.class);
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
			View rootView = inflater.inflate(R.layout.fragment_profile,
					container, false);
			return rootView;
		}
	}
	
	/** Called when the user clicks the Accept button */
	public void changeName(View view) {

		EditText editTextName = (EditText) findViewById(R.id.editTextName);
		String newName = editTextName.getText().toString();

		CharSequence text= null;
		
		if(this.profileService.saveName(newName)){
			text="Der Name wurde gespeichert.";
		}else{
			text="Der Name konnte nicht gespeichert werden.";
		}
		
		int duration = Toast.LENGTH_SHORT;
		Context context = getApplicationContext();
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
	}

}

package generator.name.spirit;

import java.util.Random;
import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	public TextView newName; 
	public TextView firstName;
	public TextView lastName;
	public String fullName;
	public Random rgenerator = new Random();
	public String[] randomNounList;
	public String[] randomDescriptorsList;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstName = (TextView) findViewById(R.id.firstNameText);
        lastName = (TextView) findViewById(R.id.lastNameText);
        
    }
    
    public void gen(View view){

    	if (firstName.getText().length() == 0 && lastName.getText().length() == 0) {
			Toast.makeText(this, "Please enter your first and last name", Toast.LENGTH_LONG).show();
			}
    	if (firstName.getText().length() == 0) {
			Toast.makeText(this, "Please enter your first name", Toast.LENGTH_LONG).show();
			}
    	if (lastName.getText().length() == 0) {
			Toast.makeText(this, "Please enter your last name", Toast.LENGTH_LONG).show();
			}
		else{
			Resources res = getResources();
			randomNounList = res.getStringArray(R.array.spiritNames);
			randomDescriptorsList = res.getStringArray(R.array.descriptors);
			String valFirstName = firstName.getText().toString();
			String valLastName = lastName.getText().toString();
			String nouns = randomNounList[rgenerator.nextInt(randomNounList.length)];
			String descriptors = randomDescriptorsList[rgenerator.nextInt(randomDescriptorsList.length)]; 
	    	TextView tv = (TextView) findViewById(R.id.newName);
	    	tv.setText(valFirstName + " " + descriptors + " " + nouns + " " + valLastName);}
    }
}

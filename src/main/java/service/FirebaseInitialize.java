package service;
import java.io.FileInputStream;
import java.util.concurrent.ExecutionException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.ExportedUserRecord;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

@Service
public class FirebaseInitialize {
	
	 public void getUserById(String uid) throws InterruptedException, ExecutionException{
		    // [START get_user_by_id]
			UserRecord userRecord = FirebaseAuth.getInstance().getUserAsync(uid).get();
		    // See the UserRecord reference doc for the contents of userRecord.
		   
		    System.out.println("Successfully fetched user data: " + userRecord.getUid());
			System.out.println("Successfully fetched user data: " + userRecord.getEmail());
					   

		    // [END get_user_by_id]
		  }
	 
	
	@PostConstruct
	public void initialize() {
		try {
		FileInputStream serviceAccount =
		  new FileInputStream("./serviceAccount.json");
		
		FirebaseOptions options = new FirebaseOptions.Builder()
		  .setCredentials(GoogleCredentials.fromStream(serviceAccount))
		  .setDatabaseUrl("https://community-housing-c73c2.firebaseio.com")
		  .build();
		
		FirebaseApp.initializeApp(options);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
				
	}

	
}

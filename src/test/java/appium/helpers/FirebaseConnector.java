package appium.helpers;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class FirebaseConnector {

    public FirebaseConnector() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("firebase_configuration_file.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https:/ljasdlfjljd.com/")
                .build();

        FirebaseApp.initializeApp();
    }

    public DatabaseReference getDatabaseReferenceForServerUp() {
        return FirebaseDatabase.getInstance().getReference().child("admin").child("serverup");
    }

    public boolean putServiceDown () {
        try {
            getDatabaseReferenceForServerUp().setValueAsync(false).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        } catch (ExecutionException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

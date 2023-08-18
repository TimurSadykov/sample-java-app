package com.mycompany.app;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import java.io.FileInputStream;
import java.io.IOException;

public class FirestoreSample {
  public void RunSample(String projectId) throws IOException {

    // ArrayList scopes = new ArrayList(ServiceAccountCredentials.fromStream(new FileInputStream("/Users/stim/Downloads/stellar-day-254222-3598ef2bb09b.json"))
    //     .getScopes());
    //
    // GoogleCredentials creds = ServiceAccountCredentials.fromStream(new FileInputStream("/Users/stim/Downloads/stellar-day-254222-3598ef2bb09b.json"))
    //     .createWithUseJwtAccessWithScope(true)
    //     .createScoped("https://www.googleapis.com/auth/datastore");
    //
    //GoogleCredentials creds = ServiceAccountCredentials.fromStream(new FileInputStream("/Users/stim/Documents/keys/stellar-day-254222-63ebb14d71fe.json")).createWithUseJwtAccessWithScope(true);
    GoogleCredentials creds = ServiceAccountCredentials.fromStream(new FileInputStream("/Users/stim/Documents/keys/gcloud-devel-stim-test-5aede6a71838.json")).createWithUseJwtAccessWithScope(true);

    Firestore fs = FirestoreOptions.getDefaultInstance().toBuilder()
        .setCredentials(creds)
        .setProjectId(projectId)
        .build()
        .getService();

    for (CollectionReference cr : fs.listCollections()) {
      System.out.printf("collection: %s\n", cr.getPath());
    }
  }
}

package com.mycompany.app;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class FirestoreSample {
  public void RunSample(String projectId) throws IOException {

    ArrayList scopes = new ArrayList(ServiceAccountCredentials.fromStream(new FileInputStream("/Users/stim/Downloads/stellar-day-254222-3598ef2bb09b.json"))
        .getScopes());

    GoogleCredentials creds = ServiceAccountCredentials.fromStream(new FileInputStream("/Users/stim/Downloads/stellar-day-254222-3598ef2bb09b.json"))
        .createWithUseJwtAccessWithScope(true)
        .createScoped("https://www.googleapis.com/auth/datastore");



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

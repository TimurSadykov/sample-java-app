package com.mycompany.app;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translation;
import com.google.cloud.translate.testing.RemoteTranslateHelper;
import java.io.FileInputStream;
import java.io.IOException;

public class TranslateSample {
  public void RunSample() throws IOException {
    GoogleCredentials creds = ServiceAccountCredentials.fromStream(new FileInputStream("/Users/stim/Documents/keys/gcloud-devel-stim-test-5aede6a71838.json")).createWithUseJwtAccessWithScope(false);

    RemoteTranslateHelper helper = RemoteTranslateHelper.create();
    Translate translate = helper.getOptions()
        .toBuilder()
        .setCredentials(creds)
        .build()
        .getService();

    Translation translation =
        translate.translate(
            "забабахано!",
            Translate.TranslateOption.sourceLanguage("ru"),
            Translate.TranslateOption.targetLanguage("en"),
            // Use "base" for standard edition, "nmt" for the premium model.
            Translate.TranslateOption.model("base"));

    System.out.printf("TranslatedText:\nText: %s\n", translation.getTranslatedText());
  }
}

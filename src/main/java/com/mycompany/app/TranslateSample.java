package com.mycompany.app;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.Translation;
import com.google.cloud.translate.testing.RemoteTranslateHelper;

public class TranslateSample {
  public void RunSample() {
    RemoteTranslateHelper helper = RemoteTranslateHelper.create();
    Translate translate = helper.getOptions().getService();
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

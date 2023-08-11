package com.mycompany.app;

import com.google.api.gax.paging.Page;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.logging.LogEntry;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.LoggingOptions;
import java.io.FileInputStream;

public class LoggingSample {
  public static void TryGetLogs() throws Exception {
    try (Logging logging = LoggingSample.getNewInstance()) {
      int count = 0;
      // List all log entries
      Page<LogEntry> entries = logging.listLogEntries();
      while (entries != null) {
        for (LogEntry logEntry : entries.iterateAll()) {
          System.out.println(logEntry);
          count++;
        }
        entries = entries.getNextPage();
      }
      System.out.println("Total:" + count);
    }
  }

  public static Logging getNewInstance() {
    try {
      GoogleCredentials creds = ServiceAccountCredentials.fromStream(new FileInputStream("/Users/stim/Documents/keys/stellar-day-254222-63ebb14d71fe.json")).createWithUseJwtAccessWithScope(true);

      return LoggingOptions.newBuilder()
          .setProjectId("stellar-day-254222")//api-6404308174320967819-640900
          .setCredentials(creds)
          .setQuotaProjectId("api-6404308174320967819-640900")
          .build()
          .getService();

    } catch (Exception e) {
      throw new RuntimeException("Client creation ex");
    }
  }
}

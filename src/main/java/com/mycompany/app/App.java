package com.mycompany.app;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception {
        String projectId = "stellar-day-254222";//"gcloud-devel";//


        //LoggingSample.TryGetLogs();
        new TranslateSample().RunSample();
        //new FirestoreSample().RunSample(projectId);
    }
}

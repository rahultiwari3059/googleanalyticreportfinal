package com.bridgelabz.controller;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.analyticsreporting.v4.AnalyticsReporting;
import com.google.api.services.analyticsreporting.v4.AnalyticsReportingScopes;

public class initializeAnalyticsReporting {
	
	private static final String APPLICATION_NAME = "Appystore test app";
	private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
	private static final String KEY_FILE_LOCATION = "/home/bridgeit/Desktop/springexp/HelloAnalytics/AppyGAReports-35a6c523765c.p12";
	private static final String SERVICE_ACCOUNT_EMAIL = "appystorereport@appygareports.iam.gserviceaccount.com";
	private static final String VIEW_ID = "ga:111820853";
	private static final Object POST_INDEX_PATH = null;
	public  AnalyticsReporting initializeAnalyticsReporting() throws GeneralSecurityException, IOException {

		HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
		GoogleCredential credential = new GoogleCredential.Builder().setTransport(httpTransport)
				.setJsonFactory(JSON_FACTORY).setServiceAccountId(SERVICE_ACCOUNT_EMAIL)
				.setServiceAccountPrivateKeyFromP12File(new File(KEY_FILE_LOCATION))
				.setServiceAccountScopes(AnalyticsReportingScopes.all()).build();
		// getting access token
		String refreshToken = null;
		credential.setRefreshToken(refreshToken);
		credential.refreshToken();
		// printing access token
		System.out.println(credential.getAccessToken());
		// printing
	//	Util u = new Util();

		// System.out.println(u.callURL("https://www.googleapis.com/analytics/v3/data/ga?ids=ga%3A111820853&start-date=2016-09-02&end-date=2016-09-05&metrics=ga%3AtotalEvents&dimensions=ga%3AeventCategory%2Cga%3Adimension1%2Cga%3Adate&filters=ga%3AeventCategory%3D%3DApp%20Open%3Bga%3Adimension15%3D%3D10&access_token="+credential.getAccessToken()));

		if (!credential.refreshToken()) {
			throw new RuntimeException("Failed OAuth to refresh the token");
		}
		// Construct the Analytics Reporting service object.
		return new AnalyticsReporting.Builder(httpTransport, JSON_FACTORY, credential)
				.setApplicationName(APPLICATION_NAME).build();
	}

}

package seriFileUp.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

public class postDate {

	public byte[] getPayloadResponse(String targetUrl, String contentType,
			byte[] payload) throws IOException, ClassNotFoundException {
		CloseableHttpClient httpClient = getHttpClient();
		HttpPost httpPost = new HttpPost(targetUrl);
		httpPost.setEntity(new ByteArrayEntity(payload, ContentType
				.create(contentType)));
		HttpResponse response = httpClient.execute(httpPost);
		byte[] result = input2byte(response.getEntity().getContent());
		return result;
	}
}

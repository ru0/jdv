package seriFileUp.test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class CommandTask {
	//final String targetUrl;
	final String commands;
	boolean isUploadTempFile = false;
	GeneratePayload generatePayload = GeneratePayload.getInstance();

	public CommandTask(String commands,
			boolean isUploadTempFile) {
		this.commands = commands;
		//this.targetUrl = targetUrl;
		this.isUploadTempFile = isUploadTempFile;
	}

	protected byte[] call() throws Exception {

		//byte[] classofByte = this.generatePayload.writeTempClassFile();
		byte[] payload = this.generatePayload.getPayload(this.commands);
		
		//System.out.print(this.commands);
		//String s = new String(payload);
		//System.out.print(s);
		return payload;
	}
}

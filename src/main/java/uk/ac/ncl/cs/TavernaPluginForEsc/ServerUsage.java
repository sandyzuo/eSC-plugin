package uk.ac.ncl.cs.TavernaPluginForEsc;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

import javax.swing.text.Document;


import uk.org.taverna.server.client.OutputPort;
import uk.org.taverna.server.client.Run;
import uk.org.taverna.server.client.Server;
import uk.org.taverna.server.client.connection.HttpBasicCredentials;
import uk.org.taverna.server.client.connection.UserCredentials;

public class ServerUsage {
	
	File tempWorkflowFile;
	File tempInputFile;
	String uri = "http://localhost:8080/TavernaServer.2.4";
	File f = new File("output");
	
	public File Usage() throws URISyntaxException, IOException, InterruptedException{
		String t2="";
		//connect server
		URI hostnameUri = new URI(uri);
		
		Server server = Server.connect(hostnameUri);
		UserCredentials credentials = new HttpBasicCredentials("taverna", "taverna");
		System.out.println("connected..");
		
		File workflowFile = new File(tempWorkflowFile.toString());
		File inputFile = new File(tempInputFile.toString());
		
		Run run = server.createRun(workflowFile, credentials);
		
		Set<String> inputSet = run.getInputPorts().keySet();
		Iterator<String> it = inputSet.iterator();
		while(it.hasNext()) {
			String s = it.next();
			run.getInputPort(s).setFile(inputFile);		
			}
		if(!run.getInputPorts().isEmpty()){
			
			run.start();
			System.out.println(run.getStatus());
			Thread.currentThread().sleep(20000);
			System.out.println(run.getStatus());
			System.out.println("is empty:"+run.getOutputPorts().isEmpty());
			Collection<OutputPort> outputValue = run.getOutputPorts().values();

			String t = outputValue.toString();
			String t1 = t.replaceAll("\\[", "");
			t2 = t1.replaceAll("\\]", "");
			//File f = null;
		    try{
		    	  // Create file
		    	  
		    	  FileWriter fstream = new FileWriter(f);
		    	  BufferedWriter out = new BufferedWriter(fstream);
		    	  out.write(t2);
		    	  //Close the output stream
		    	  out.close();
		    	  }catch (Exception e){
		    	  System.err.println("Error: " + e.getMessage());
		    	  }
		    
		}
		return f;
	}

	public File getTempWorkflowFile() {
		return tempWorkflowFile;
	}

	public void setTempWorkflowFile(File tempWorkflowFile) {
		this.tempWorkflowFile = tempWorkflowFile;
	}

	public File getTempInputFile() {
		return tempInputFile;
	}

	public void setTempInputFile(File tempInputFile) {
		this.tempInputFile = tempInputFile;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

}

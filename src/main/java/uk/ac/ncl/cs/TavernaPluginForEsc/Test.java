package uk.ac.ncl.cs.TavernaPluginForEsc;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;

public class Test {
public static void main(String[] ags) throws URISyntaxException, IOException, InterruptedException {
		
		ServerUsage serverUsage = new ServerUsage();
		serverUsage.setUri("http://tavernaplugin.elasticbeanstalk.com");
		//http://sandytaverna.elasticbeanstalk.com
		//http://127.0.0.1:8080/TavernaServer.2.4
		File temFile = new File("/Users/xiyuzuo/Documents/Final_Project/workflows_Taverna/PC1-mockup-testInputs.xml");
		serverUsage.setTempInputFile(temFile);
		File temFile2 = new File("/Users/xiyuzuo/Documents/Final_Project/workflows_Taverna/Provenance_Challenge_1_workflow____mockup_version.t2flow");
		//valueTest.t2flow
		//Provenance_Challenge_1_workflow____mockup_version.t2flow
		serverUsage.setTempWorkflowFile(temFile2);
		File s = serverUsage.Usage();
		
//		String s = serverUsage.Usage();
//		String FileName = "workflow" + System.currentTimeMillis();
//		String SavedFilePath = "/Users/xiyuzuo/savedFile/";
//		BufferedWriter bf = null;
//		try {			
//				bf = new BufferedWriter(new FileWriter(SavedFilePath + FileName));
//				bf.write(s,0,s.length());
//				bf.flush();
//			} catch(IOException e) {
//
//			}
		
		System.out.println(s.isFile());
		
		System.out.println("done");
	}

}

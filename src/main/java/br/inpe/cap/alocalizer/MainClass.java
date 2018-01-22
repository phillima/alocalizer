package br.inpe.cap.alocalizer;

import java.nio.file.Path;

public class MainClass {

	public static void main(String[] args) {
			
		ALocalizerInitializer al = new ALocalizerInitializer();
		Path outputPath = java.nio.file.Paths.get(args[0]);
		boolean directoryExists = java.nio.file.Files.exists(outputPath);
		if(directoryExists)
			al.start(outputPath.toString());
		else {
			System.out.println("Please inform a valid directory");
			System.out.println(args[0] + "is not a valid directory.");
		}
			
	}

}

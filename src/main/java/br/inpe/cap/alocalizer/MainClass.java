package br.inpe.cap.alocalizer;

import java.nio.file.Paths;

import br.inpe.cap.alocalizer.utils.FileUtils;

public class MainClass {

	public static void main(String[] args) {
			
		ALocalizerInitializer al = new ALocalizerInitializer();
		al.start("/Users/phillima/Documents/project");
		
		//FileUtils.getAllJavaFiles("/Users/phillima/Documents/project");
	}

}

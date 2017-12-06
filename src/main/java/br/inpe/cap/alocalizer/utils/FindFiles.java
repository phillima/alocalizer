package br.inpe.cap.alocalizer.utils;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class FindFiles extends SimpleFileVisitor<Path>{

	private List<String> files;
	
	public FindFiles() {
		files = new ArrayList<>();
	}
	
    @Override
    public FileVisitResult visitFile(Path file,
                                   BasicFileAttributes attr) {
       if (attr.isRegularFile() && file.toString().contains(".java"))
    	   		files.add(file.toString());
            //System.out.format("Regular file: %s ", file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir,
                                          IOException exc) {
        //System.out.format("Directory: %s%n", dir);
        return FileVisitResult.CONTINUE;
    }
	
    public List<String> getFiles() {
    		return this.files;
    }
}



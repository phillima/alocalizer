package br.inpe.cap.alocalizer.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtils {

	public static String extractFinalWord(String path) {
		
		int lastIndex = path.lastIndexOf("/");
		
		if(lastIndex != -1)
			return path.substring(lastIndex+1);
		else
			return path;
	}
	
	public static String[] getAllDirs(String path) {
		ArrayList<String> dirs = new ArrayList<String>();
		getAllDirs(path, dirs);
		
		String[] ar = new String[dirs.size()];
		ar = dirs.toArray(ar);
		return ar;
	}
	
	private static void getAllDirs(String path, ArrayList<String> dirs) {
		
		File f = new File(path);
		if(f.getName().equals(".git")) return;
		
		for(File inside : f.listFiles()) {
			if(inside.isDirectory()) {
				String newDir = inside.getAbsolutePath();
				dirs.add(newDir);
				getAllDirs(newDir, dirs);
			}
		}
	}
	
	
	public static String readFileAsString (String filePath)
	{
	    StringBuilder contentBuilder = new StringBuilder();
	    try (Stream<String> stream = Files.lines( Paths.get(filePath), StandardCharsets.UTF_8))
	    {
	        stream.forEach(s -> contentBuilder.append(s).append("\n"));
	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	    return contentBuilder.toString();
	}
	
	public static String readFileAsString (Path filePath)
	{
	    return readFileAsString(filePath.toString());
	}
	
	
	public static List<Path> findFiles(String path) {
		
		List<Path> files = new ArrayList<Path>();
		try {
			Files.list(Paths.get(path))
	             .forEach(files::add);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return files;
	}
	
	public static List<Path> findFiles(Path path) {
			
		return findFiles(path.toString());
	}

	public static List<Path> listProjects(String path) {
		List<Path> subfolder = new ArrayList<>();
		try {
			Files.list(Paths.get(path))
			        .filter(Files::isDirectory)
			        .forEach(subfolder::add);
		} catch (IOException e) {
		}
		
		return subfolder;
	}
	
	public static String[] getAllJavaFiles(String path) {
		ArrayList<String> files = new ArrayList<String>();
		getAllJavaFiles(path, files);
		
		String[] ar = new String[files.size()];
		ar = files.toArray(ar);
		return ar;
	}
	
	private static void getAllJavaFiles(String path, ArrayList<String> files) {
		
		File f = new File(path);
		if(f.getName().equals(".git")) return;
		
		for(File inside : f.listFiles()) {
			if(inside.isDirectory()) {
				String newDir = inside.getAbsolutePath();
				getAllJavaFiles(newDir, files);
			} else if(inside.getAbsolutePath().toLowerCase().endsWith(".java")) {
				files.add(inside.getAbsolutePath());
			}
		}
	}
}

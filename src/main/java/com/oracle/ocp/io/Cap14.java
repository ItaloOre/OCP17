package com.oracle.ocp.io;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * @author Italo Oré
 * 
 * Chapter 14 I/O 
 * 
 */
public class Cap14 {

	public static void main(String[] args) throws IOException {

		io();
		nio();

	}

	public static void io() {
		var file = new File("C:\\data\\zoo.txt");
		if (file.exists()) {
			System.out.println("Absolute Path: " + file.getAbsolutePath());
			System.out.println("Is Directory: " + file.isDirectory());
			System.out.println("Parent Path: " + file.getParent());
			if (file.isFile()) {
				System.out.println("Size: " + file.length());
				System.out.println("Last Modified: " + file.lastModified());
			} else {
				for (File subfile : file.listFiles()) {
					System.out.println(" " + subfile.getName());
				}
			}
		}
	}

	public static void nio() throws IOException {
		var path = Path.of("C:\\data\\zoo.txt");
		if (Files.exists(path)) {//Recuerda que un .txt puede ser una carpeta
			System.out.println("Absolute Path: " + path.toAbsolutePath());
			System.out.println("Is Directory: " + Files.isDirectory(path));
			System.out.println("Parent Path: " + path.getParent());
			if (Files.isRegularFile(path)) {
				System.out.println("Size: " + Files.size(path));
				System.out.println("Last Modified: " + Files.getLastModifiedTime(path));
			} else {
				try (Stream<Path> stream = Files.list(path)) {
					stream.forEach(p -> System.out.println(" " + p.getFileName()));
				}
			}
		}
	}

}

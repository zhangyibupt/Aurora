package aurora.test.benchmark;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.junit.Test;

import aurora.filesystem.FileSystem;
import aurora.filesystem.FileSystemFactory;

public class WriteTest {

	@Test
	public void testWriteSmallFile() {
		System.out.println("Preparing...");
		int size = 1024 * 64;
		int count = 2048;
		Random random = new Random();
		byte[] content = new byte[size];
		random.nextBytes(content);
		FileSystem fileSystem = FileSystemFactory.getFileSystem("local");
		File file = new File("temp");
		List<String> fileNames = new ArrayList<String>();
		if (!file.exists()) {
			file.mkdir();
		}
		System.out.println("Running...");
		Date before = new Date(System.currentTimeMillis());
		int i = 0;
		for (i = 0; i < count; i++) {
			String fileName = "temp/" + UUID.randomUUID() + ".bin";
			fileNames.add(fileName);
			fileSystem.getFileWriter().writeToFile(
					fileSystem.getPath(fileName), content);
		}
		Date after = new Date(System.currentTimeMillis());
		System.out.println("Total time: "
				+ (after.getTime() - before.getTime()));
		System.out.println("Speed (byte / sec): " + size * count
				/ (after.getTime() - before.getTime()));
		System.out.println("Cleaning up...");
		for (String name : fileNames) {
			File toDelete = new File(name);
			toDelete.delete();
		}
		file.delete();
		System.out.println("Finished");
	}
}

package aurora.filesystem.local;

import java.io.FileOutputStream;

import aurora.filesystem.FileWriter;
import aurora.filesystem.Path;

public class LocalFileWriter implements FileWriter {

	public boolean writeToFile(Path path, byte[] content) {
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(path.getPath());
			fileOutputStream.write(content);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (fileOutputStream != null) {
					fileOutputStream.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

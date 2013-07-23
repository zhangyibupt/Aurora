package aurora.filesystem.local;

import aurora.filesystem.FileReader;
import aurora.filesystem.FileSystem;
import aurora.filesystem.FileWriter;
import aurora.filesystem.Path;

public class LocalFileSystem implements FileSystem {

	public Path getPath(String path) {
		LocalPath localPath = new LocalPath();
		localPath.setPath(path);
		return localPath;
	}

	public FileReader getFileReader() {
		return new LocalFileReader();
	}

	public FileWriter getFileWriter() {
		return new LocalFileWriter();
	}
}

package aurora.filesystem;

import aurora.filesystem.local.LocalFileSystem;

public class FileSystemFactory {
	public static FileSystem getFileSystem(String name) {
		if (name.toLowerCase().equals("local")) {
			return new LocalFileSystem();
		}
		return null;
	}
}

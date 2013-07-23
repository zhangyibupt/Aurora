package aurora.filesystem;

public interface FileSystem {
	// TODO
	public Path getPath(String path);

	public FileReader getFileReader();

	public FileWriter getFileWriter();
}

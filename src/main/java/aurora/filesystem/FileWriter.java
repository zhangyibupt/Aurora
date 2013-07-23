package aurora.filesystem;

public interface FileWriter {
	public boolean writeToFile(Path path, byte[] content);
}

package aurora.filesystem.local;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

import aurora.filesystem.FileReader;
import aurora.filesystem.Path;

public class LocalFileReader implements FileReader {

	public byte[] readFromFile(Path path) {
		FileInputStream fileInputStream = null;
		ByteArrayOutputStream byteArrayOutputStream = null;
		try {
			fileInputStream = new FileInputStream(path.getPath());
			byteArrayOutputStream = new ByteArrayOutputStream(1024);
			byte[] temp = new byte[1024];
			int size = 0;
			while ((size = fileInputStream.read(temp)) != -1) {
				byteArrayOutputStream.write(temp, 0, size);
			}
			return byteArrayOutputStream.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (fileInputStream != null) {
					fileInputStream.close();
				}
				if (byteArrayOutputStream != null) {
					byteArrayOutputStream.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

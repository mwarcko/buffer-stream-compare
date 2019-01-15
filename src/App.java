import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class App {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Long dateBufferStart = new Date().getTime();
		copyFileWithBuffer("C:\\ressources", "photo.jpg", "photoBuffer.jpg");
		Long dateBufferEnd = new Date().getTime();
		Long dateWithoutBufferStart = new Date().getTime();
		copyFile("C:\\ressources", "photo.jpg", "photoWithoutBuffer.jpg");
		Long dateWithoutBufferEnd = new Date().getTime();
		Long bufferTime = dateBufferEnd-dateBufferStart;
		Long withoutBufferTime = dateWithoutBufferEnd-dateWithoutBufferStart;
		System.out.println("temps avec buffer: " + bufferTime.toString());
		System.out.println("temps sans buffer: " + withoutBufferTime.toString());
	}

	public static void copyFileWithBuffer(String currentDirectory, String param1, String param2) throws IOException {
		File fileToRead = new File(currentDirectory + "\\" + param1);
		File fileToWrite = new File(currentDirectory + "\\" + param2);
		fileToWrite.createNewFile();
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			fis = new FileInputStream(fileToRead);
			fos = new FileOutputStream(fileToWrite);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fos);
			int data;
			while ((data = bis.read()) >= 0) {
				bos.write(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (bis != null) {
				try {
					bis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void copyFile(String currentDirectory, String param1, String param2) throws IOException {
		File fileToRead = new File(currentDirectory + "\\" + param1);
		File fileToWrite = new File(currentDirectory + "\\" + param2);
		fileToWrite.createNewFile();
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream(fileToRead);
			fos = new FileOutputStream(fileToWrite);
			int data;
			while ((data = fis.read()) >= 0) {
				fos.write(data);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	
}

package tw.ed.j2ee;

public class BradAPI {
	public static String getHeaderFilename(String header) {
		int start = header.indexOf("filename");
		String temp = header.substring(start + 10);
		String filename = temp.substring(0, temp.lastIndexOf("\""));
		int s1 = filename.lastIndexOf("\\");
		String sfile = null;
		if(s1 > 0) {
			sfile = filename.substring(
					filename.lastIndexOf("\\"));
		}else {
			sfile = filename;
		}
		return sfile;
		
	}
}

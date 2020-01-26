package org.cdqt.night.tools.file;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * IoUtil
 *
 * @author LiuGangQiang Create in 2020/01/26
 */
public class IoUtil {
	/** 
	 * toByteArray
	 *
	 * @author LiuGangQiang Create in 2020/01/26
	 * @param input
	 * @return
	 * @throws IOException
	 */
	public static byte[] toByteArray(InputStream input) throws IOException {
	    ByteArrayOutputStream output = new ByteArrayOutputStream();
	    byte[] buffer = new byte[4096];
	    int n = 0;
	    while (-1 != (n = input.read(buffer))) {
	        output.write(buffer, 0, n);
	    }
	    return output.toByteArray();
	}
}

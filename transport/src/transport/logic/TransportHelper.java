package transport.logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * <p>Title: Festival Logistics System</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class TransportHelper {
  public TransportHelper() {
  }

  public static String[] getDirections(){
    return new String[]{"N/A","Airport-Festival", "Airport-Hotel", "Festival-Hotel", "Festival-Airport", "Hotel-Festival", "Hotel-Airport"};
  }

  public static byte[] getBytesFromFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);

        // Get the size of the file
        long length = file.length();

        // You cannot create an array using a long type.
        // It needs to be an int type.
        // Before converting to an int type, check
        // to ensure that file is not larger than Integer.MAX_VALUE.
        if (length > Integer.MAX_VALUE) {
            // File is too large
        }

        // Create the byte array to hold the data
        byte[] bytes = new byte[(int)length];

        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
               && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }

        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not read:"+file.getName());
        }

        // Close the input stream and return bytes
        is.close();
        return bytes;
    }

    public static String createHTMLFileFromTransport(Transport transport){
      final File htmlFile = new File("transport" + transport.getId() + ".html");
      try {
        BufferedWriter bw = new BufferedWriter(new FileWriter(htmlFile));
        String line = null;
        line = transport.toHTML();
        bw.write(line);
        bw.newLine();
        // Close the file
        bw.close();
      }
      catch (Exception ex) {
        System.out.println(ex);
        return null;
      }
      return htmlFile.getName();
    }


}
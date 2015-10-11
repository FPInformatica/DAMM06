/*
Java - The Complete Reference 9th Edition (pp.314,649)
Beginning with JDK 7, there are two basic ways in which you can close a stream. The
first is to explicitly call close( ) on the stream. This is the traditional approach that has been
used since the original release of Java. With this approach, close( ) is typically called within
a finally block. Thus, a simplified skeleton for the traditional approach is shown here:
    try {
        // open and access file
    } catch( I/O-exception) {
        // ...
    } finally {
        // close the file
    }
This general technique (or variation thereof) is common in code that predates JDK 7.
*/

/* Copy a file.
To use this program, specify the name
of the source file and the destination file.
For example, to copy a file called FIRST.TXT
to a file called SECOND.TXT, use the following
command line.
java CopyFile FIRST.TXT SECOND.TXT
 */

import java.io.*;

class trycatchfinally {
	public static void main(String args[]) throws IOException {
		int i;
		FileInputStream fin = null;
		FileOutputStream fout = null;

		// First, confirm that both files have been specified.
		if(args.length != 2) {
			System.out.println("Usage: CopyFile from to");
			return;
		}

		// Copy a File.
		try {
			// Attempt to open the files.
			fin = new FileInputStream(args[0]);
			fout = new FileOutputStream(args[1]);
			
			do {
				i = fin.read();
				if(i != -1) fout.write(i);
			} while(i != -1);
			
		} catch(IOException e) {
			System.out.println("I/O Error: " + e);
		} finally {
			try {
				if(fin != null) fin.close();
			} catch(IOException e2) {
				System.out.println("Error Closing Input File");
			}
			
			try {
				if(fout != null) fout.close();
			} catch(IOException e2) {
				System.out.println("Error Closing Output File");
			}
		}
	}
}

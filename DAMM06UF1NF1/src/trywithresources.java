/*
Java - The Complete Reference 9th Edition (pp.317,649)
The second approach to closing a stream is to automate the process by using the
try-with-resources statement that was added by JDK 7 (and, of course, supported by JDK 8).
The try-with-resources statement is an enhanced form of try that has the following form:
    try (resource-specification) {
        // use the resource
    }
Here, resource-specification is a statement or statements that declares and initializes a
resource, such as a file or other stream-related resource. It consists of a variable declaration
in which the variable is initialized with a reference to the object being managed. When the try
block ends, the resource is automatically released. In the case of a file, this means that
the file is automatically closed. Thus, there is no need to call close( ) explicitly.
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

class trywithresources {
	public static void main(String args[]) throws IOException {
		int i;
		
		// First, confirm that both files have been specified.
		if(args.length != 2) {
			System.out.println("Usage: CopyFile from to");
			return;
		}
		
		// Open and manage two files via the try statement.
		try (FileInputStream fin = new FileInputStream(args[0]);
		     FileOutputStream fout = new FileOutputStream(args[1]))
		{
			do {
				i = fin.read();
				if(i != -1) fout.write(i);
			} while(i != -1);
		} catch(IOException e) {
			System.out.println("I/O Error: " + e);
		}
	}
}
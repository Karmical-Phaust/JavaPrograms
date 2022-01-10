package main_programs;

import java.io.*;
import java.nio.file.*;
import nodes_and_data_structures.*;

public class IO_program {
	
	//đọc dữ liệu từ file:
	public static String[] inputReadFromFiles(String l) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(l)));
            String currLine;
            Path p = Paths.get(l);
            int c = (int)Files.lines(p).count();
            String[] res = new String[c];
            int i = 0;
            while((currLine = br.readLine()) != null) {
                res[i] = currLine;
                i++;
            }
            br.close();
            return res;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
	
	//ghi dữ liệu ra file:
	public static void outputWriteToFiles(String l, Linked_list a) {
		
		try {
			
			PrintStream p = new PrintStream(new FileOutputStream(new File(l)));
			p.print(a);
			p.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
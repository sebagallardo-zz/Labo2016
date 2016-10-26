package cinco;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ProbandoStram {
	public static void main(String[] args) {
		String fileName = "/tmp/hola";
		List<String[]> list = new ArrayList<>();
		
		try (Stream<String> stream = Files.lines(Paths.get(fileName))){
			
//			stream.forEach(System.out::println);
			
			list = stream
					.map(s -> s.split(":"))
					.collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		int columnas = list.get(0).length;
		
		String[] cn = list.get(0);
		
		DefaultTableModel model = new DefaultTableModel(cn, list.size());
		JTable table = new JTable(model);
		list.forEach(s -> model.addRow(s));
		
				
		
	}


}



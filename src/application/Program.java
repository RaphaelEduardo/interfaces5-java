package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);

		//Lista de funcionários.
		List<Employee> list = new ArrayList<>();
		
		//Local do arquivo txx que vai ser lido
		String path = "C:\\temp\\teste.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			//armazena a linha do arquivo.
			String employeeCsv = br.readLine();
			
			//while para percorrer as linhas do arquivo.
			while (employeeCsv != null) {
				
				//vetor de string que separa a posição por virgula (nome, salario).
				String[] fields = employeeCsv.split(","); 
				
				/*
				 * nome na pos[0] e salario na pos[1] 
				 * Double.parseDouble para realizar a conversão do string.
				*/
				list.add(new Employee(fields[0], Double.parseDouble(fields[1])));
				employeeCsv = br.readLine();
			}
			Collections.sort(list);
			for (Employee emp : list) {
				System.out.println(emp.getName() + ", R$ " + String.format("%.2f", emp.getSalary()));
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}

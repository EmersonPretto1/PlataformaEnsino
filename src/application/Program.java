package application;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Lesson;
import entities.Task;
import entities.Video;

public class Program {

	public static void main(String[] args)throws ParseException {
		
		Scanner sc = new Scanner(System.in);
		List<Lesson> list = new ArrayList<>();
		
		System.out.print("Quantas aulas tem o curso: ");
		int n = sc.nextInt();
		System.out.println();
		
		for(int i = 1; i <=n; i++) {
			System.out.println("Dados da " + i + "a aula:");
			System.out.print("Conteúdo ou tarefa (c/t)? ");
			char type = sc.next().charAt(0);
			System.out.print("Titulo: ");
			String title = sc.next();
			sc.nextLine();
			
			if(type == 'c') {
				System.out.print("Url do vídeo: ");
				String url = sc.nextLine();
				System.out.print("Duração em segundos: ");
				
				int durat = sc.nextInt();
				list.add(new Video(title, url, durat));
			}else if(type == 't') {
				System.out.print("Descrição: ");
				String descript = sc.nextLine();
				System.out.print("Quantidade de questões: ");
				int questions = sc.nextInt();
				list.add(new Task(title, descript, questions));
			}
			System.out.println();
		}
		
		int totalDurationVideo = 0;
		int totalDurationTask = 0;

		for (Lesson le : list) {
		    int dur = le.duration();
		    if (le instanceof Video) {
		        totalDurationVideo += dur;
		    } else if (le instanceof Task) {
		        totalDurationTask += dur;
		    }
		}
		
		System.out.println("DURAÇÂO TOTAL DO CURSO = " + (totalDurationVideo + totalDurationTask)+ " segundos");
		

		
	
		
		
	}

}

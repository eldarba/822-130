package jbt.task3.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Program {

	private static final Scanner sc = new Scanner(System.in);
	private static int nextTaskId = 1;

	public static Task getTaskFromUser() {
		System.out.print("enter task description: ");
		String description = sc.nextLine();
		System.out.print("enter time: hh:mm:ss  ");
		String time = sc.nextLine(); // "10:15:30"
		LocalDateTime deadline = LocalDateTime.of(LocalDate.now(), LocalTime.parse(time));
		Task task = new Task(nextTaskId++, description, deadline);
		return task;
	}

	public static void main(String[] args) throws InterruptedException {
		Scheduler scheduler = new Scheduler();

		try {
			scheduler.startMonitoringTasks();

			while (true) {
				System.out.println("add task");
				scheduler.addTask(getTaskFromUser());
				scheduler.displayTasks();
				System.out.println("enter 1 to add or q to quit");
				String input = sc.nextLine();
				if (input.equals("q")) {
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scheduler.stopMonitoringTasks();
			sc.close();
			System.out.println("Bye");
		}

	}

}

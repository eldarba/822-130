package jbt.task3.api.ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

import jbt.task3.api.Scheduler;
import jbt.task3.api.Task;

public class TaskSchedulerApplication2 {

	private Scheduler scheduler = new Scheduler();
	private Scanner scanner = new Scanner(System.in);
	private boolean quit;

	public static void main(String[] args) {

		TaskSchedulerApplication2 app = new TaskSchedulerApplication2();
		app.start();

	}

	private void showMenu() {
		System.out.println("\n=== menu ===");
		System.out.println("add task ................ 1 / add");
		System.out.println("remove task ............. 2 / del");
		System.out.println("quit .................... 0 / q");
		System.out.println("=== ==== ===");

	}

	private void start() {

		scheduler.startMonitoringTasks(); // starts the thread
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		while (!quit) {
			try {
				showMenu();
				System.out.print("add your choice: ");
				String request = scanner.nextLine();

				switch (request) {
				case "0":
				case "q":
					doQuit();
					break;
				case "1":
				case "add":
					doAdd();
					break;

				default:
					System.out.println("the request " + request + " is not supported");
					break;
				}
			} catch (Exception e) {
//				e.printStackTrace(); // for debug only
				System.out.println("Error: " + e.getMessage());
			}
		}
	}

	private void doAdd() throws Exception {
		System.out.print("enter task id: ");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.print("enter task description: ");
		String description = scanner.nextLine();
		System.out.println("enter deadline [hh:mm:ss]");
		LocalDateTime deadline = LocalDateTime.of(LocalDate.now(), LocalTime.parse(scanner.nextLine()));
		Task task = new Task(id, description, deadline);
		scheduler.addTask(task);
		System.out.println("task added: " + task);
	}

	private void doQuit() {
		scanner.close();
		this.quit = true;
		scheduler.stopMonitoringTasks(); // stop the thread
		System.out.println("Bye");

	}

}

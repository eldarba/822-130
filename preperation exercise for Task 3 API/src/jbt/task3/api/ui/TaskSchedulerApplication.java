package jbt.task3.api.ui;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

import jbt.task3.api.Scheduler;
import jbt.task3.api.Task;

public class TaskSchedulerApplication {

	private Scheduler s = new Scheduler();
	private Scanner sc = new Scanner(System.in);
	private boolean quite;

	public static void main(String[] args) {

		TaskSchedulerApplication app = new TaskSchedulerApplication();
		app.start();

	}

	public void start() {
		s.startMonitoringTasks();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		while (!quite) {
			menu();
			handleRequest();
		}
	}

	public void menu() {
		System.out.println("\nmenu");
		System.out.println("add task ............ 1 / add");
		System.out.println("display tasks ....... 2 / disp");
		System.out.println("remove task ......... 3 / del");
		System.out.println("quit ................ 0 / q");
		System.out.println("=====================================");
	}

	private void handleRequest() {
		try {
			System.out.println("enter your choice:");
			String command = sc.nextLine();
			switch (command) {
			case "0":
			case "q":
				stop();
				break;
			case "1":
			case "add":
				doAdd();
				break;
			case "2":
			case "disp":
				doDisplay();
				break;
			case "3":
			case "del":
				doRemove();
				break;

			default:
				break;
			}

		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	private void doRemove() throws Exception {
		System.out.print("enter task id to remove: ");
		int taskId = Integer.parseInt(sc.nextLine());
		s.removeTask(taskId);
		System.out.println("task removed");
	}

	private void doDisplay() {
		s.displayTasks();
	}

	private void doAdd() {
		System.out.print("enter task id: ");
		int id = Integer.parseInt(sc.nextLine());
		System.out.print("enter task description: ");
		String description = sc.nextLine();
		System.out.print("enter task deadline time [hh:mm:ss]: ");
		LocalDateTime deadline = LocalDateTime.of(LocalDate.now(), LocalTime.parse(sc.nextLine()));
		Task task = new Task(id, description, deadline);
		s.addTask(task);
	}

	public void stop() {
		s.stopMonitoringTasks();
		sc.close();
		quite = true;
		System.out.println("bye");
	}

}

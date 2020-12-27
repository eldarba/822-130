package tests;

import java.time.LocalDateTime;

import jbt.task3.api.Scheduler;
import jbt.task3.api.Task;

public class Test1AddTask {

	public static void main(String[] args) {

		try {

			Scheduler scheduler = new Scheduler();
			scheduler.addTask(new Task(111, "test desc", LocalDateTime.of(2020, 5, 25, 10, 5)));
			System.out.println("task added");
			System.out.println(scheduler.getTask(111));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

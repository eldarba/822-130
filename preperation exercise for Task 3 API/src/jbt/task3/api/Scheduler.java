package jbt.task3.api;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Scheduler {

	private List<Task> tasks = new ArrayList<Task>();
	private boolean monitoringActive;
	private long checkRateMilis = 1000;

	public void addTask(Task task) {
		tasks.add(task);
	}

	public void removeTask(int taskId) throws Exception {
		Task taskToRemove = new Task(taskId, null, null);
		if (!tasks.remove(taskToRemove)) {
			throw new Exception("removing task id " + taskId + " failed: not found");
		}

	}

	public void displayTasks() {
		System.out.println("===== All Tasks Display =====");
		for (Task task : tasks) {
			System.out.println(task);
		}
		System.out.println("===== ================= =====");
	}

	public Task getTask(int taskId) {
		Task taskToFetch = new Task(taskId, null, null);
		int index = tasks.indexOf(taskToFetch);
		if (index != -1) {
			return tasks.get(index);
		} else {
			return null;
		}
	}

	public List<Task> getAllTasks() {
		return tasks;
	}

	public List<Task> getAllTasksDueUntil(LocalDateTime deadline) {
		List<Task> dueTasks = new ArrayList<Task>();
		for (Task task : this.tasks) {
			if (task.getDeadline().isBefore(deadline)) {
				dueTasks.add(task);
			}
		}
		return dueTasks;
	}

	/**
	 * starts the scheduler by monitoring tasks completion every second
	 */
	public void startMonitoringTasks() {

		if (monitoringActive == false) {
			SchedulerThread thread = new SchedulerThread();
			thread.start();
			monitoringActive = true;
		} else {
			throw new RuntimeException("Scheduler is already active");
		}

	}

	/**
	 * stops the scheduler by stop monitoring tasks completion
	 */
	public void stopMonitoringTasks() {
		monitoringActive = false;
	}

	/**
	 * go through all tasks and display alert on all tasks that passed deadline.
	 */
	public void checkDeadlines() {
		LocalDateTime now = LocalDateTime.now();
		for (Task task : tasks) {
			if (task.getDeadline().isBefore(now) && !task.isAlertPopped()) {
				System.out.println("!!! DEADLINE ALERT: " + task);
				task.setAlertPopped(true);
			}
		}
	}

	private class SchedulerThread extends Thread {
		@Override
		public void run() {
			System.out.println("start monitoring task deadlines");
			while (monitoringActive) {
				checkDeadlines();
				try {
					Thread.sleep(checkRateMilis);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("stoped monitoring task deadlines");
		}
	}

}

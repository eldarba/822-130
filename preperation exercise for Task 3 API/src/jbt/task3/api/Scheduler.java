package jbt.task3.api;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Scheduler {

	private Set<Task> tasks = new TreeSet<Task>();
	private boolean monitoringActive;
	private long checkRateMilis = 1000;

	public synchronized void addTask(Task task) throws Exception {
		boolean added = tasks.add(task);
		if (!added) {
			throw new Exception("addTask faild for task: " + task);
		}
	}

	public synchronized void removeTask(int taskId) throws Exception {

		Task taskToRemove = new Task(taskId, null, null);

		boolean isRemoved = tasks.remove(taskToRemove);

		if (!isRemoved) {
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

		for (Task task : tasks) {
			if (task.getId() == taskId) {
				return task;
			}
		}
		return null;

	}

	public Set<Task> getAllTasks() {
		return tasks;
	}

	/**
	 * this method returns the tasks that should be completed up to the specified
	 * date
	 */
	public List<Task> getAllTasksDueUntil(LocalDateTime deadline) {
		List<Task> dueTasks = new ArrayList<Task>();
		for (Task task : this.tasks) {
			if (task.getDeadline().isBefore(deadline)) {
				dueTasks.add(task);
			}
		}
		return dueTasks;
	}

	public List<Task> getAllTasksDueUntilAndNotDone(LocalDateTime deadline) {
		List<Task> dueTasks = new ArrayList<Task>();
		for (Task task : this.tasks) {
			if (task.getDeadline().isBefore(deadline) && !task.isDone()) {
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
	public synchronized void checkDeadlines() {
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

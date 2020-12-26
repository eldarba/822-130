package jbt.task3.api;

import java.time.LocalDateTime;

public class Task implements Comparable<Task> {

	private int id;
	private String description;
	private boolean done;
	private LocalDateTime deadline;
	private boolean alertPopped;

	public Task(int id, String description, LocalDateTime deadline) {
		super();
		this.id = id;
		this.description = description;
		this.deadline = deadline;
	}

	/**
	 * perform a set of actions and set the done status to true;
	 */
	public void doTask() {
		System.out.println("performing task id " + id + ": " + description);
		done = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public LocalDateTime getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDateTime deadline) {
		this.deadline = deadline;
	}

	public boolean isAlertPopped() {
		return alertPopped;
	}

	public void setAlertPopped(boolean alertPopped) {
		this.alertPopped = alertPopped;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", description=" + description + ", done=" + done + ", deadline=" + deadline
				+ ", alertPopped=" + alertPopped + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Task)) {
			return false;
		}
		Task other = (Task) obj;
		if (id != other.id) {
			return false;
		}
		return true;
	}

	@Override
	public int compareTo(Task other) {
		if (this.id == other.id) {
			return 0;
		}
		return this.deadline.compareTo(other.deadline);
	}

}

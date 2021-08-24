package duke.util;

import duke.task.Task;
import duke.exceptions.DukeIndexException;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private List<Task> list;

    public TaskList() {
        this.list = new ArrayList<>();
    }

    /**
     * Constructor method of TaskList.
     *
     * @param tasks List of tasks.
     */
    public TaskList(List<Task> tasks) {
        this.list = tasks;
    }

    public List<Task> getTasks() {
        return list;
    }

    /**
     * Adds a task to list.
     *
     * @param task Task to be added.
     */
    public void addTask(Task task) {
        System.out.println("Got it. I've added this task:");
        System.out.println(task);
        list.add(task);
        if (list.size() == 1) {
            System.out.println("Now you have 1 task in the list.");
        } else {
            System.out.println(String.format("Now you have %d tasks in the list.", 
                    list.size()));
        }
    }

    /**
     * Lists the tasks in the list of tasks.
     */
    public void list() {
        if (list.isEmpty()) {
            System.out.println("You have no task for now. Want to add a new task?");
            return;
        }

        System.out.println("Here are the tasks in your list:");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(String.format("%d. %s",
                    i + 1, list.get(i)));
        }
    }

    /**
     * Sets a task as done.
     *
     * @param index Index of the task to be set as done.
     * @throws DukeIndexException If index given by user is greater than size of list or non-positive.             
     */
    public void setAsDone(int index) {
        try {
            if (index > list.size()) {
                throw new DukeIndexException("The input task number is too big.");
            }
            if (index < 1) {
                throw new DukeIndexException("The input task number is non-positive.");
            }
            list.get(index - 1).maskAsDone();

            System.out.println("Nice! I've marked this task as done:");
            System.out.println(list.get(index - 1));
        } catch (DukeIndexException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Deletes a task from list of tasks.
     *
     * @param index Index of the task to be deleted.
     * @throws DukeIndexException If index given by user is greater than size of list.
     */
    public void deleteTask(int index) throws DukeIndexException {
        try {
            if (index > list.size()) {
                throw new DukeIndexException("The input task number is too big.");
            }
            Task removedTask = list.remove(index - 1);

            System.out.println("Noted. I've removed this task:");
            System.out.println("  " + removedTask);
            System.out.println(String.format("Now you have %d tasks in the list.", list.size()));
        } catch (DukeIndexException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Finds a task matching the given keyword.
     *
     * @param keyword Keyword given.
     */
    public void showFind(String keyword) {
        System.out.println("Here are the matching tasks in your list:");
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getDescription().contains(keyword)) {
                System.out.println(list.get(i));
            }
        }
    }

}


}

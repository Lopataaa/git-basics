import java.util.HashMap;

public class TaskManager {
    private final HashMap<Integer, Task> tasks = new HashMap<>();
    private final HashMap<Integer, SubTask> subTasks = new HashMap<>();
    private final HashMap<Integer, Epic> epics = new HashMap<>();
    private int newId = 1;

    public HashMap<Integer, Task> getTasks() { //исправила геттер для tasks в соответствии с типом коллекции выше и далее в остальных геттеров и сеттеров
        return tasks;
    }
    public HashMap<Integer, SubTask> getSubTasks() {
        return subTasks;
    }
    public HashMap<Integer, Epic> getEpics() {
        return epics;
    }

    public Task addTask(String name, String description) {
        Task task = new Task(newId++, description, name);
        tasks.put(task.getId(), task);
        return task;
    }

    public void deleteAllTasks() {
        tasks.clear();
    }

    public SubTask addSubTask(String name, String description, int epicId) {
        SubTask subTask = new SubTask(newId++, name, description, epicId);
        subTasks.put(subTask.getId(), subTask);

        Epic epic = epics.get(epicId);
            if (epic != null) {
                epic.addSubTaskId(subTask.getId());
        }
        return subTask;
    }

    public Epic addEpic(String name, String description) {
        Epic epic = new Epic(newId++, name, description);
        epics.put(epic.getId(), epic); // исправила
        return epic;
    }

    public void deleteEpic() {
        epics.clear();
    }
}

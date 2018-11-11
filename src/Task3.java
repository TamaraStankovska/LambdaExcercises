import static domain.Task.getTasks;
import static java.lang.System.*;

import domain.Task;
import domain.TaskType;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Task3 {

    public static void main(String[] args) {
        List<Task> tasks = getTasks();


        System.out.println("----Task with longest title----");
        System.out.println(
                tasks.stream()
                        .map(Task::getTitle)
                        // .mapToInt(String::length)
                        .max(Comparator.comparing(String::length))
        );


        System.out.println("\n");
        System.out.println("----Total number of tags----");
        System.out.println(
                tasks.stream()
                        .flatMap(task -> task.getTags().stream())
                        .count());



        System.out.println("\n");
        System.out.println("---Summary of Task titles---");
        tasks.stream()
                .map(Task::getTitle)
                .forEach(System.out::println);


        System.out.println("\n");
        System.out.println("---Grouping Tasks by Type---");
        System.out.println(
                tasks.stream()
                        .collect(Collectors.groupingBy(Task::getType)));


        System.out.println("\n");
        System.out.println("---Grouping Tasks by Type and Date Created On---");

        Map<TaskType, Map<LocalDate, List<Task>>> groupedTasksbyTypeAndDate = tasks.stream()
                .collect(Collectors.groupingBy(Task::getType, Collectors.groupingBy(Task::getCreatedOn)));

        groupedTasksbyTypeAndDate.entrySet()
                .forEach(System.out::println);




       /* Map<TaskType, List<Task>> allTasksByType = new HashMap<>();
        for (Task task : tasks) {
            List<Task> existingTasksByType = allTasksByType.get(task.getType());
            if (existingTasksByType == null) {
                List<Task> tasksByType = new ArrayList<>();
                tasksByType.add(task);
                allTasksByType.put(task.getType(), tasksByType);
            } else {
                existingTasksByType.add(task);
            }
        }
        for (Map.Entry<TaskType, List<Task>> entry : allTasksByType.entrySet()) {
            out.println(String.format("%s =>> %s", entry.getKey(), entry.getValue()));
        }
    }*/
    }
}


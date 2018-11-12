import static java.lang.System.out;

import domain.Task;
import domain.TaskType;

import java.security.cert.CollectionCertStoreParameters;
import java.util.*;
import java.util.stream.Collectors;

public class Task2 {

    public static void main(String[] args) {
        List<Task> tasks = Task.getTasks();


        // Find all reading task titles sorted by their creation date

        System.out.println("----Reading Task Titles sorted by Creation Date----");
        List<Task> sortedTitles=tasks.stream()
                .filter(task -> task.getType()==TaskType.READING)
                .sorted(Comparator.comparing(Task::getCreatedOn))
                .collect(Collectors.toList());

        sortedTitles.stream()
                .forEach(title -> System.out.println(title.getTitle()));


        System.out.println("\n");
        System.out.println("----Reading Task Titles sorted by Creation Date in Reverse----");
        List<Task> reversedTitles=tasks.stream()
                .filter(task -> task.getType()==TaskType.READING)
                .sorted(Comparator.comparing(Task::getCreatedOn).reversed())
                .collect(Collectors.toList());

        reversedTitles.stream()
                .forEach(title -> System.out.println(title.getTitle()));


        System.out.println("\n");
        System.out.println("----Distinct tasks----");
        List<Task> distinct=tasks.stream()
                .distinct()
                .collect(Collectors.toList());
        distinct.stream()
                .forEach(System.out::println);



        System.out.println("\n");
        System.out.println("----Top 2 Reading Tasks Sorted by Creation Date----");
        List<Task> topTasks=tasks.stream()
                .filter(task -> task.getType()==TaskType.READING)
                .sorted(Comparator.comparing(Task::getCreatedOn))
                .limit(2)
                .collect(Collectors.toList());
        topTasks.stream()
                .forEach(task -> System.out.println(task.getTitle()));


        System.out.println("\n");
        System.out.println("----Unique Tags for All Tasks----");
        List<String> uniqueTags = tasks.stream().flatMap(t -> t.getTags().stream()).collect(Collectors.toList());
        uniqueTags.stream()
                .distinct()
                .forEach(System.out::println);


        System.out.println("\n");
        System.out.println("----Check for a Tag BOOK----");
        List<Task> filterReadingTasks=tasks.stream()
                .filter(task -> task.getType()==TaskType.READING)
                .collect(Collectors.toList());

        Boolean hasTagBooks=filterReadingTasks.stream()
                .allMatch(task -> task.getTags().contains("books"));

        System.out.println(hasTagBooks);

        System.out.println("\n");
        System.out.println("----Summary of all Titles----");
        List<String> summary=tasks.stream()
                .map(Task::getTitle)
                .collect(Collectors.toList());
        summary.stream().forEach(System.out::println);
     /*   List<Task> readingTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getType() == TaskType.READING) {
                readingTasks.add(task);
            }
        }
        Collections.sort(readingTasks, new Comparator<Task>() {
            @Override
            public int compare(Task t1, Task t2) {
                return t1.getTitle().length() - t2.getTitle().length();
            }
        });
        for (Task readingTask : readingTasks) {
            out.println(readingTask.getTitle());
        }*/
    }

}
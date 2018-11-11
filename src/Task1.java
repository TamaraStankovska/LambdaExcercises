import static java.lang.System.*;

import domain.Task;
import domain.TaskType;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Task1 {

    public static void main(String[] args) {
        List<Task> tasks = Task.getTasks();
       Predicate<Task> taskPredicate=task -> task.getType()==TaskType.READING;
      Function<Task,String> extractTitles=Task::getTitle;
      getTitles(tasks,taskPredicate)
              .forEach(System.out::println);

    }




    private static List<String> taskTitles(List<Task> tasks) {
        List<String> readingTitles = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getType() == TaskType.READING) {
                readingTitles.add(task.getTitle());
            }
        }
        return readingTitles;
    }


    private static List<String> getTitles(List<Task> tasks, Predicate<Task> predicate){
        List<String> titles=new ArrayList<>();
        for(Task task: tasks)
        {
            if(predicate.test(task)) {
                titles.add(task.getTitle()); }
        }
        return titles;
    }

}

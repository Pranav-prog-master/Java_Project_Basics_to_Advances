import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Progress_bar {

    private static final int BAR_LENGTH = 20;
    private static final int MAX_TASKS = 10;

    static class Task {
        int id;
        int progress;
        int step;

        public Task(int id) {
            this.id = id;
            this.progress = 0;
            this.step = new Random().nextInt(5) + 1;
        }

        public void update() {
            if (this.progress < 100) {
                this.progress += this.step;
                if (this.progress > 100) {
                    this.progress = 100;
                }
            }
        }

        public boolean isComplete() {
            return this.progress >= 100;
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = new ArrayList<>();
        for (int i = 0; i < MAX_TASKS; i++) {
            tasks.add(new Task(i + 1));
        }

        boolean allTasksComplete = false;
        while (!allTasksComplete) {
            allTasksComplete = true;
            clearScreen();

            for (Task task : tasks) {
                task.update();
                printBar(task);
                if (!task.isComplete()) {
                    allTasksComplete = false;
                }
            }

            try {
                // Pause for 1 second (1000 milliseconds)
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Thread was interrupted, exiting.");
                break;
            }
        }
        System.out.println("\nAll tasks completed!");
    }

    private static void printBar(Task task) {
        int barsToShow = (task.progress * BAR_LENGTH) / 100;
        StringBuilder bar = new StringBuilder("Task " + task.id + ": [");
        for (int i = 0; i < BAR_LENGTH; i++) {
            bar.append(i < barsToShow ? "=" : " ");
        }
        bar.append("] ").append(task.progress).append("%");
        System.out.println(bar.toString());
    }

    private static void clearScreen() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            System.out.println("Failed to clear screen: " + e.getMessage());
        }
    }
}

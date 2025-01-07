import java.time.LocalDateTime;
   import java.time.format.DateTimeFormatter;
   import java.util.List;
   import java.util.Scanner;

   public class ConsoleNotebookView implements NotebookView {
       private Scanner scanner = new Scanner(System.in);

       @Override
       public void displayNotes(List<Note> notes) {
           for (Note note : notes) {
               System.out.println(note.getDateTime() + ": " + note.getContent());
           }
       }

       @Override
       public void showMessage(String message) {
           System.out.println(message);
       }

       @Override
       public Note getNoteInput() {
           System.out.print("Enter date and time (yyyy-MM-dd HH:mm): ");
           String dateTimeInput = scanner.nextLine();
           System.out.print("Enter content: ");
           String content = scanner.nextLine();
           LocalDateTime dateTime = LocalDateTime.parse(dateTimeInput, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
           return new Note(dateTime, content);
       }
   }
import java.util.List;

   public interface NotebookView {
       void displayNotes(List<Note> notes);
       void showMessage(String message);
       Note getNoteInput();
   }

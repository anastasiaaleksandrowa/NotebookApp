import java.time.LocalDate;
   import java.util.List;

   public class NotebookPresenter {
       private Notebook notebook;
       private NotebookView view;

       public NotebookPresenter(Notebook notebook, NotebookView view) {
           this.notebook = notebook;
           this.view = view;
       }

       public void addNote() {
           Note note = view.getNoteInput();
           notebook.add(note);
           view.showMessage("Note added successfully!");
       }

       public void displayNotes() {
           List<Note> notes = notebook.getNotesForDay(LocalDate.now());
           view.displayNotes(notes);
       }
   }
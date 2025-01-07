import java.time.LocalDateTime;

   public class Note {
       private LocalDateTime dateTime;
       private String content;

       public Note(LocalDateTime dateTime, String content) {
           this.dateTime = dateTime;
           this.content = content;
       }

       public LocalDateTime getDateTime() {
           return dateTime;
       }

       public String getContent() {
           return content;
       }
   }
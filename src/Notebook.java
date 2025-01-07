import java.io.*;
   import java.time.LocalDate;
   import java.time.LocalDateTime;
   import java.time.format.DateTimeFormatter;
   import java.util.ArrayList;
   import java.util.Comparator;
   import java.util.List;
   import java.util.stream.Collectors;

   public class Notebook {
       private List<Note> notes = new ArrayList<>();

       public void add(Note note) {
           notes.add(note);
       }

       public List<Note> getNotesForDay(LocalDate date) {
           return notes.stream()
               .filter(note -> note.getDateTime().toLocalDate().equals(date))
               .sorted(Comparator.comparing(Note::getDateTime))
               .collect(Collectors.toList());
       }

       public List<Note> getNotesForWeek(LocalDate startDate) {
           LocalDate endDate = startDate.plusDays(6);
           return notes.stream()
               .filter(note -> {
                   LocalDate noteDate = note.getDateTime().toLocalDate();
                   return !noteDate.isBefore(startDate) && !noteDate.isAfter(endDate);
               })
               .sorted(Comparator.comparing(Note::getDateTime))
               .collect(Collectors.toList());
       }

       public void saveToFile(String filename) {
           try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
               for (Note note : notes) {
                   writer.write(note.getDateTime() + "," + note.getContent());
                   writer.newLine();
               }
           } catch (IOException e) {
               e.printStackTrace();
           }
       }

       public void loadFromFile(String filename) {
           try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
               String line;
               while ((line = reader.readLine()) != null) {
                   String[] parts = line.split(",");
                   LocalDateTime dateTime = LocalDateTime.parse(parts[0], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                   String content = parts[1];
                   notes.add(new Note(dateTime, content));
               }
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
   }
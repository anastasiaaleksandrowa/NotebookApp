public class Main {
    public static void main(String[] args) {
        Notebook notebook = new Notebook();
        NotebookView view = new ConsoleNotebookView();
        NotebookPresenter presenter = new NotebookPresenter(notebook, view);

        // Пример добавления записи
        presenter.addNote();
        presenter.displayNotes();
        notebook.saveToFile("notes.txt"); // Сохранение в файл
        notebook.loadFromFile("notes.txt"); // Загрузка из файла
    }
}
public class User {
    private String username;
    private Library myLibrary;

    public User(String username) {
        this.username = username;
        this.myLibrary = new Library();
    }

    public String getUsername() {
        return username;
    }

    public Library getLibrary() {
        return myLibrary;
    }

    public void setUsername(String name) {
        username = name;
    }

}
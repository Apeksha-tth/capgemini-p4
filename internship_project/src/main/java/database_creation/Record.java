package database_creation;

public class Record {
    private int id;
    private String name;
    private String role;
    private String project;
    private String email;

    // Getters and setters for each property

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "Record [id=" + id + ", name=" + name + ", role=" + role + ", project=" + project + ", email=" + email + "]";
    }

}

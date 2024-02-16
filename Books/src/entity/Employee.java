package entity;

public class Employee {
    private int id;
    private String name;
    private String position;
    private String department;

    // Constructor
    public Employee(int id, String name, String position, String department) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.department = department;
    }

    // Getters and setters
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
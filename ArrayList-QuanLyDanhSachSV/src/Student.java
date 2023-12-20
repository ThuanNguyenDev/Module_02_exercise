public class Student {
    private String idStudent;
    private String name;
    private float gpa;
    private int dateOfBirth;

    public Student() {
    }

    public Student(String idStudent, String name, float gpa, int dateOfBirth) {
        this.idStudent = idStudent;
        this.name = name;
        this.gpa = gpa;
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "idStudent='" + idStudent + '\'' +
                ", name='" + name + '\'' +
                ", gpa=" + gpa +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}

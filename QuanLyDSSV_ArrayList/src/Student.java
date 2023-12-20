import java.util.Objects;
public class Student implements Comparable<Student> {
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


    @Override
    public int hashCode() {
        return Objects.hash(getIdStudent(), getName(), getGpa(), getDateOfBirth());
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Student student) {
            return Float.compare(student.getGpa(), getGpa()) == 0 && getDateOfBirth() == student.getDateOfBirth() && Objects.equals(getIdStudent(), student.getIdStudent()) && Objects.equals(getName(), student.getName());
        }
        return false;
    }

    @Override
    public int compareTo(Student student) {
        return this.idStudent.compareTo(student.idStudent);
    }
}

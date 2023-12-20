import java.util.ArrayList;
import java.util.Comparator;
public class StudentList {
    static ArrayList<Student> list;
    public StudentList() {
        this.list = new ArrayList<Student>();
    }
    public StudentList(ArrayList<Student> list) {
        this.list = list;
    }

    public void addStudent(Student student) {
        list.add(student);
    }

    public boolean printStudentList() {
        for ( Student student: list) {
            System.out.println(student);
        }
        return false;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getStudentNumber() {
        return list.size();
    }

    public boolean makeEmpty(){
        list.clear();
        return list.isEmpty();
    }
    public boolean checkExistStudent(Student student){
        return list.contains(student);
    }

    public boolean deleteStudent(Student student){
        return list.remove(student);
    }

    public boolean checkStudent(String name) {
        for(Student student : list){
            if(student.getName().contains(name)){
                System.out.println(student);
            }
        }
        return false;
    }

    public void sortStudentsByScore() {
        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                if (student1.getGpa() > student2.getGpa()) {
                    return 1;
                } else if (student1.getGpa() < student2.getGpa()) {
                    return -1;
                } else {
                    return 0;
                }
            }

        });
    }
}

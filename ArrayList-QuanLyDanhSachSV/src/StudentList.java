import java.util.ArrayList;
import java.util.Comparator;
public class StudentList {
private  ArrayList<Student> list;
public StudentList() {
    this.list = new ArrayList<Student>();
}
public StudentList(ArrayList<Student> list) {
    this.list = list;
}

public void addStudent(Student student) {
    this.list.add(student);
}

public boolean printStudentList() {
    for ( Student student: list) {
        System.out.println(student);
    }
    return false;
}

public boolean isEmpty() {
    return this.list.isEmpty();
}

public int getStudentNumber() {
    return this.list.size();
}

public boolean makeEmpty(){
    this.list.removeAll(list);
    return false;
}
public boolean checkExistStudent(Student student){
    return this.list.contains(student);
}

public boolean deleteStudent(Student student){
    return this.list.remove(student);
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
        this.list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                if (student1.getGpa() < student2.getGpa()) {
                    return -1;
                } else if (student1.getGpa() > student2.getGpa()) {
                    return 1;
                } else {
                    return 0;
                }
            }

        });
    }
}




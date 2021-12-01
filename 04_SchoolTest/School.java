import java.util.Arrays;
import java.util.Objects;

public class School {
    private String name;
    private int limit;

    private Student[] students;
    private int studentCount;

    public String toString(){
        String msg = "School Name: " + name + " Student Count: " + studentCount + "\n";
        for ( int i = 0; i < studentCount; i++){
            msg += "\t" + students[i] + "\n";
        }
        return msg;
    }

    public School(String name, int limit){
        this.name = name; this.limit = limit;
        students = new Student[limit]; studentCount = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return limit == school.limit && studentCount == school.studentCount && name.equals(school.name) && Arrays.equals(students, school.students);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, limit, studentCount);
        result = 31 * result + Arrays.hashCode(students);
        return result;
    }

    public Student findStudent(String name, int year){
        for(int i = 0; i < studentCount; i++){
            if(students[i].getName().equals(name) && students[i].getYear() == year)
                return new Student(name, year);
        }
        return null;
    }
    public void addStudent(Student student){
        students[studentCount] = new Student(student.getName(), student.getYear());
        studentCount++;
    }
    public void removeAllStudent(){
        students = new Student[limit]; studentCount = 0;
    }
}

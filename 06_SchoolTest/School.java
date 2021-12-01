package edu.pnu.admin;

import edu.pnu.collection.GenericList;

public class School {
    private final String name;
    private GenericList<Student> students = new GenericList<Student>();

    public School(final String name){ this.name = name; }
    public School(final String name, int size){
        this.name = name;
        students = new GenericList<Student>(size);
    }
    public void addStudent(Student student){
        students.addData(student);
    }
    public void removeAllStudent(){
        int size = students.dataSize();
        students = new GenericList<Student>(size);
    }
    public Student findStudent(String name, int schoolYear){
        Student target = new Student(name, schoolYear);
        for (int i = 0; i < students.countData(); i++){
            Student student = students.getData(i);
            if(student.equals(target))
                return student;
        }
        return null;
    }

    @Override
    public String toString() {
        String toStr = String.format("School Name: %s Student Count: %d%n",name,students.countData());
        for (int i = 0; i < students.countData(); i++){
            toStr += students.getData(i) + "\n";
        }
        return toStr;
    }
}

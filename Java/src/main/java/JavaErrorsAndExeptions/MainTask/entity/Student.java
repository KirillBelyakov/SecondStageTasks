package JavaErrorsAndExeptions.MainTask.entity;

import JavaErrorsAndExeptions.MainTask.exceptions.NoLessonsException;

import java.util.List;

public class Student {
    private String surname;
    private String name;
    private List<Lesson> lessons;

    public Student(String surname, String name, List<Lesson> lessons) {
        this.lessons = lessons;
        this.surname = surname;
        this.name = name;
        if (lessons.size() == 0) {
            throw new NoLessonsException("Student " + surname + " has no lessons!");
        }
    }

    public String getSurname() {
        return surname;
    }

     public double getStudentAverageMark(){
         double sum=0;
         for(Lesson lesson: lessons ){
             sum+=lesson.getMark();
         }
         return sum/lessons.size();
     }

     public Lesson getLesson(String name){
         Lesson foundedLesson=null;
         for(Lesson lesson:lessons){
             if(lesson.getName().equals(name)){
                 foundedLesson=lesson;
                 break;
             }
         }
         return foundedLesson;
     }

    @Override
    public String toString() {
        return "Student{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", lessons=" + lessons.toString() +
                '}';
    }
}
package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {

    private HashMap<String, Student> studentMap;
    private HashMap<String, Teacher> teacherMap;
    private HashMap<String, List<String>> teacherStudentMapping;

    public StudentRepository(){
        this.studentMap = new HashMap<String, Student>();
        this.teacherMap = new HashMap<String, Teacher>();
        this.teacherStudentMapping = new HashMap<String, List<String>>();
    }

    public void saveStudent(Student student){
        // your code goes here
        if(!studentMap.containsKey(student.getName())){
            studentMap.put(student.getName(),student);
        }
    }

    public void saveTeacher(Teacher teacher){
        // your code goes here
        if(!teacherMap.containsKey(teacher.getName())){
            teacherMap.put(teacher.getName(),teacher);
        }
    }

    public void saveStudentTeacherPair(String student, String teacher){
        if(studentMap.containsKey(student) && teacherMap.containsKey(teacher)){
            // your code goes here
            if(!teacherStudentMapping.containsKey(teacher)){
                teacherStudentMapping.put(teacher,new ArrayList<>());
            }
            teacherStudentMapping.get(teacher).add(student);
        }
    }

    public Student findStudent(String student){
        // your code goes here
        if(studentMap.containsKey(student)){
            return studentMap.get(student);
        }
        return null;
    }

    public Teacher findTeacher(String teacher){
        // your code goes here
        if(teacherMap.containsKey(teacher)){
            return teacherMap.get(teacher);
        }
        return null;
    }

    public List<String> findStudentsFromTeacher(String teacher){
        // your code goes here
        // find student list corresponding to a teacher
        if(teacherStudentMapping.containsKey(teacher)){
            return teacherStudentMapping.get(teacher);
        }
        return null;
    }

    public List<String> findAllStudents(){
        // your code goes here
        List<String> allStudentList = new ArrayList<>();
        for(String studentName : studentMap.keySet()){
            allStudentList.add(studentName);
        }
        return allStudentList;
    }

    public void deleteTeacher(String teacher){
        // your code goes here
        if(teacherMap.containsKey(teacher)){
            teacherMap.remove(teacher);
            if(teacherStudentMapping.containsKey(teacher)){
                teacherStudentMapping.remove(teacher);
            }
        }
    }

    public void deleteAllTeachers(){
        // your code goes here
        teacherMap = new HashMap<>();
        teacherStudentMapping = new HashMap<>();
    }
}
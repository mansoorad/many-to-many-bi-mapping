package com.ty.manytomanybi1.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.manytomanybi1.dto.Student;
import com.ty.manytomanybi1.dto.Teacher;

public class StudentMain {
	public static void main(String[] args) {

		Student student1 = new Student();
		student1.setName("Raju M");
		student1.setStandard("9th");

		Student student2 = new Student();
		student2.setName("jak");
		student2.setStandard("10th");

		Student student3 = new Student();
		student3.setName("man");
		student3.setStandard("8th");

		Teacher teacher1 = new Teacher();
		teacher1.setName("Rav");
		teacher1.setSubject("maths");

		Teacher teacher2 = new Teacher();
		teacher2.setName("nayak");
		teacher2.setSubject("english");

		Teacher teacher3 = new Teacher();
		teacher3.setName("sty");
		teacher3.setSubject("pt");

		List<Teacher> teachersList1 = new ArrayList();
		teachersList1.add(teacher1);
		teachersList1.add(teacher3);
		student1.setTeachers(teachersList1);

		List<Teacher> teachersList2 = new ArrayList();
		teachersList2.add(teacher2);
		teachersList2.add(teacher3);
		student2.setTeachers(teachersList2);

		List<Teacher> teachersList3 = new ArrayList();
		teachersList3.add(teacher1);
		teachersList3.add(teacher2);
		student3.setTeachers(teachersList3);

		List<Student> studentList1 = new ArrayList();
		studentList1.add(student1);
		studentList1.add(student3);
		teacher1.setStudents(studentList1);

		List<Student> studentList2 = new ArrayList();
		studentList2.add(student2);
		studentList2.add(student3);
		teacher2.setStudents(studentList2);

		List<Student> studentList3 = new ArrayList();
		studentList3.add(student1);
		studentList3.add(student2);
		teacher3.setStudents(studentList3);

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("map");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(student1);
		entityManager.persist(student2);
		entityManager.persist(student3);
		entityManager.persist(teacher1);
		entityManager.persist(teacher2);
		entityManager.persist(teacher3);
		entityTransaction.commit();

	}
}

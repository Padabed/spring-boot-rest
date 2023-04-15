package com.nicotine.addiction.example;

import com.nicotine.addiction.example.dao.StudentDAO;
import com.nicotine.addiction.example.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//removeAllStudents(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		Student student = new Student("nikita", "padabed", "s22284");
		studentDAO.save(student);
		System.out.println(student.getId());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		Student student = new Student("gloria", "padabed", "s22284");
		studentDAO.save(student);
		System.out.println(student.getId());

		Student student1 = new Student("sergey", "Kloria", "s22282");
		studentDAO.save(student1);
		System.out.println(student1.getId());

		Student student2 = new Student("maxim", "Adams", "s22283");
		studentDAO.save(student2);
		System.out.println(student2.getId());
	}

	private void readStudent(StudentDAO studentDAO) {
		Student student = new Student("sergey", "padabed", "s22284");
		studentDAO.save(student);

		int _id = student.getId();
		System.out.println(_id);

		Student receivedStudent = studentDAO.findById(_id);
		System.out.println(receivedStudent);
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findAll();
		students.forEach(s -> System.out.println(s));
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("padabed");
		students.forEach(s -> System.out.println(s));
	}

	private void updateStudent(StudentDAO studentDAO) {
		int _id = 1;
		Student student = studentDAO.findById(_id);
		student.setLastName("Kornel");
		studentDAO.update(student);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int _id = 3;
		studentDAO.delete(_id);
	}

	private void removeAllStudents(StudentDAO studentDAO) {
		studentDAO.removeAll();
	}

}

package com.kumsal.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kumsal.demo.entity.Course;
import com.kumsal.demo.entity.Instructor;
import com.kumsal.demo.entity.InstructorDetail;
import com.kumsal.demo.entity.Review;
import com.kumsal.demo.entity.Student;

public class CreateCoursesandReviewDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory=new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		Session session=sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		try {
			Course tempCourse=new Course("Pacman-");
			tempCourse.addReview(new Review("Great course....love it"));
			tempCourse.addReview(new Review("love this is many"));
			tempCourse.addReview(new Review("Nothing"));
			
			System.out.println("tempCourse :"+tempCourse);
			System.out.println("review :"+tempCourse.getReviw());
			
			session.save(tempCourse);
			
			session.getTransaction().commit();
			session.close();
			System.out.println("Saved succesfuly");
		} finally {
			// TODO: handle finally clause
		}

	}

}

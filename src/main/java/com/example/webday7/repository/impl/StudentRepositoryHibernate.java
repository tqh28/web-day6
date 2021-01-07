package com.example.webday7.repository.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.webday7.entity.Student;
import com.example.webday7.repository.StudentRepository;

@Repository
public class StudentRepositoryHibernate implements StudentRepository {

	private SessionFactory sessionFactory;

	@Autowired
	public StudentRepositoryHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Student> findAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
		Root<Student> root = criteriaQuery.from(Student.class);
		criteriaQuery.select(root);
		Query<Student> query = session.createQuery(criteriaQuery);
		List<Student> list = query.getResultList();
		return list;
	}

	@Override
	public Student findById(long id) {
		Session session = sessionFactory.getCurrentSession();
		return session.find(Student.class, id);
	}

	@Override
	public void insert(Student s) {
		Session session = sessionFactory.getCurrentSession();
		session.save(s);
	}

	@Override
	public void update(Student s) {
		Session session = sessionFactory.getCurrentSession();
		session.update(s);
	}

	@Override
	public void delete(Student s) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(s);
	}

}

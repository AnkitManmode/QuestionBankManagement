package com.jbk.QuestionBank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.QuestionBank.entity.Question;

@Repository
public class QuestionDaoImpl implements QuestionDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveQuestion(Question question) {
		Session session = null;
		Transaction transaction = null;
		boolean isAdded = false;

		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Question que = session.get(Question.class, question.getQuestionName());
			if (que == null) {
				session.save(question);
				transaction.commit();
				isAdded = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isAdded;
	}

	@Override
	public List<Question> getQuestion() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Question.class);
		List<Question> list = null;
		try {
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return list;

	}

	@Override
	public boolean deleteQuestion(String questionNo) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isDeleted = false;

		try {
			Question question = session.get(Question.class, questionNo);

			if (question != null) {
				session.delete(question);
				transaction.commit();
				isDeleted = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		System.out.println("Question deleted");
		return false;
	}
}

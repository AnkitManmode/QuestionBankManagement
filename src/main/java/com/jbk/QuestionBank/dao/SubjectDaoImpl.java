package com.jbk.QuestionBank.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.QuestionBank.entity.Subject;


@Repository
public class SubjectDaoImpl implements SubjectDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean saveSubject(Subject subject) {
		Session session = null;
		Transaction transaction = null;
		boolean isAdded = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Subject sub = session.get(Subject.class, subject.getSubjectNo());
			if(sub==null) {
				session.save(subject);
				transaction.commit();
				isAdded = true ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return isAdded;
	}


	@Override
	public List<Subject> getSubject() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Subject.class);
		List<Subject>list=null;
		try {
			list =criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session !=null)
				session.close();
		}

		return list;

	}


	@Override
	public boolean deleteSubject(String subjectNo) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		boolean isDeleted = false ;
		try {
			Subject subject = session.get(Subject.class, subjectNo);
			if(subject !=null) {
				session.delete(subject);
				transaction.commit();
				isDeleted = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null);
			session.close();
		}
		return isDeleted;
	}


	@Override
	public boolean updateSubject(Subject subject) {
		Session session = null;
		Transaction transaction = null;
		boolean isUpdated = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Subject sub = session.get(Subject.class, subject.getSubjectNo());

			if(sub!=null) {
				session.evict(sub);
				session.update(subject);
				transaction.commit();
				isUpdated = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
			System.out.println("Product is uodated");
		}
		return isUpdated;
	}
}

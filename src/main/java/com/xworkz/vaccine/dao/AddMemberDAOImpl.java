package com.xworkz.vaccine.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.vaccine.entity.AddMemberEntity;
import com.xworkz.vaccine.exception.MemberEntityNotSavedException;

@Component
public class AddMemberDAOImpl implements AddMemberDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public AddMemberDAOImpl() {
		System.out.println(this.getClass().getSimpleName() + " Bean Created");
	}

	@Override
	public boolean saveMember(Object entity) {
		System.out.println("-----------------------------------------------------------");
		System.out.println("Invoked saveMember (message from AddMemeber DAO Impl)");
		Session session = null;
		Transaction transaction = null;
		boolean saveMember = false;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.persist(entity);
			transaction.commit();
			System.out.println(" Memeber is saved (message from AddMemeber DAO Impl) ");
			saveMember = true;
			return saveMember;
		} catch (MemberEntityNotSavedException exception) {
			System.out.println(" Memeber is not saved (message from AddMemeber DAO Impl) ");
			session.getTransaction().rollback();
			System.out.println(
					"Member Entity Not Saved Exception (message from AddMemeber DAO Impl)" + exception.getMessage());
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is  closed");
			} else {
				System.out.println("Session is not closed");
			}
		}
		return saveMember;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<AddMemberEntity> getAllMemberEntity() {
		System.out.println("-----------------------------------------------------------");
		System.out.println("Invoked get All Member Entity (message from AddMemeber DAO Impl)");
		Session session = null;
		List<AddMemberEntity> list = null;
		try {
			session = sessionFactory.openSession();

			Query query = session.getNamedQuery("getAllMemberEntity");
			list = query.list();
			return list;

			// for (AddMemberEntity entity : list) {
			// System.out.println(entity);
			// }
		} catch (Exception exception) {
			System.out.println("Could not get All Member Entity Exception (message from AddMemeber DAO Impl)"
					+ exception.getMessage());
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is  closed");
			} else {
				System.out.println("Session is not closed");
			}
		}
		return list;
	}

}

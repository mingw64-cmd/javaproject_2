package cqu.mvc.model;

import cqu.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 * 用户数据库访问对象
 */
public class UserDao {
	public static void addUser(String name, String pwd) {

		UserBean userEntity = new UserBean();
		userEntity.setName(name);
		userEntity.setPwd(pwd);
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(userEntity);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	public static UserBean getUserByName(String name) {
		Session session = HibernateUtil.getSession();
		try {
			return session.get(UserBean.class, name);
		} finally {
			session.close();
		}

		//测试
//		UserBean userEntity = new UserBean();
//		userEntity.setName("123");
//		userEntity.setPwd("123");
//		return userEntity;
	}

}

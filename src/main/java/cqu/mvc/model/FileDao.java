package cqu.mvc.model;


import cqu.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

/**
 * 文件数据库访问对象
 */
public class FileDao {
	public static void addFile(String id, String name, UserBean user) {
		FileEntity fileEntity = new FileEntity(id, name, user);
		Session session = HibernateUtil.getSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(fileEntity);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static FileEntity getFileById(String id) {
		Session session = HibernateUtil.getSession();
		try {
			return session.get(FileEntity.class, id);
		} finally {
			session.close();
		}

	}

	public static List<FileEntity> getFileByUser(String username) {

		Session session = HibernateUtil.getSession();
		try {
			Query<FileEntity> q=session.createQuery("from FileEntity where user_name='" + username + "'", FileEntity.class);
			return q.list();
		} finally {
			session.close();
		}

		//测试
//		List<FileEntity> list=new ArrayList<>();
//		return list;

	}

}

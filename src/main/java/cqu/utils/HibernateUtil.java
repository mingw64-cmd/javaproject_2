package cqu.utils;


import cqu.mvc.model.FileEntity;
import cqu.mvc.model.UserBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	 private static final SessionFactory sessionFactory;
	 static {
	 	//创建Configuration
		//配置文件为hibernate.properties
	 	Configuration configuration = new Configuration();
		System.out.println("configuration:"+configuration);

		configuration.addAnnotatedClass( FileEntity.class );
		configuration.addAnnotatedClass( UserBean.class );
		//获取sessionFactory
		sessionFactory = configuration.buildSessionFactory( new StandardServiceRegistryBuilder().build() );
	 }

	 public static Session getSession(){
	 	//获取session
	     return sessionFactory.openSession();
	 }

}

package util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

	private static String configfile = "/hibernate.cfg.xml";
	/* ThreadLocal ��һ�������߳�*/
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	private static Configuration config = new Configuration();
	private static org.hibernate.SessionFactory sessionFactory;
	/* ��ȡ�����ļ�������һ���Ự��������δ���Ϊ��̬�飬������Ѿ����С�*/
	static {
		try {
			config.configure(configfile);
			sessionFactory = config.buildSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* ͨ���Ự�����򿪻Ự���Ϳ��Է������ݿ��� */
	public static Session getSession() throws HibernateException {
		Session session = (Session) threadLocal.get();
		if (session == null || !session.isOpen()) {
			if (sessionFactory == null) {
				rebuildSessionFactory();
			}
			session = (sessionFactory != null) ? sessionFactory.openSession()
					: null;
			threadLocal.set(session);
		}
		return session;
	}

	/* ���´���һ���Ự����  */
	public static void rebuildSessionFactory() {
		try {
			config.configure(configfile);
			sessionFactory = config.buildSessionFactory();
		} catch (Exception e) {
		}
	}

	/* �ر������ݿ�ĻỰ*/
	public static void closeSession() throws HibernateException {
		Session session = (Session) threadLocal.get();
		threadLocal.set(null);
		if (session != null) {
			session.close();
		}
	}
}

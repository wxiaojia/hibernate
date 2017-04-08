package dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.Student;
import util.HibernateSessionFactory;

public class Stu_dao {
	//����
	public static void add(Student stu){
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		session.save(stu);
		tran.commit();
	}
	//��ѯ
	public static List find(int sno){
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Student s where s.sno=:sno");
		query.setParameter("sno", sno);
		List<Student> list = query.list();
		return list;
	}
	
	//ɾ��
	public static void dele(Student stu){
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		session.delete(stu);
		tran.commit();
	}
	
	//��
	public static void update(Student stu){
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		stu.setSname("��������");
		session.saveOrUpdate(stu);
		tran.commit();
	}
	//�鿴ȫ��
	public static void findAll(){
		Session session=HibernateSessionFactory.getSession();
		SQLQuery sqlQuery=session.createSQLQuery("select * from Student");
		List students=sqlQuery.list();
		Iterator iter=students.iterator();
		for(;iter.hasNext();){
			Object[] obj=(Object[])iter.next();
			System.out.println(obj[0]+","+obj[1]+","+obj[2]);			
		}
	}
	public static void main(String[] args) {
//		��
//		Student stu=new Student(1,"С��",3);
//		add(stu);
		
		//��
//		List<Student> list=find(1);
//		for(Student stu:list){
//			System.out.println(stu.getSno()+" "+stu.getSname());
//		}
		
		//ɾ
//		List<Student> list=find(1);
//		for(Student stu:list){
//			System.out.println(stu.getSno()+","+stu.getSname());	
//			dele(stu);
//		}
		
		//��
//		List<Student> list=find(1);
//		for(Student stu:list){
//			//System.out.println(dep.getDeptid()+" "+dep.getDeptname());	
//			update(stu);
//		}
		
		//��ʾȫ��
		findAll();
	}
}

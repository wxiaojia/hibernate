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
	//增加
	public static void add(Student stu){
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		session.save(stu);
		tran.commit();
	}
	//查询
	public static List find(int sno){
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Student s where s.sno=:sno");
		query.setParameter("sno", sno);
		List<Student> list = query.list();
		return list;
	}
	
	//删除
	public static void dele(Student stu){
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		session.delete(stu);
		tran.commit();
	}
	
	//改
	public static void update(Student stu){
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		stu.setSname("不告诉你");
		session.saveOrUpdate(stu);
		tran.commit();
	}
	//查看全部
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
//		增
//		Student stu=new Student(1,"小佳",3);
//		add(stu);
		
		//查
//		List<Student> list=find(1);
//		for(Student stu:list){
//			System.out.println(stu.getSno()+" "+stu.getSname());
//		}
		
		//删
//		List<Student> list=find(1);
//		for(Student stu:list){
//			System.out.println(stu.getSno()+","+stu.getSname());	
//			dele(stu);
//		}
		
		//改
//		List<Student> list=find(1);
//		for(Student stu:list){
//			//System.out.println(dep.getDeptid()+" "+dep.getDeptname());	
//			update(stu);
//		}
		
		//显示全部
		findAll();
	}
}

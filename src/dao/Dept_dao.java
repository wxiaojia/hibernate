package dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sun.xml.internal.ws.encoding.SwACodec;

import hibernate.Dept;

import util.HibernateSessionFactory;

public class Dept_dao {
	//����
	public static void add(Dept dept){
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		session.save(dept);
		tran.commit();
	}
	//��ѯ
	public static List find(int deptid){
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Dept d where d.deptid=:deptid");
		query.setParameter("deptid", deptid);
		List<Dept> list = query.list();
		return list;
	}
	
	//ɾ��
	public static void dele(Dept dept){
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		session.delete(dept);
		tran.commit();
	}
	
	//��
	public static void update(Dept dept,String str){
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		dept.setDeptname(str);
		session.saveOrUpdate(dept);
		tran.commit();
	}
	
	public static void main(String[] args) {
		//��
//		Dept dept=new Dept(1,"�������");
//		add(dept);
		
		//��
//		List<Dept> list=find(1);
//		for(Dept dep:list){
//			System.out.println(dep.getDeptid()+" "+dep.getDeptname());	
//		}
		
		//ɾ
//		List<Dept> list=find(1);
//		for(Dept dep:list){
//			System.out.println(dep.getDeptid()+" "+dep.getDeptname());	
//			dele(dep);
//		}
		
		//��
		List<Dept> list=find(1);
		for(Dept dep:list){
			String str="�������";
			//System.out.println(dep.getDeptid()+" "+dep.getDeptname());	
			update(dep,str);
		}
	}
}

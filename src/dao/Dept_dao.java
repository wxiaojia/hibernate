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
	//增加
	public static void add(Dept dept){
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		session.save(dept);
		tran.commit();
	}
	//查询
	public static List find(int deptid){
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("from Dept d where d.deptid=:deptid");
		query.setParameter("deptid", deptid);
		List<Dept> list = query.list();
		return list;
	}
	
	//删除
	public static void dele(Dept dept){
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		session.delete(dept);
		tran.commit();
	}
	
	//改
	public static void update(Dept dept,String str){
		Session session=HibernateSessionFactory.getSession();
		Transaction tran=session.beginTransaction();
		dept.setDeptname(str);
		session.saveOrUpdate(dept);
		tran.commit();
	}
	
	public static void main(String[] args) {
		//增
//		Dept dept=new Dept(1,"软件工程");
//		add(dept);
		
		//查
//		List<Dept> list=find(1);
//		for(Dept dep:list){
//			System.out.println(dep.getDeptid()+" "+dep.getDeptname());	
//		}
		
		//删
//		List<Dept> list=find(1);
//		for(Dept dep:list){
//			System.out.println(dep.getDeptid()+" "+dep.getDeptname());	
//			dele(dep);
//		}
		
		//改
		List<Dept> list=find(1);
		for(Dept dep:list){
			String str="软件工程";
			//System.out.println(dep.getDeptid()+" "+dep.getDeptname());	
			update(dep,str);
		}
	}
}

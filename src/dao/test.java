package dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.Dept;
import hibernate.Student;
import util.HibernateSessionFactory;

public class test {
	public static void main(String[] args) {
		Session s=HibernateSessionFactory.getSession();
		Query q=s.createQuery("from Dept");
		List l=q.list();
		for(int i=0;i<l.size();i++){
			Dept dept=(Dept)l.get(i);
			System.out.println(dept.getDeptid());
			Set stu=dept.getStu();
			Iterator it=stu.iterator();
			while(it.hasNext()){
				Student st=(Student)it.next();
				System.out.println(st.getSno()+" "+st.getSname());
			}
		}
		
	}
}

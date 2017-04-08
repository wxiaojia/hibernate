package hibernate;

import java.util.Set;

public class Dept {
	private int deptid;
	private String deptname;
	private Set<Student> stu;
//	public Dept(){
//		
//	}
	public Dept(int deptid, String deptname) {
		//super();
		this.deptid = deptid;
		this.deptname = deptname;
	}
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public Set<Student> getStu() {
		return stu;
	}
	public void setStu(Set<Student> stu) {
		this.stu = stu;
	}
	
}

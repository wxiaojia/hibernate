package hibernate;

public class Student {
	private int sno;
//	private int deptid;
	private Dept dept;
	private String sname;
	public Student(){
		
	}
	public Student(int sno, String sname,int deptid) {
		//super();
		this.sno = sno;
		//this.deptid = deptid;
		this.sname = sname;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
}

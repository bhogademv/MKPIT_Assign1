package com.mkpit.assig1.DTO;

import java.util.Date;

public class EmployeeDTO {
	 	private Long id;
	    private String name;
	    private String dept;
	    private java.util.Date doj;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDept() {
			return dept;
		}
		public void setDept(String dept) {
			this.dept = dept;
		}
		public java.util.Date getDoj() {
			return doj;
		}
		public void setDoj(java.util.Date doj) {
			this.doj = doj;
		}
		public EmployeeDTO(Long id, String name, String dept, Date doj) {
			super();
			this.id = id;
			this.name = name;
			this.dept = dept;
			this.doj = doj;
		}
		 public EmployeeDTO() {
		    }
}

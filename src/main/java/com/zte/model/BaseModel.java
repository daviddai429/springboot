package com.zte.model;
//
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Transient;

/**
 * 基础model类
 * @author david
 *
 */
public class BaseModel {
	//主键,mysql自增长
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	//@Transient
	private Integer page = 1;
	//@Transient
	private Integer rows = 10;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}

}

package com.jx.projects.entiy;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author  JX.Wu
 * @date  2018年2月2日
 */
@Entity
@Table(name="company")
@Data
public class Company extends BaseEntiy{
	
	private String name;
	
	private String address;
	
	private String branch;
	
	private String remark;
	
}

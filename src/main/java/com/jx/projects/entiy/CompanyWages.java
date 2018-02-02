package com.jx.projects.entiy;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author  JX.Wu
 * @date  2018年2月2日
 */
@Entity
@Table(name="company_wages")
public class CompanyWages extends BaseEntiy{
	
	@ManyToOne(fetch=FetchType.LAZY, cascade = {CascadeType.REFRESH})
    @JoinColumn(name="company_id")
	private Company company;
	
	@Column(name="wages_date")
	private String wagesDate;
	
}

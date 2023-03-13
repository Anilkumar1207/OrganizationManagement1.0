package com.organizationManagement.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Branch {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int branchId;
	@Column
	private String branchName;
	@Column
	private String branchDetails;
	@ManyToOne(targetEntity =Organization.class)
	@JoinColumns({
		@JoinColumn(name = "organization_id", referencedColumnName = "organizationId"),
	    @JoinColumn(name = "organization_name", referencedColumnName = "organizationName")})
	private Organization organization;
	@Version
	private long version;
}
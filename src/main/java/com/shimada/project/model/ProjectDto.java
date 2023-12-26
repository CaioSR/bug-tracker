package com.shimada.project.model;

import com.shimada.application.core.BasicDto;
import com.shimada.util.defaultEntityDisplay.DefaultModelDisplayFormat;
import com.shimada.util.defaultEntityDisplay.DefaultModelDisplayProvider;

/**
 * DTO for {@link ProjectEntity}
 *
 * @author Caio Shimada
 */
public class ProjectDto extends BasicDto {

	private Long code;
	private String name;
	
	/**
	 * Returns the code
	 * @return the code
	 */
	public Long getCode() {
		return code;
	}
	
	/**
	 * Sets the code
	 * @param the code
	 */
	public void setCode(Long code) {
		this.code = code;
	}
	
	/**
	 * Returns the name
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Sets the name
	 * @param the name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Returns code - name
	 * @return code - name
	 */
	public String getCodeName() {
		return DefaultModelDisplayFormat.getDefaultEntityDisplay(new DefaultModelDisplayProvider() {
			
			public Long getFirstParam() {
				return getCode();
			}
			
			public String getSecondParam() {
				return getName();
			}

		});
	}
	
}

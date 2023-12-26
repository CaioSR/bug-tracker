package com.shimada.util.defaultEntityDisplay;

/**
 * Default formatter for displaying models
 *
 * @author Caio Shimada
 */
public class DefaultModelDisplayFormat {

	public static String getDefaultEntityDisplay(DefaultModelDisplayProvider provider) {
		StringBuilder sb = new StringBuilder();
		sb.append(provider.getFirstParam());
		sb.append(" - ");
		sb.append(provider.getSecondParam());
		return sb.toString();
	}
	
}

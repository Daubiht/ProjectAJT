package fr.intech.s5.aspect;

import org.aspectj.lang.JoinPoint;

public class Logging {
	/**
	 * Méthode advice (greffon d’éxécution) que l'on appellera avant l'exécution d'une methode
	 * @param pJoinPoint
	 */
	public void beforeMethod(JoinPoint pJoinPoint) {
		// Récupération de la signature de la méthode
		String methodName = pJoinPoint.getSignature().toShortString();
		
		// Récupération des arguments de la méthode
		Object[] args = pJoinPoint.getArgs();
		
		// StringBuilder permettant de construire le message 
		StringBuilder builder = new StringBuilder();
		builder.append("Méthode ");
		builder.append(methodName);
		builder.append(" invoquée avec les paramètres : ");
		for(Object obj : args) {
			builder.append(obj);
			builder.append(" - ");
		}
		System.out.println(builder.toString());
	}
	
	/**
	 * méthode advice (greffon d’éxécution) que l'on appellera après exécution d'une méthode
	 * @param pJoinPoint
	 * @param pResult
	 */
	public void afterMethod(JoinPoint pJoinPoint, Object pResult) {
		// Récupération de la signature de la méthode
		String methodName = pJoinPoint.getSignature().toShortString();
System.out.println("Méthode " + methodName + " a produit le résultat " + pResult);
	}

}

package streams;

public class Main {
	public static void main(String[] args) {
		Database database = new Database();
		
		//Ejercicio 1 
		System.out.printf("Ejercicio1:%n--------------%n");
		database.showLegalAgeStudentCount(); 
		saltoLinea();
		
		//Ejercicio2
		System.out.printf("Ejercicio2:%n--------------%n");
		database.showStudentNamesOrderAlphabetically(); 
		saltoLinea();
		
		//Ejercicio3
		System.out.printf("Ejercicio3:%n--------------%n");
		database.showFirstTwoStudentsNames();
		saltoLinea();
		
		//Ejercicio4
		System.out.printf("Ejercicio4:%n--------------%n");
		database.showStudentsNamesExceptTheFirstOne();
		saltoLinea();
		
		//Ejercicio5
		System.out.printf("Ejercicio5:%n--------------%n");
		database.showStudentsNamesUntilFirstNotLegalAgeOne();
		saltoLinea();
		
		//Ejercicio6
		System.out.printf("Ejercicio6:%n--------------%n");
		database.showStudentsSinceFirstNotLegalAgeOne();
		saltoLinea();
		
		//Ejercicio7
		System.out.printf("Ejercicio7:%n--------------%n");
		database.showDifferentSubjectsOrderedAlphabetically();
		saltoLinea();
		
		//Ejercicio8
		System.out.printf("Ejercicio8:%n--------------%n");
		database.showStudentsGrantsAndSum();
		saltoLinea();
		
		//Ejercicio9
		System.out.printf("Ejercicio9:%n--------------%n");
		System.out.println(database.getStudentsOlderThan20());
		saltoLinea();
		
		//Ejercicio10
		System.out.printf("Ejercicio10:%n--------------%n");
		database.showYoungestStudentName();
		saltoLinea();
		
		//Ejercicio11
		System.out.printf("Ejercicio11:%n--------------%n");
		database.showOldestStudentOlderThan23();
		saltoLinea();
	
		//Ejercicio12
		System.out.printf("Ejercicio12:%n--------------%n");
		database.showStudentNamesWithCommasOrderedByAge();
		saltoLinea();
		
		//Ejercicio13
		System.out.printf("Ejercicio13:%n--------------%n");
		database.showStudentCountInEachGroup(); 
		saltoLinea();
		
		//Ejercicio14
		System.out.printf("Ejercicio14:%n--------------%n");
		database.showGrantSummary();
		saltoLinea();
		
		//Ejercicio15
		System.out.printf("Ejercicio15:%n--------------%n");
		System.out.print("¿Algún alumno menor de edad? ");
		database.showAreAnyStudentUnderLegalAge();
		saltoLinea();
		
		//Ejercicio16
		System.out.printf("Ejercicio16:%n--------------%n");
		System.out.printf("¿Todos los alumnos tienen beca? ");
		database.showAllStudentHaveGrant();
		saltoLinea();
		
		//Ejercicio17
		System.out.printf("Ejercicio17:%n--------------%n");
		System.out.printf("Nombre del primer alumno sin beca: ");
		database.showFirstStudentWithoutGrant();
		saltoLinea();
		
		//Ejercicio18
		System.out.printf("Ejercicio18:%n--------------%n");
		System.out.println("Alumnos con o sin beca");
		database.showHowManyStudentWithOrWithoutGrant();
		saltoLinea();
		
		//Ejercicio19
		System.out.printf("Ejercicio19:%n--------------%n");
		System.out.println("Número de asignaturas de cada alumno");
		database.showNumberOfSubjectosOfEachStudent();
		saltoLinea();
		
		//Ejercicio20
		System.out.printf("Ejercicio20:%n--------------%n");
		System.out.println("Número de aprobados por asignatura");
		database.showNumberOfPassersStudentsOfEachSubject();		
	}
	
	private static void saltoLinea() {
		System.out.printf("%n%n");
	}
}

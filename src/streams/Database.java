package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Database {
	private List<Student> students = new ArrayList<>();
	
	Database(){
		List<Grade> st1Grades = new ArrayList<>();
		st1Grades.add(new Grade("PROG", 8));
		st1Grades.add(new Grade("LM", 3));
		Student student1 = new Student(1L, "Germán Gines", 23, "1º CFGS DAM", 2000, st1Grades);
		
		List<Grade> st2Grades = new ArrayList<>();
		st2Grades.add(new Grade("PROG", 5));
		st2Grades.add(new Grade("LM", 4));
		Student student2 = new Student(2L, "Baldomero", 21, "1º CFGS DAM", 0, st2Grades);
		
		List<Grade> st3Grades = new ArrayList<>();
		st3Grades.add(new Grade("PROG", 8));
		Student student3 = new Student(3L, "Ana Guerra", 17, "1º CFGM SMR", 4000, st3Grades);
		
		students.add(student1);
		students.add(student2);
		students.add(student3);
	}
	
	
	public List<Student> queryAllStudents(){
		return students;
	}
	
	//1
	public void showLegalAgeStudentCount() {
		long stream = students.stream()
				.filter(n -> n.getAge()>=18)
				.count();
		System.out.println(stream);
	}
	
	//2
	public void showStudentNamesOrderAlphabetically() {
		students.stream()
			.sorted((s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName()))
			.forEach(n -> System.out.println(n.getName()));
	}
	
	//3
	public void showFirstTwoStudentsNames(){
		students.stream()
			.limit(2)
			.forEach(n -> System.out.println(n.getName()));
	}
	
	//4
	public void showStudentsNamesExceptTheFirstOne() {
		students.stream()
			.skip(1)
			.forEach(n -> System.out.println(n.getName()));
	}
	
	//5
	public void showStudentsNamesUntilFirstNotLegalAgeOne() {
		students.stream()
			.takeWhile(n -> n.getAge() >= 18)
			.forEach(n -> System.out.println(n.getName()));
	}
	
	//6
	public void showStudentsSinceFirstNotLegalAgeOne() {
		students.stream()
			.dropWhile(n -> n.getAge() >= 18)
			.forEach(n -> System.out.println(n.getName()));
		
	}
	
	//7
	public void showDifferentSubjectsOrderedAlphabetically() {
		students.stream()
			.flatMap(n -> n.getGrades().stream())
			.map(n -> n.getSubject())
			.sorted((s1, s2) -> s1.compareToIgnoreCase(s2))
			.distinct()
			.forEach(n -> System.out.println(n));
	}
	
	//8
	public void showStudentsGrantsAndSum() {
		int becas = students.stream()
			.peek(n -> System.out.printf("%s: %d%n", n.getName(), n.getGrant()))
			.mapToInt(n -> n.getGrant())
			.sum();
		System.out.printf("Suma de becas: %d%n", becas);
	}
	
	//9
	public List<String> getStudentsOlderThan20() {
		return students.stream()
					.filter(n -> n.getAge()>20)
					.map(n -> n.getName())
					.collect(Collectors.toList());
	}
	
	//10
	public void showYoungestStudentName() {
		String nombre = students.stream()
			.min(Comparator.comparingInt(Student::getAge))
			.map(n -> n.getName())
			.orElse("No encontrado");
		
		System.out.printf("El alumno más joven es: %s%n", nombre);
	}
	
	//11
	public void showOldestStudentOlderThan23() {
		String nombre = students.stream()
			.filter(n -> n.getAge()>23)
			.max(Comparator.comparingInt(Student::getAge))
			.map(n -> n.getName())
			.orElse("No encontrado");
		
		System.out.printf("Alumno más veterano mayor de 23: %s%n", nombre);
	}
	
	//12
	public void showStudentNamesWithCommasOrderedByAge() {
		String estudiantes = students.stream()
			.sorted((s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()))
			.map(n -> n.getName())
			.collect(Collectors.joining(","));
		
		System.out.println(estudiantes);
	}
	
	//13
	public void showStudentCountInEachGroup() {
		Map<String, Long> estudiantesPorGrupo = students.stream()
			.collect(Collectors.groupingBy(Student::getGroup, Collectors.counting()));
			
		System.out.println(estudiantesPorGrupo);
	}
	
	//14
	public void showGrantSummary() {
		IntSummaryStatistics estadisticas = students.stream()
			.map(n -> n.getGrant())
			.collect(Collectors.summarizingInt(n -> n));
		
		System.out.println(estadisticas);
	}
	
	//15
	public void showAreAnyStudentUnderLegalAge() {
		System.out.println(students.stream()
							.anyMatch(n -> n.getAge() >= 18)?"Si":"No");
	}
	
	//16
	public void showAllStudentHaveGrant() {
		System.out.println(students.stream()
							.allMatch(n -> n.getGrant() > 0)?"Si":"No");
	}
	
	//17
	public void showFirstStudentWithoutGrant() {
		students.stream()
			.filter(n -> n.getGrant()!=0)
			.limit(1)
			.forEach(n -> System.out.println(n.getName()));	
	}
	
	//18
	public void showHowManyStudentWithOrWithoutGrant() {
		students.stream()
			.map(n -> n.getGrant())
			.collect(Collectors.partitioningBy(n -> n > 0, Collectors.counting()))
			.forEach((k, v) -> System.out.printf("%s: %d%n",k?"Con beca":"Sin beca", v ));
	}
	
	//19
	public void showNumberOfSubjectosOfEachStudent() {
		students.stream()
			.sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
			.forEach(n -> System.out.printf("%s: %d%n", n.getName(), n.getGrades().size()));
	}
	
	//20
	public void showNumberOfPassersStudentsOfEachSubject() {
		students.stream()
			.flatMap(n -> n.getGrades().stream())
			.collect(Collectors.groupingBy(Grade::getSubject, Collectors.filtering(n -> n.getMark() >= 5, Collectors.counting())))
			.forEach((k, v) -> System.out.printf("%s: %d%n", k, v));
	}
	
	

}

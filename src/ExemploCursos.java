import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExemploCursos {

	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));

//		cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));

//		cursos.forEach(c -> System.out.println(c.getNome()));

//		Stream<Curso> streamDeCurso = cursos.stream().filter(c -> c.getAlunos() > 100);
//		System.out.println("Nova lista");
//		streamDeCurso.forEach(c -> System.out.println(c.getNome()));

//		cursos.stream()
//			.filter(c -> c.getAlunos() > 100)
//			.forEach(c -> System.out.println(c.getNome()));

//		cursos.stream()
//		.filter(c -> c.getAlunos() > 100)
//		.map(c -> c.getAlunos())
//		.forEach(x -> System.out.println(x));

//		cursos.stream()
//		.filter(c -> c.getAlunos() > 100)
//		.map(Curso::getAlunos)
//		.forEach(System.out::println);

//		int soma = cursos.stream()
//				   .filter(c -> c.getAlunos() > 100)
//				   .mapToInt(Curso::getAlunos)
//				   .sum();
//		System.out.println(soma);

		Optional<Curso> optional = cursos.stream()
			.filter(c -> c.getAlunos() > 100)
			.findAny();
		
		//Curso curso = optional.orElse(null);

		optional.ifPresent(c -> System.out.println(c.getNome()));
		
		cursos.stream()
			.filter(c -> c.getAlunos() > 100)
			.findAny()
			.ifPresent(c -> System.out.println(c.getNome()));
		
		List<Curso> resultados = cursos.stream()
				.filter(c -> c.getAlunos() > 100)
				.collect(Collectors.toList());
		
		System.out.println("###");
		resultados.forEach(r -> System.out.println(r.getNome()));
		
		cursos.stream() 
				.filter(c -> c.getAlunos() > 100) 
				.collect(Collectors.toMap(
						c -> c.getNome(), 
						c -> c.getAlunos()))
				.forEach((nome, alunos) -> System.out.println(nome + " tem "+ alunos + " alunos" ));
		
		
	}
}

package homework8.part2;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static homework8.part2.GenerateData.getEmployees;

@SuppressWarnings({"unused"})
public class StreamOperations {

    void findPersonsEverWorkedInEpam() {
        List<Employee> employees = getEmployees();

        // TODO реализация, использовать Collectors.toList()
        List<Person> personsEverWorkedInEpam = employees.stream()
                .filter(employee -> employee.getJobHistory().stream().anyMatch(jhe -> jhe.getCompany().equals("EPAM")))
                .map(Employee::getPerson)
                .collect(Collectors.toList());



//        personsEverWorkedInEpam - should contain employees.get(0),  employees.get(1),
//                employees.get(4), employees.get(5)
    }

    void findPersonsBeganCareerInEpam() {
        List<Employee> employees = getEmployees();

        // TODO реализация, использовать Collectors.toList()
        List<Person> startedFromEpam = employees.stream()
                .filter(employee -> employee.getJobHistory().get(0).getCompany().equals("EPAM"))
                .map(Employee::getPerson)
                .collect(Collectors.toList());

//        startedFromEpam - should contain
//                employees.get(0).getPerson(),
//                employees.get(1).getPerson(),
//                employees.get(4).getPerson()
    }

    void findAllCompanies() {
        List<Employee> employees = getEmployees();

        // TODO реализация, использовать Collectors.toSet()
        Set<String> companies = employees.stream()
                .map(Employee::getJobHistory)
                .flatMap(Collection::stream)
                .map(JobHistoryEntry::getCompany)
                .collect(Collectors.toSet());

//        companies - should contain "EPAM", "google", "yandex", "mail.ru", "T-Systems"
    }

    void findMinimalAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        // TODO реализация
        Integer minimalAge = employees.stream()
                .map(Employee::getPerson)
                .map(Person::getAge)
                .min(Integer::compareTo).orElse(0);

        // minmalAge = 21
    }

    // Посчитать средний возраст работников
    void calcAverageAgeOfEmployees() {
        List<Employee> employees = getEmployees();

        Double expected = employees.stream()
                .mapToInt(employee -> employee.getPerson().getAge())
                .average()
                .getAsDouble();

    }

    // Найти Person с самым длинным fullName
    void findPersonWithLongestFullName() {
        List<Employee> employees = getEmployees();

        Person expected = employees.stream()
                .map(Employee::getPerson)
                .max(Comparator.comparingInt(person -> person.getLastName().length() + person.getFirstName().length()))
                .get();

    }

    // Найти работника с самой большой продолжительность на одной же позиции
    void findEmployeeWithMaximumDurationAtOnePosition() {
        List<Employee> employees = getEmployees();

        Employee expected = employees.stream()
                .max(Comparator.comparingInt(employee -> employee.getJobHistory().stream()
                .max(Comparator.comparingInt(JobHistoryEntry::getDuration)).get().getDuration()))
                .get();

    }

}
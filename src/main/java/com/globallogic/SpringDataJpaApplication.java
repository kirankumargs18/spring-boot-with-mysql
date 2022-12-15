package com.globallogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.globallogic.entity.Employee;
import com.globallogic.repository.EmployeeRepository;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {

		SpringApplication.run(SpringDataJpaApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		// Insert employee
		Employee employee = new Employee();

		employee.setId(20);
		employee.setName("Manoj");
		employee.setAge(24);
		employee.setDepartment("Development");
		employee.setSalary(60000);

		employeeRepository.save(employee);

		System.out.println("Inserted : " + employee);

		System.out.println("============================================================================");

		// retrieve all employees
		System.out.println("All Employees in DB");
		employeeRepository.findAll().forEach(System.out::println);

		System.out.println("============================================================================");

		// retrieve by employee id
		Employee employee1 = employeeRepository.findById(14).get();
		System.out.println("Employee with id(11) : " + employee1);

		System.out.println("============================================================================");

		// retrieve by employee name
		Employee employee2 = employeeRepository.findByName("Kiran");
		System.out.println("Employee with Name (Kiran) : " + employee2);

		System.out.println("Number of employees in DB : " + employeeRepository.count());

		System.out.println("============================================================================");

		/*
		 * // delete by entity Employee employee3 =
		 * employeeRepository.findById(11).get(); employeeRepository.delete(employee3);
		 * System.out.println("Deleted by Entity");
		 */

		// delete by id
		employeeRepository.deleteById(20);
		System.out.println("Deleted by ID");

		// update employee

		System.out.println("============================================================================");

		Employee employee5 = employeeRepository.findById(10).get();
		employee5.setDepartment("HR");
		employee5.setSalary(70000);
		employeeRepository.save(employee5);

		System.out.println("============================================================================");

		System.out.println("Number of employees : " + employeeRepository.count());

	}

}

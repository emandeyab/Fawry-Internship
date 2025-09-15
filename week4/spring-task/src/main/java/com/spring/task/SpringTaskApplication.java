package com.spring.task;

import com.spring.task.configuration.AppConfig;
import com.spring.task.models.Employee;
import com.spring.task.services.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringTaskApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringTaskApplication.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		EmployeeService employeeService = context.getBean(EmployeeService.class);

		//add
		employeeService.addEmp(new Employee(1, "Eman", 40000.0));
		employeeService.addEmp(new Employee(2, "Ali", 20000.0));
		employeeService.addEmp(new Employee(3, "Sara", 30000.0));
		employeeService.addEmp(new Employee(4, "Ehab", 15000.0));

		//print
		employeeService.getEmployee().values().forEach(System.out::println);

		//update
		employeeService.updateEmp(new Employee(1, "Eman Diab", 45000.0));

		//delete
		employeeService.deleteEmp(4);

		//print after cruds
		employeeService.getEmployee().values().forEach(System.out::println);

		//close
		context.close();

	}

}

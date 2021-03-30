package springboot.controller;

import java.lang.ProcessBuilder.Redirect;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import springboot.model.Employee;
import springboot.repository.EmployeeRepository;

@Controller
public class MyController {
	@Autowired
	EmployeeRepository employeeRepository;
	
	@RequestMapping("")
	public String Homepage(Model model)
	{
		model.addAttribute("mesg", "My Name is jhon");
		model.addAttribute("mesg1", "My Name is alia");
		model.addAttribute("mesg2", "My Name is Amit");
		return "index";
	}
	
	@GetMapping("/showForm")
	public String EmpForm(Employee employee)
	{
		return "showForm";
	}
	
	@PostMapping("/addForm")
	public String EmpAddForm(@Valid Employee employee, BindingResult result,Model model)
	{
		if (result.hasErrors()) {
            return "showForm";
        }

		employeeRepository.save(employee);
		return "redirect:list";
	}
	
	@GetMapping("/list")
    public String showDataForm(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        return "showData";
    }
	
	@GetMapping("empedit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        model.addAttribute("employees", employee);
        return "updateEmployee";
    }
	
	 @PostMapping("empupdate/{id}")
	    public String updateEmployee(@PathVariable("id") long id, @Valid Employee employee, BindingResult result,
	        Model model) {
	        if (result.hasErrors()) {
	            employee.setId(id);
	            return "updateEmployee";
	        }
	        
	        employeeRepository.save(employee);
	        model.addAttribute("employees", employeeRepository.findAll());
	        return "showData";
	 }
	 
	 @GetMapping("empdelete/{id}")
	    public String deleteStudent(@PathVariable("id") long id, Model model) {
		 Employee employee = employeeRepository.findById(id)
				 .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
		 employeeRepository.delete(employee);
	        model.addAttribute("employees", employeeRepository.findAll());
	        return "showData";
	    }
		
		@RequestMapping("/contact")
		public String contactPage(Model model)
		{
			
			return "contact";
		}

	}





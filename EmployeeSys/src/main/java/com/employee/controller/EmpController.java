package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entities.Employee;
import com.employee.services.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	@Autowired
	private EmployeeService emService; 
	
	@GetMapping("/")

	public String home(Model m) {
		List<Employee> emp=this.emService.getAllEmp();
		m.addAttribute("emp",emp);
		return "index";
	}
	@GetMapping("/addemp")
	public String addemp() {
		return "ademp";
	}
	
//	@GetMapping("/emps")
//	public List<Employee> getEmps(){
//		List<Employee> list = this.emService.getAllEmp();
//		return list;
//	}
	
	

	@PostMapping("/register")
	public String empReg(@ModelAttribute Employee e, HttpSession session) {
		emService.addEmp(e);
		session.setAttribute("msg", "Employee Added Successfully..");
		
		return "redirect:/";
	}
	

	
//	@GetMapping("/edit/{empid}")
//	public String edit(@PathVariable int empid, Model m) {
//		Employee e = emService.getEMpById(empid);
//		m.addAttribute("emp", e);
//		return "edit";
//	}
	
	
	@GetMapping("/edit/{empid}")
	public String edit(@PathVariable int empid, Model m) {
		Employee e= emService.getEMpById(empid);
		m.addAttribute(e);
		
		return "edit";
	}


	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e, HttpSession session) {
		emService.addEmp(e);
		session.setAttribute("msg", "Emp Data Update Sucessfully..");
		return "redirect:/";
	}

	@GetMapping("/delete/{empid}")
	public String deleteEMp(@PathVariable int empid, HttpSession session) {

		emService.deleteEMp(empid);
		session.setAttribute("msg", "Emp Data Delete Sucessfully..");
		return "redirect:/";
	}

//	@GetMapping("/page/{pageno}")
//	public String findPaginated(@PathVariable int pageno, Model m) {
//
//		Page<Employee> emplist = emService.getEMpByPaginate(pageno, 2);
//		m.addAttribute("emp", emplist);
//		m.addAttribute("currentPage", pageno);
//		m.addAttribute("totalPages", emplist.getTotalPages());
//		m.addAttribute("totalItem", emplist.getTotalElements());
//		return "index";
//	}

	
//	@GetMapping(value="/edit/{empid}")
//	public String edit(@RequestParam(value="empdid", required = false) Integer empid, Model m){
//		Employee c=emService.getEmployeeById(empid);
//		System.out.println(c.getEmpid());
//		m.addAttribute("emp", c);
//		return "edit";
//	}
		
}

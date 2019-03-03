package com.step.spring.rest.client.controller;

import com.step.spring.rest.client.model.Student;
import com.step.spring.rest.client.model.StudentListResp;
import com.step.spring.rest.client.model.StudentResp;
import com.step.spring.rest.client.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    @Value("${rest.service.host}")
    private String serviceHost;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/")
    public String openIndexPage(Model model) {
        StudentListResp response = restTemplate.getForObject(serviceHost + "/students", StudentListResp.class);

        List<Student> students = new ArrayList<>();

        System.out.println(response);
        if (response.getStatus().getCode() == Constants.CODE_SUCCESS) {
            students = response.getStudents();
        }

        model.addAttribute("students", students);
        return "index";
    }

    @RequestMapping("/student")
    public String openStudentPage(@RequestParam("id") int id, Model model, RedirectAttributes redirectAttributes) {
        StudentResp response = restTemplate.getForObject(serviceHost + "/students/" + id, StudentResp.class);

        System.out.println(response);
        if (response.getStatus().getCode() != Constants.CODE_SUCCESS) {
            redirectAttributes.addFlashAttribute("message", response.getStatus().getMessage());
            return "redirect:/";
        }

        model.addAttribute("student", response.getStudent());
        return "student";
    }

    @GetMapping("/add-student")
    public String openAddStudentPage(Model model) {
        model.addAttribute("student", new Student());
        return "add-student";
    }

    @PostMapping("/add-student")
    public String addStudent(@ModelAttribute("student") Student student, RedirectAttributes redirectAttributes) {
        StudentResp response = restTemplate.postForObject(serviceHost + "/students", student, StudentResp.class);

        redirectAttributes.addFlashAttribute("message", response.getStatus().getMessage());

        return "redirect:/";
    }

    @RequestMapping("/delete-student")
    public String deleteStudent(@RequestParam("id") int id, RedirectAttributes redirectAttributes) {
        ResponseEntity<StudentResp> responseEntity = restTemplate.exchange(serviceHost + "/students/" + id, HttpMethod.DELETE, HttpEntity.EMPTY, StudentResp.class);

        System.out.println(responseEntity.getBody());
        if (responseEntity.getBody() != null) {
            redirectAttributes.addFlashAttribute("message",responseEntity.getBody().getStatus().getMessage());
        }

        return "redirect:/";
    }


    @PostMapping("/update-student/{id}")
    public String updateStudent(@PathVariable("id") int id, @ModelAttribute("student") Student student, RedirectAttributes redirectAttributes){
        HttpEntity<Student> httpEntity = new HttpEntity<>(student);
        ResponseEntity<StudentResp> responseEntity = restTemplate.exchange(serviceHost + "/students/" + id, HttpMethod.PUT, httpEntity, StudentResp.class);

        if (responseEntity.getBody()!=null){
            redirectAttributes.addFlashAttribute("message", responseEntity.getBody().getStatus().getMessage());
        }

        return "redirect:/";
    }


}

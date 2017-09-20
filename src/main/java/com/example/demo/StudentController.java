package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class StudentController {


    private String firstName;
    private String lastName;
    private Grade grade;
    private Model model;

    @RequestMapping("new_student")
    public String newStudent (Model model) {
        /* call the method on the Grade enum to get all the grades */
        model.addAttribute("grades", Grade.values ());

//        this is just like the example from newline, why not working?

        //the attribute is grades so we are selecting all the grade values from the enum Grade
        //when we put it in html it should select the Grade.values

        return "new_student";
    }



    @RequestMapping ("create_student")
    public String createStudent(@ModelAttribute
                                    @RequestParam(value="firstName") String firstName,
                                /* @RequestParam for last name */
                                @RequestParam(value="lastName") String lastName,
                                /* @RequestParam for grade */
                                @RequestParam(value="grades") Grade grade,
                                Model model) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.model = model;
        Student student = new Student(firstName, lastName, grade);

        /* set student firstName, lastName and grade using the http request parameters */
        student.setFirstName (firstName);
        student.setLastName (lastName);
        student.setGrade (grade);


        /* add the student to the model that will be used by the view_student html file */
        model.addAttribute ("student", student);

//this should be returning the view_student under templates why isnt it?
        return "view_student";
    }
}

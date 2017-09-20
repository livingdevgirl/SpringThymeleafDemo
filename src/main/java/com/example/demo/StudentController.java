package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StudentController {


    @RequestMapping("/new_student")
    public String newStudent (Model model) {
        /* call the method on the Grade enum to get all the grades */
        model.addAttribute("grades", Grade.values ());

//        this is just like the example from newline, why not working?

        //the attribute is grades so we are selecting all the grade values from the enum Grade
        //when we put it in html it should select the Grade.values

        return "new_student";
    }



    @PostMapping("/create_student")
    public String createStudent(@ModelAttribute
                                    @RequestParam(name="first_Name") String firstName,
                                /* @RequestParam for last name */
                                @RequestParam(name="last_Name") String lastName,
                                /* @RequestParam for grade */
                                @RequestParam(name="grade") Grade grade,
                                Model model) {
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

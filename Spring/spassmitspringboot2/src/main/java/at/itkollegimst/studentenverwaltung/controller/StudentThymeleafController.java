package at.itkollegimst.studentenverwaltung.controller;

import at.itkollegimst.studentenverwaltung.domain.Student;
import at.itkollegimst.studentenverwaltung.exceptions.StudentNichtGefunden;
import at.itkollegimst.studentenverwaltung.services.StudentenService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/web/v1/studenten")
public class StudentThymeleafController {

    private StudentenService studentService;

    public StudentThymeleafController(StudentenService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String gibAlleStudenten(Model model){
        model.addAttribute("allStudents", this.studentService.alleStudenten());
        return "allestudenten";
    }

    @GetMapping("/insert")
    public String studentenEinfuegenFormular(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "studenteneinfuegen";
    }

    @PostMapping("/insert")
    public String studentEinfuegen(@Valid Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "studenteneinfuegen";
        }else{
            this.studentService.studentEinfuegen(student);
            return "redirect:/web/v1/studenten";
        }
    }

    @GetMapping("/update/{id}")
    public String studentUpdatenFormular(@PathVariable Long id, Model model){

        try{
            Student student = this.studentService.studentMitId(id);
            model.addAttribute("student", student);
            return "studentenupdaten";

        }catch (StudentNichtGefunden studentNichtGefunden){
            return "redirect:web/v1/studenten";
        }
    }

    @PostMapping("/update")
    public String stuentUpdaten(@Valid Student student, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "studentenupdaten";
        }else{
            try{
                this.studentService.studentUpdaten(student);
                return "redirect:/web/v1/studenten";

            }catch (StudentNichtGefunden studentNichtGefunden){
                return "redirect:/web/v1/studenten";
            }
        }
    }

}

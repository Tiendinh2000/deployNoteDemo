package com.example.demo.Controller;

import com.example.demo.Model.Note;
import com.example.demo.Service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class NoteController {
    @Autowired
    private INoteService noteService;

    @GetMapping(value = {"/homepage", "/"})
    private String List(Model model) {
        System.out.println(noteService.findAll().toString());
        model.addAttribute("listofnote",noteService.findAll());
        return "list";
    }

    @GetMapping(value = "/addpage")
    private String GetAddNote(Model model) {
      model.addAttribute("newNote", new Note());
        return "create";
    }

    @PostMapping(value = "/add")
    private String add(Model model, @ModelAttribute("newNote") Note note) {
        noteService.createNote(note);
        System.err.println(note.toString());
        return "redirect:/homepage";
    }

    @GetMapping(value = "/updatepage/{id}")
    private String GetUpdateNote(Model model, @PathVariable("id") int id ) {
        Note note = noteService.findById(id);
        model.addAttribute("newNote", note);
        return "update";
    }

    @PostMapping(value = "/update")
    private String update(Model model, @ModelAttribute("newNote") Note note) {
        noteService.update(note);
        System.err.println(note.toString());
        return "redirect:/homepage";
    }

    @RequestMapping(value = "/delete/{id}")
    private String delete(Model model,@PathVariable("id") int id){
        noteService.delelet(id);
        return "redirect:/homepage";
    }
}

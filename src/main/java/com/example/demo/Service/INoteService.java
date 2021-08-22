package com.example.demo.Service;

import com.example.demo.Model.Note;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface INoteService {
     Note createNote(Note note);
     Note update(Note update);
     int delelet(int id);
     List<Note> findAll();
Note findById(int id);
}

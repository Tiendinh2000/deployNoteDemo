package com.example.demo.Service.Implement;

import com.example.demo.Model.Note;
import com.example.demo.Repository.NoteRepository;
import com.example.demo.Service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteService implements INoteService {

    @Autowired
    private NoteRepository repository;

    @Override
    public Note createNote(Note note) {
        return repository.save(note);
    }

    @Override
    public Note update(Note newNote) {
        if (repository.existsById(newNote.getId())) {
            Note old = repository.findById(newNote.getId()).get();
            old.setNote(newNote.getNote());
            old.setName(newNote.getName());
            old.setTime_created(newNote.getTime_created());
          return repository.save(old);
        } else
            return null;
    }

    @Override
    public int delelet(int id) {
        try {
            Note n = repository.findById(id).get();
            repository.delete(n);
            return id;
        } catch (Exception e) {
            return -1;
        }

    }

    @Override
    public List<Note> findAll() {
        return repository.findAll();
    }

    @Override
    public Note findById(int id) {
        return repository.findById(id).get();
    }
}

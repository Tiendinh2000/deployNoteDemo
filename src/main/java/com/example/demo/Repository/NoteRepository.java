package com.example.demo.Repository;

import com.example.demo.Model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface NoteRepository extends JpaRepository<Note,Integer> {
}

package app.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Classroom;

public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {

}

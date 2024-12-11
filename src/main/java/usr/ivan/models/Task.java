package usr.ivan.models;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "task")
public class Task {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String title;
  @Column(nullable = false)
  private String description;
  @Column(nullable = false)
  private boolean completed;
  @Column(nullable = false)
  private LocalDate date;

  public Task(String title, String descripcion, LocalDate date) {
    this.title = title;
    this.description = descripcion;
    this.date = date;
    this.completed = false;
  }

  public Task() {
  } // Lo necesita hibernate para fulurar

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isCompleted() {
    return completed;
  }

  public void setCompleted(boolean completed) {
    this.completed = completed;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  @Override
  public String toString() {
    return "ID: " + id + "\n" +
        "Titulo: " + title + "\n" +
        "Descripción: " + description + "\n" +
        "Completada? " + completed + "\n" +
        "Fecha: " + date + "\n" +
        "****************************";
  }
}

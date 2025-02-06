package com.wmart.todoapp.model;

import java.time.LocalDate;

public record Task(String title, boolean status, LocalDate dueDate) {
}

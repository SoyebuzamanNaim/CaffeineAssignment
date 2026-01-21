package com.example.caffeine.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Student {
    @Id
    String id;

    String name;
    String dept;
}

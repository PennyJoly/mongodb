package com.penny.mongodb.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "test_collection")
@Data
public class User {

    @Id
    private String id;

    @Indexed
    private String user;

    @Indexed
    private String pwd;




}

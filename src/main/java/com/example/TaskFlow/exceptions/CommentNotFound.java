package com.example.TaskFlow.exceptions;

public class CommentNotFound  extends  RuntimeException{

    public CommentNotFound (Long id){
        super("Comment with id: "+ id + " not found.");
    }
}

package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Todo {
    private Integer id;
    private Integer userId;
    private String title;
    private Boolean completed;
}

package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    //"id": 1,
    //    "name": "Leanne Graham",
    //    "username": "Bret",
    //    "email": "Sincere@april.biz",
}

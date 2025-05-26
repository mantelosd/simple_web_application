package main.dto;

public class UserNameDto {
    private Long id;
    private String name;
    private String surname;

    public UserNameDto(Long id,String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    // Getters
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
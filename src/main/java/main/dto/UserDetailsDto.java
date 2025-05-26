package main.dto;

import java.time.LocalDate;

public class UserDetailsDto extends UserNameDto{
    public UserDetailsDto(Long id, String name, String surname) {
        super(id, name, surname);
    }

    private String gender;
    private LocalDate birthdate;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getWorkAddress() {
        return workAddress;
    }

    public void setWorkAddress(String workAddress) {
        this.workAddress = workAddress;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    private String workAddress;
    private String homeAddress;
}

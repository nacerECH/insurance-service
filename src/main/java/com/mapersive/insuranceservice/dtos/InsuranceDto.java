package com.mapersive.insuranceservice.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mapersive.insuranceservice.entities.enums.VEHICLE_SEGMENT;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class InsuranceDto {
    @JsonProperty("Date_of_Purchase")
    @NotBlank
    public String date_of_Purchase;
    @JsonProperty("Policy_id")
    @NotBlank
    public Long policy_id;
    @JsonProperty("Customer_id")
    @NotBlank
    public Long customer_id;
    @JsonProperty("Fuel")
    @NotBlank
    public String fuel;
    @JsonProperty("VEHICLE_SEGMENT")
    @NotBlank
    public VEHICLE_SEGMENT vEHICLE_SEGMENT;
    @JsonProperty("Premium")
    @NotBlank
    public int premium;
    @NotBlank
    public int bodily_injury_liability;
    @NotBlank
    public int personal_injury_protection;
    @NotBlank
    public int property_damage_liability;
    @NotBlank
    public int collision;
    @NotBlank
    public int comprehensive;
    @NotBlank
    @JsonProperty("Customer_Gender")
    public String customer_Gender;
    @JsonProperty("Customer_Income_group")
    @NotBlank
    public String customer_Income_group;
    @JsonProperty("Customer_Region")
    @NotBlank
    public String customer_Region;
    @JsonProperty("Customer_Marital_status")
    @NotBlank
    public int customer_Marital_status;


    public InsuranceDto(String date_of_Purchase, Long policy_id, Long customer_id, String fuel, VEHICLE_SEGMENT vEHICLE_SEGMENT, int premium, int bodily_injury_liability, int personal_injury_protection, int property_damage_liability, int collision, int comprehensive, String customer_Gender, String customer_Income_group, String customer_Region, int customer_Marital_status) {
        this.date_of_Purchase = date_of_Purchase;
        this.policy_id = policy_id;
        this.customer_id = customer_id;
        this.fuel = fuel;
        this.vEHICLE_SEGMENT = vEHICLE_SEGMENT;
        this.premium = premium;
        this.bodily_injury_liability = bodily_injury_liability;
        this.personal_injury_protection = personal_injury_protection;
        this.property_damage_liability = property_damage_liability;
        this.collision = collision;
        this.comprehensive = comprehensive;
        this.customer_Gender = customer_Gender;
        this.customer_Income_group = customer_Income_group;
        this.customer_Region = customer_Region;
        this.customer_Marital_status = customer_Marital_status;
    }

    public InsuranceDto(){

    }

    public String  getDate_of_Purchase() {
        return date_of_Purchase;
    }

    public void setDate_of_Purchase(String  date_of_Purchase) {
        this.date_of_Purchase = date_of_Purchase;
    }

    public Long getPolicy_id() {
        return policy_id;
    }

    public void setPolicy_id(Long policy_id) {
        this.policy_id = policy_id;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public VEHICLE_SEGMENT getvEHICLE_SEGMENT() {
        return vEHICLE_SEGMENT;
    }

    public void setvEHICLE_SEGMENT(VEHICLE_SEGMENT vEHICLE_SEGMENT) {
        this.vEHICLE_SEGMENT = vEHICLE_SEGMENT;
    }

    public int getPremium() {
        return premium;
    }

    public void setPremium(int premium) {
        this.premium = premium;
    }

    public int getBodily_injury_liability() {
        return bodily_injury_liability;
    }

    public void setBodily_injury_liability(int bodily_injury_liability) {
        this.bodily_injury_liability = bodily_injury_liability;
    }

    public int getPersonal_injury_protection() {
        return personal_injury_protection;
    }

    public void setPersonal_injury_protection(int personal_injury_protection) {
        this.personal_injury_protection = personal_injury_protection;
    }

    public int getProperty_damage_liability() {
        return property_damage_liability;
    }

    public void setProperty_damage_liability(int property_damage_liability) {
        this.property_damage_liability = property_damage_liability;
    }

    public int getCollision() {
        return collision;
    }

    public void setCollision(int collision) {
        this.collision = collision;
    }

    public int getComprehensive() {
        return comprehensive;
    }

    public void setComprehensive(int comprehensive) {
        this.comprehensive = comprehensive;
    }

    public String getCustomer_Gender() {
        return customer_Gender;
    }

    public void setCustomer_Gender(String customer_Gender) {
        this.customer_Gender = customer_Gender;
    }

    public String getCustomer_Income_group() {
        return customer_Income_group;
    }

    public void setCustomer_Income_group(String customer_Income_group) {
        this.customer_Income_group = customer_Income_group;
    }

    public String getCustomer_Region() {
        return customer_Region;
    }

    public void setCustomer_Region(String customer_Region) {
        this.customer_Region = customer_Region;
    }

    public int getCustomer_Marital_status() {
        return customer_Marital_status;
    }

    public void setCustomer_Marital_status(int customer_Marital_status) {
        this.customer_Marital_status = customer_Marital_status;
    }

    @Override
    public String toString() {
        return "InsuranceDto{" +
                "date_of_Purchase=" + date_of_Purchase +
                ", policy_id=" + policy_id +
                ", customer_id=" + customer_id +
                ", fuel='" + fuel + '\'' +
                ", vEHICLE_SEGMENT=" + vEHICLE_SEGMENT +
                ", premium=" + premium +
                ", bodily_injury_liability=" + bodily_injury_liability +
                ", personal_injury_protection=" + personal_injury_protection +
                ", property_damage_liability=" + property_damage_liability +
                ", collision=" + collision +
                ", comprehensive=" + comprehensive +
                ", customer_Gender='" + customer_Gender + '\'' +
                ", customer_Income_group='" + customer_Income_group + '\'' +
                ", customer_Region='" + customer_Region + '\'' +
                ", customer_Marital_status=" + customer_Marital_status +
                '}';
    }
}

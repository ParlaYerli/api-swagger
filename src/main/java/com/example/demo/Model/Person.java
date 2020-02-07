package com.example.demo.Model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data
@Entity
@Table(name="person")
@ApiModel(description = "All details about the Person. ")
@EntityListeners(AuditingEntityListener.class)
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "The database generated employee ID")
    private int id;
    @ApiModelProperty(notes = "The employee first name")
    @Column(name = "name")
    private String name;
}

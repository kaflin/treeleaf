package com.vts.treeleaf.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vehicleName;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Location> location;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Camera> camera;
}

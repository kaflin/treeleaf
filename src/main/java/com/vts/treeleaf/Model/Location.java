package com.vts.treeleaf.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String locationName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicleId", referencedColumnName = "id")
    private Vehicle vehicle;

}

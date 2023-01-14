package com.nastyabeggin.lab4back.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "points")
public class PointBean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "point_seq")
    @SequenceGenerator(name = "point_seq", sequenceName = "point_id_sequence")
    private Long id;

    @Column(name = "x")
    private Double x;

    @Column(name = "y")
    private Double y;

    @Column(name = "r")
    private Double r;

    @Column(name = "time")
    private String time;

    @Column(name = "execution")
    private String execution;

    @Column(name = "result")
    private boolean result;

    @Column(name = "username")
    private String username;

    public void setTime(Date time) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyy HH:mm:ss");
        this.time = sdf.format(time);
    }

}

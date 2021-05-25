package com.example.quizztest.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Theme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "theme", cascade = CascadeType.ALL)
    private List<Level> levels;

    public Theme(String name) {
        this.name = name;
    }


    public void addLevel(Level level) {
        if(getLevels()==null) {
            this.levels = new ArrayList<>();
        }
        getLevels().add(level);
        level.setTheme(this);
    }

    public Theme() {
    }

    public Theme(String name, List<Level> levels) {
        this.name = name;
        this.levels = levels;
    }

}

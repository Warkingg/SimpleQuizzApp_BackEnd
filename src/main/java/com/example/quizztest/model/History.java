package com.example.quizztest.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
public class History {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String username;

        private String themeName;

        private String levelName;

        private int total;

        private int sore;

        public History() {
        }

        public History(String username, String themeName, String levelName, int total, int sore) {
            this.username = username;
            this.themeName = themeName;
            this.levelName = levelName;
            this.total = total;
            this.sore = sore;
        }
}

package com.payease.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import java.io.Serializable;

/**
 * Created by hrym13 on 2018/3/31.
 */
@Entity
public class Girl implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private String cupSize;
    @Min(value = 18,message = "未成年人禁止入内！")
    private int age;
    private int time;


    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCupSize() {
            return cupSize;
        }

        public void setCupSize(String cupSize) {
            this.cupSize = cupSize;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                ", time=" + time +
                '}';
    }
}


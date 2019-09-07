package com.patient.model;

import javax.persistence.*;

@Entity
@Table(name = "Patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    Long id;

    @Column(name = "Fullname")
    String fullname;

    @Column(name = "NIC")
    String nic;

    @Column(name = "Age")
    String age;

    @Column(name = "Address")
    String address;

    @Column(name = "Mobile")
    String mobile;

    @Column(name = "Disease")
    String disease;

    @Column(name = "DocId")
    String docId;

    public Patient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getDocId() {
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", nic='" + nic + '\'' +
                ", age='" + age + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", disease='" + disease + '\'' +
                ", docId='" + docId + '\'' +
                '}';
    }
}

package com.example.authentication.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_it_request_form")
public class ItRequestForm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "req1", length = 100, nullable = false)
    private String req1;

    @Column(name = "req2", length = 100, nullable = false)
    private String req2;

    @Column(name = "req3", length = 100, nullable = false)
    private String req3;

    @Column(name = "req4", length = 100, nullable = false)
    private String req4;

    @Column(name = "req5", length = 100, nullable = false)
    private String req5;

    @Column(name = "req6", length = 100, nullable = false)
    private String req6;

    @Column(name = "req7", length = 100, nullable = false)
    private String req7;

    @Column(name = "window_logon", length = 300, nullable = false)
    private String windowLogon;

    @Column(name = "email", length = 50, nullable = false)
    private String email;

    @Column(name = "cassis_system", length = 50, nullable = false)
    private String cassisSystem;

    @Column(name = "tricube_system", length = 50, nullable = false)
    private String tricubeSystem;

    @Column(name = "pc", length = 50, nullable = false)
    private String pc;

    @Column(name = "printer", length = 50, nullable = false)
    private String printer;

    @Column(name = "website", length = 50, nullable = false)
    private String website;

    @Column(name = "other", length = 50, nullable = false)
    private String other;

    @Column(name = "req8", length = 500, nullable = false)
    private String req8;

    @Column(name = "register_date", length = 60, nullable = false)
    private String registerDate;

    @Column(name = "acceptance", length = 50, nullable = false)
    private String acceptance;

    @Column(name = "it_process1", length = 60, nullable = false)
    private String itProcess1;

    @Column(name = "it_process2", length = 60, nullable = false)
    private String itProcess2;

    @Column(name = "it_process3", length = 60, nullable = false)
    private String itProcess3;

    @Column(name = "it_process4", length = 60, nullable = false)
    private String itProcess4;

    @Column(name = "it_process5", length = 500, nullable = false)
    private String itProcess5;

    @Column(name = "it_process6", length = 60, nullable = false)
    private String itProcess6;

    @Column(name = "it_process7", length = 60, nullable = false)
    private String itProcess7;

    @Column(name = "it_process8", length = 60, nullable = false)
    private String itProcess8;

    @Column(name = "user_accept1", length = 50, nullable = false)
    private String userAccept1;

    @Column(name = "user_accept2", length = 50, nullable = false)
    private String userAccept2;

    @Column(name = "user_accept3", length = 50, nullable = false)
    private String userAccept3;

    @Column(name = "user_accept4", length = 50, nullable = false)
    private String userAccept4;

    // Default Constructor
    public ItRequestForm() {}

    // Parameterized Constructor
    public ItRequestForm(String req1, String req2, String req3, String req4, String req5, String req6, String req7,
                         String windowLogon, String email, String cassisSystem, String tricubeSystem, String pc,
                         String printer, String website, String other, String req8, String registerDate, String acceptance,
                         String itProcess1, String itProcess2, String itProcess3, String itProcess4, String itProcess5,
                         String itProcess6, String itProcess7, String itProcess8, String userAccept1, String userAccept2,
                         String userAccept3, String userAccept4) {
        this.req1 = req1;
        this.req2 = req2;
        this.req3 = req3;
        this.req4 = req4;
        this.req5 = req5;
        this.req6 = req6;
        this.req7 = req7;
        this.windowLogon = windowLogon;
        this.email = email;
        this.cassisSystem = cassisSystem;
        this.tricubeSystem = tricubeSystem;
        this.pc = pc;
        this.printer = printer;
        this.website = website;
        this.other = other;
        this.req8 = req8;
        this.registerDate = registerDate;
        this.acceptance = acceptance;
        this.itProcess1 = itProcess1;
        this.itProcess2 = itProcess2;
        this.itProcess3 = itProcess3;
        this.itProcess4 = itProcess4;
        this.itProcess5 = itProcess5;
        this.itProcess6 = itProcess6;
        this.itProcess7 = itProcess7;
        this.itProcess8 = itProcess8;
        this.userAccept1 = userAccept1;
        this.userAccept2 = userAccept2;
        this.userAccept3 = userAccept3;
        this.userAccept4 = userAccept4;
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getReq1() { return req1; }
    public void setReq1(String req1) { this.req1 = req1; }

    public String getReq2() { return req2; }
    public void setReq2(String req2) { this.req2 = req2; }

    public String getReq3() { return req3; }
    public void setReq3(String req3) { this.req3 = req3; }

    public String getReq4() { return req4; }
    public void setReq4(String req4) { this.req4 = req4; }

    public String getReq5() { return req5; }
    public void setReq5(String req5) { this.req5 = req5; }

    public String getReq6() { return req6; }
    public void setReq6(String req6) { this.req6 = req6; }

    public String getReq7() { return req7; }
    public void setReq7(String req7) { this.req7 = req7; }

    public String getWindowLogon() { return windowLogon; }
    public void setWindowLogon(String windowLogon) { this.windowLogon = windowLogon; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getCassisSystem() { return cassisSystem; }
    public void setCassisSystem(String cassisSystem) { this.cassisSystem = cassisSystem; }

    public String getTricubeSystem() { return tricubeSystem; }
    public void setTricubeSystem(String tricubeSystem) { this.tricubeSystem = tricubeSystem; }

    public String getPc() { return pc; }
    public void setPc(String pc) { this.pc = pc; }

    public String getPrinter() { return printer; }
    public void setPrinter(String printer) { this.printer = printer; }

    public String getWebsite() { return website; }
    public void setWebsite(String website) { this.website = website; }

    public String getOther() { return other; }
    public void setOther(String other) { this.other = other; }

    public String getReq8() { return req8; }
    public void setReq8(String req8) { this.req8 = req8; }

    public String getRegisterDate() { return registerDate; }
    public void setRegisterDate(String registerDate) { this.registerDate = registerDate; }

    public String getAcceptance() { return acceptance; }
    public void setAcceptance(String acceptance) { this.acceptance = acceptance; }

    public String getItProcess1() { return itProcess1; }
    public void setItProcess1(String itProcess1) { this.itProcess1 = itProcess1; }

    public String getItProcess2() { return itProcess2; }
    public void setItProcess2(String itProcess2) { this.itProcess2 = itProcess2; }

    public String getItProcess3() { return itProcess3; }
    public void setItProcess3(String itProcess3) { this.itProcess3 = itProcess3; }

    public String getItProcess4() { return itProcess4; }
    public void setItProcess4(String itProcess4) { this.itProcess4 = itProcess4; }

    public String getItProcess5() { return itProcess5; }
    public void setItProcess5(String itProcess5) { this.itProcess5 = itProcess5; }

    public String getItProcess6() { return itProcess6; }
    public void setItProcess6(String itProcess6) { this.itProcess6 = itProcess6; }

    public String getItProcess7() { return itProcess7; }
    public void setItProcess7(String itProcess7) { this.itProcess7 = itProcess7; }

    public String getItProcess8() { return itProcess8; }
    public void setItProcess8(String itProcess8) { this.itProcess8 = itProcess8; }

    public String getUserAccept1() { return userAccept1; }
    public void setUserAccept1(String userAccept1) { this.userAccept1 = userAccept1; }

    public String getUserAccept2() { return userAccept2; }
    public void setUserAccept2(String userAccept2) { this.userAccept2 = userAccept2; }

    public String getUserAccept3() { return userAccept3; }
    public void setUserAccept3(String userAccept3) { this.userAccept3 = userAccept3; }

    public String getUserAccept4() { return userAccept4; }
    public void setUserAccept4(String userAccept4) { this.userAccept4 = userAccept4; }
}
package dev.rikthipranadhik.storemanagementsystembackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Entity
@Table(name= "attendance")
@Getter
@Setter
public class Attendance {
    @Id
    @Column(name = "Hourly_Employee_ID", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "Hourly_Employee_ID", nullable = false)
    private HourlyEmployee hourlyEmployee;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.SET_NULL)
    @JoinColumn(name = "Manager_ID")
    private Manager manager;

    @ColumnDefault("0")
    @Column(name = "Is_Verified")
    private Boolean isVerified;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "Punch_In_Time")
    private Instant punchInTime;

    @Column(name = "Punch_Out_Time")
    private Instant punchOutTime;

    public Attendance() {
    }

    public Attendance(Integer id, HourlyEmployee hourlyEmployee, Manager manager, Boolean isVerified, Instant punchInTime, Instant punchOutTime) {
        this.id = id;
        this.hourlyEmployee = hourlyEmployee;
        this.manager = manager;
        this.isVerified = isVerified;
        this.punchInTime = punchInTime;
        this.punchOutTime = punchOutTime;
    }

}

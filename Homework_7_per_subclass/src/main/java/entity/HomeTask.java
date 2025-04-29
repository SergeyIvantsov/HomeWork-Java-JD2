package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Date;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@PrimaryKeyJoinColumn(name = "task_id")
public class HomeTask extends Task {

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Embedded
    private Address address;


}

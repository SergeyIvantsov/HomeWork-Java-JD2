package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuperBuilder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class WorkTask extends Task {

    @Column
    private Double cost;
}

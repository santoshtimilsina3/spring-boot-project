package com.example.springdatajpa.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@AttributeOverride(
        name="name",
        column=@Column(name="guardian_name")
)
@AttributeOverride(
        name="email",
        column=@Column(name="guardian_email")
)
@AttributeOverride(
        name="mobile",
        column=@Column(name="guardian_mobile")
)
public class Guardian {

    private String name;
    private String email;
    private String mobile;

}

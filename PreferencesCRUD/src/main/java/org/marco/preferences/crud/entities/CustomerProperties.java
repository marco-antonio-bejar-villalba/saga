package org.marco.preferences.crud.entities;


import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Document(collection = "CustomerProperties")
public class CustomerProperties {
	@Id
	String id;
	String name;
	String lastName;
	Date creationDate;
}
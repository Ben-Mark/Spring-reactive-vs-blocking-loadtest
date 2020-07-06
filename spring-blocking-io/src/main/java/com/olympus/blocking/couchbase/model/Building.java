package com.olympus.blocking.couchbase.model;


import com.couchbase.client.java.repository.annotation.Field;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Building {

    @NotNull
    @Id
    private String id;

    @NotNull
    @Field
    private String name;

    @NotNull
    @Field
    private String companyId;

    @Builder.Default
    @Field
    private List<Area> areas = new ArrayList<>();

    @Builder.Default
    @Field
    private List<String> phoneNumbers = new ArrayList<>();

}
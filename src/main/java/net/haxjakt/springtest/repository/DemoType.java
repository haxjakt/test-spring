package net.haxjakt.springtest.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "demo")
@AllArgsConstructor
public class DemoType {
    @Id
    private String id;

    private Integer count;
}

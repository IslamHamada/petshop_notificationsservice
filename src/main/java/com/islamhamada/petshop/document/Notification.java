package com.islamhamada.petshop.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.UUID;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@CompoundIndexes({
        @CompoundIndex(name = "user_time_idx", def = "{'userId': 1, 'createdAt': -1}")
})
public class Notification {
    @Id
    private UUID id;
    private long userId;
    private Instant createdAt;
    private String message;
    private boolean read;
}

package com.sombrainc.ffmpeg.model;

import lombok.*;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    public Status status;
    public String filePath;
    public String message;

    public enum Status {
        SUCCESS("Operation %s was completed successfully"), FAILED("Operation %s was failed with status: %s");

        private String message;

        Status(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}

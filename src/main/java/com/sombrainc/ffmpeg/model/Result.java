package com.sombrainc.ffmpeg.model;

import com.sombrainc.ffmpeg.enumeration.Status;
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
}

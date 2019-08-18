package com.sombrainc.ffmpeg.service;

import com.sombrainc.ffmpeg.enumeration.OperationType;
import com.sombrainc.ffmpeg.enumeration.Status;
import com.sombrainc.ffmpeg.model.Result;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFprobe;

public abstract class FFMpegAbstract implements FFMpegService {
  protected final FFmpeg ffmpeg;
  protected final FFprobe ffprobe;

  public static final String DEFAULT_FILE_PATH_MP_3 = "defaultFilePath.mp3";
  public static final String DEFAULT_FILE_PATH_PNG = "defaultFilePath.png";

  public FFMpegAbstract(FFmpeg ffmpeg, FFprobe ffprobe) {
    this.ffmpeg = ffmpeg;
    this.ffprobe = ffprobe;
  }

  /**
   * Generate result based on job status.
   * If it is FINISHED, status is SUCCESS, else it is FAILED
   */
  public Result generateResult(String resultFilePath, OperationType operationType, boolean success, Object returnStatus) {
    return success
            ?
            Result.builder().filePath(resultFilePath).status(Status.SUCCESS)
                    .message(String.format(Status.SUCCESS.getMessage(), operationType)).build()
            :
            Result.builder().filePath(resultFilePath).status(Status.FAILED)
                    .message(String.format(Status.FAILED.getMessage(), operationType, returnStatus)).build();
  }
}

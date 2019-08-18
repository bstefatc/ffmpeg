package com.sombrainc.ffmpeg.service;

import com.sombrainc.ffmpeg.model.Result;

import java.io.IOException;

public interface FFMpegService {
  /**
   * Make video shot from video file at specified time
   * @param filePath - path to the input file
   * @param time - time of the video for shot. Time pattern is HH:mm:ss.SSS
   * @return Result with success or failed status with message
   */
  Result makeVideoShot(String filePath, String time) throws IOException;

  /**
   * Make video shot from video file at specified time
   * @param filePath - path to the input file
   * @param time - time of the video for shot. Time pattern is HH:mm:ss.SSS
   * @param resultFilePath - path of the result file
   * @return Result with success or failed status with message
   */
  Result makeVideoShot(String filePath, String resultFilePath, String time) throws IOException;

  /**
   * Make audio file from video file
   * @param filePath - path to the input file
   * @return Result with success or failed status with message
   */
  Result makeAudioFromVideo(String filePath) throws IOException;

  /**
   * Make audio file from video file
   * @param filePath - path to the input file
   * @param resultFilePath - path of the result file
   * @return Result with success or failed status with message
   */
  Result makeAudioFromVideo(String filePath, String resultFilePath) throws IOException;
}

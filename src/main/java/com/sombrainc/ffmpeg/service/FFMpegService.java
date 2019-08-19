package com.sombrainc.ffmpeg.service;

import com.sombrainc.ffmpeg.model.Result;

import java.io.IOException;

public interface FFMpegService {

    String FFMPEG_PATH = "/usr/bin/ffmpeg";
    String FFPROBE_PATH = "/usr/bin/ffprobe";

    String DEFAULT_FILE_PATH_MP_3 = "defaultFilePath.mp3";
    String DEFAULT_FILE_PATH_PNG = "defaultFilePath.png";

    String AUDIO_RECORD = "AUDIO_RECORD";
    String IMAGE_SHOT = "IMAGE_SHOT";


    /**
     * Make video shot from video file at specified time
     *
     * @param filePath - path to the input file
     * @param time     - time of the video for shot. Time pattern is HH:mm:ss.SSS
     * @return Result with success or failed status with message
     */
    Result makeVideoShot(String filePath, String time) throws IOException;

    /**
     * Make video shot from video file at specified time
     *
     * @param filePath       - path to the input file
     * @param time           - time of the video for shot. Time pattern is HH:mm:ss.SSS
     * @param resultFilePath - path of the result file
     * @return Result with success or failed status with message
     */
    Result makeVideoShot(String filePath, String resultFilePath, String time) throws IOException;

    /**
     * Make audio file from video file
     *
     * @param filePath - path to the input file
     * @return Result with success or failed status with message
     */
    Result makeAudioFromVideo(String filePath) throws IOException;

    /**
     * Make audio file from video file
     *
     * @param filePath       - path to the input file
     * @param resultFilePath - path of the result file
     * @return Result with success or failed status with message
     */
    Result makeAudioFromVideo(String filePath, String resultFilePath) throws IOException;

    /**
     * Generate result based on job status.
     * If it is FINISHED, status is SUCCESS, else it is FAILED
     */
    default Result generateResult(String resultFilePath, String operationType, boolean success, Object returnStatus) {
        return success
                ?
                Result.builder().filePath(resultFilePath).status(Result.Status.SUCCESS)
                        .message(String.format(Result.Status.SUCCESS.getMessage(), operationType)).build()
                :
                Result.builder().filePath(resultFilePath).status(Result.Status.FAILED)
                        .message(String.format(Result.Status.FAILED.getMessage(), operationType, returnStatus)).build();
    }
}

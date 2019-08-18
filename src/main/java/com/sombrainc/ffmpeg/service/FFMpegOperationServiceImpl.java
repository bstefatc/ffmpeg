package com.sombrainc.ffmpeg.service;

import com.sombrainc.ffmpeg.enumeration.OperationType;
import com.sombrainc.ffmpeg.model.Result;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFprobe;

import java.io.IOException;
import java.util.logging.Logger;

public class FFMpegOperationServiceImpl extends FFMpegAbstract {

    Logger log = Logger.getLogger(FFMpegOperationServiceImpl.class.getName());

    public FFMpegOperationServiceImpl(FFmpeg ffmpeg, FFprobe ffprobe) {
        super(ffmpeg, ffprobe);
    }

    @Override
    public Result makeVideoShot(String filePath, String time) throws IOException {
        return makeVideoShot(filePath, DEFAULT_FILE_PATH_PNG, time);
    }

    @Override
    public Result makeVideoShot(String filePath, String resultFilePath, String time) throws IOException {
        log.info(String.format("Make videoshot for file %s with result file %s at %s",
                filePath, resultFilePath, time));
        Process p = Runtime.getRuntime().exec(
                String.format("ffmpeg -y -i %s -ss %s -vframes 1 %s", filePath, time, resultFilePath));
        try {
            p.waitFor();
        } catch (InterruptedException e) {
            return generateResult(resultFilePath, OperationType.IMAGE_SHOT, false, "Interrupted error");
        }
        Result result = generateResult(resultFilePath, OperationType.IMAGE_SHOT, p.exitValue() == 0, p.exitValue());
        p.destroy();
        log.info(result.toString());
        return result;
    }

    @Override
    public Result makeAudioFromVideo(String filePath) throws IOException {
        return makeAudioFromVideo(filePath, DEFAULT_FILE_PATH_MP_3);
    }

    @Override
    public Result makeAudioFromVideo(String filePath, String resultFilePath) throws IOException {
        log.info(String.format("Make audio record from video file %s with result file %s",
                filePath, resultFilePath));
        Process p = Runtime.getRuntime().exec(String.format("ffmpeg -y -i %s -vn -acodec mp3 %s", filePath, resultFilePath));
        try {
            p.waitFor();
        } catch (InterruptedException e) {
            return generateResult(resultFilePath, OperationType.AUDIO_RECORD, false, "Interrupted error");
        }
        Result result = generateResult(resultFilePath, OperationType.AUDIO_RECORD, p.exitValue() == 0, p.exitValue());
        p.destroy();
        log.info(result.toString());
        return result;
    }
}
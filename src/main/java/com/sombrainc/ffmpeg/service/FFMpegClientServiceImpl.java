package com.sombrainc.ffmpeg.service;

import com.sombrainc.ffmpeg.enumeration.OperationType;
import com.sombrainc.ffmpeg.model.Result;
import com.sombrainc.ffmpeg.util.Util;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.job.FFmpegJob;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class FFMpegClientServiceImpl extends FFMpegAbstract {

    Logger log = Logger.getLogger(FFMpegClientServiceImpl.class.getName());


    public FFMpegClientServiceImpl(FFmpeg ffmpeg, FFprobe ffprobe) {
        super(ffmpeg, ffprobe);
    }

    @Override
    public Result makeVideoShot(String filePath, String time){
        return makeVideoShot(filePath, DEFAULT_FILE_PATH_PNG, time);
    }

    @Override
    public Result makeVideoShot(String filePath, String resultFilePath, String time){
        long millis = Util.millisFromTime(time);
        log.info(String.format("Make videoshot for file %s with result file %s at %s",
                filePath, resultFilePath, time));
        log.info(String.format("Time of a videoshot in milliseconds %s", millis));
        FFmpegBuilder builder = new FFmpegBuilder()
                .setInput(filePath)        // Filename, or a FFmpegProbeResult
                .overrideOutputFiles(true) // Override the output if it exists
                .addOutput(resultFilePath) // Filename for the destination
                .setFrames(1)
                .setStartOffset(millis, TimeUnit.MILLISECONDS)
                .done();
        return execute(builder, resultFilePath, OperationType.IMAGE_SHOT);
    }

    @Override
    public Result makeAudioFromVideo(String filePath){
        return makeAudioFromVideo(filePath, DEFAULT_FILE_PATH_MP_3);
    }

    @Override
    public Result makeAudioFromVideo(String filePath, String resultFilePath){
        log.info(String.format("Make audio record from video file %s with result file %s",
                filePath, resultFilePath));
        FFmpegBuilder builder = new FFmpegBuilder()
                .setInput(filePath)          // Filename, or a FFmpegProbeResult
                .overrideOutputFiles(true)   // Override the output if it exists
                .addOutput(resultFilePath)   // Filename for the destination
                .done();
        return execute(builder, resultFilePath, OperationType.AUDIO_RECORD);
    }

    private Result execute(FFmpegBuilder builder, String resultFilePath, OperationType operationType){
        FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);
        FFmpegJob fFmpegJob = executor.createJob(builder);
        fFmpegJob.run();
        return generateResult(resultFilePath, operationType, FFmpegJob.State.FINISHED.equals(fFmpegJob.getState()), fFmpegJob);
    }
}

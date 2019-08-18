package com.sombrainc.ffmpeg.client;

import com.sombrainc.ffmpeg.enumeration.FFMpegServiceType;
import com.sombrainc.ffmpeg.model.Result;
import com.sombrainc.ffmpeg.service.FFMpegClientServiceImpl;
import com.sombrainc.ffmpeg.service.FFMpegService;
import com.sombrainc.ffmpeg.service.FFMpegServiceFactory;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFprobe;

import java.io.IOException;

public class FFMpegClient implements FFMpegService {
  public static final String FFMPEG_PATH = "/usr/bin/ffmpeg";
  public static final String FFPROBE_PATH = "/usr/bin/ffprobe";
  private final FFmpeg ffmpeg;
  private final FFprobe ffprobe;
  private FFMpegService ffMpegService;

  public FFMpegClient() throws IOException {
    ffmpeg = new FFmpeg(FFMPEG_PATH);
    ffprobe = new FFprobe(FFPROBE_PATH);
    ffMpegService = new FFMpegClientServiceImpl(ffmpeg, ffprobe);
  }

  public FFMpegClient(FFMpegServiceType ffMpegServiceType) throws IOException {
    ffmpeg = new FFmpeg(FFMPEG_PATH);
    ffprobe = new FFprobe(FFPROBE_PATH);
    this.ffMpegService = FFMpegServiceFactory.getFFMpegService(ffMpegServiceType, ffmpeg, ffprobe);
  }

  public FFMpegClient(String ffmpegPath, String ffprobePath, FFMpegServiceType ffMpegServiceType) throws IOException {
    this.ffmpeg = new FFmpeg(ffmpegPath);
    this.ffprobe =  new FFprobe(ffprobePath);
    this.ffMpegService = FFMpegServiceFactory.getFFMpegService(ffMpegServiceType, ffmpeg, ffprobe);
  }

  @Override
  public Result makeVideoShot(String filePath, String time) throws IOException {
    return ffMpegService.makeVideoShot(filePath, time);
  }

  @Override
  public Result makeVideoShot(String filePath, String resultFilePath, String time) throws IOException {
    return ffMpegService.makeVideoShot(filePath, resultFilePath, time);
  }

  @Override
  public Result makeAudioFromVideo(String filePath) throws IOException {
    return ffMpegService.makeAudioFromVideo(filePath);
  }

  @Override
  public Result makeAudioFromVideo(String filePath, String resultFilePath) throws IOException {
    return ffMpegService.makeAudioFromVideo(filePath, resultFilePath);
  }
}

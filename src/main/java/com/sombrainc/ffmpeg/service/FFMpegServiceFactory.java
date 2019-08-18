package com.sombrainc.ffmpeg.service;

import com.sombrainc.ffmpeg.enumeration.FFMpegServiceType;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFprobe;

public class FFMpegServiceFactory{
  public static FFMpegService getFFMpegService(FFMpegServiceType ffMpegServiceType, FFmpeg ffmpeg, FFprobe ffprobe) {
    switch (ffMpegServiceType) {
      case FROM_CLIENT:
        return new FFMpegClientServiceImpl(ffmpeg, ffprobe);
      case OPERATION:
        return new FFMpegOperationServiceImpl(ffmpeg, ffprobe);
      default:
        return new FFMpegClientServiceImpl(ffmpeg, ffprobe);

    }
  }
}

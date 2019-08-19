package com.sombrainc.ffmpeg.service;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFprobe;

import java.io.IOException;

public abstract class FFMpegAbstract implements FFMpegService {
    protected final FFmpeg ffmpeg;
    protected final FFprobe ffprobe;

    public FFMpegAbstract() throws IOException {
        this.ffmpeg = new FFmpeg(FFMPEG_PATH);
        this.ffprobe = new FFprobe(FFPROBE_PATH);
    }
}

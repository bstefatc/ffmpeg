package com.sombrainc.ffmpeg;

import com.sombrainc.ffmpeg.service.FFMpegClientServiceImpl;
import com.sombrainc.ffmpeg.service.FFMpegOperationServiceImpl;
import com.sombrainc.ffmpeg.service.FFMpegService;

import java.io.IOException;

public class Example {
    public static void main(String... args) throws IOException {
        FFMpegService ffMpegClientService = new FFMpegClientServiceImpl();
        ffMpegClientService.makeVideoShot("resources/video.mp4", "resources/client_image.png", "00:00:01.100");
        ffMpegClientService.makeAudioFromVideo("resources/video.mp4", "resources/client_audio.mp3");

        FFMpegService ffMpegOperationService = new FFMpegOperationServiceImpl();
        ffMpegOperationService.makeVideoShot("resources/video.mp4", "resources/operation_image.png", "00:00:01.100");
        ffMpegOperationService.makeAudioFromVideo("resources/video.mp4", "resources/operation_audio.mp3");
    }
}

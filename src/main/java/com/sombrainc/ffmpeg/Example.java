package com.sombrainc.ffmpeg;

import com.sombrainc.ffmpeg.client.FFMpegClient;
import com.sombrainc.ffmpeg.enumeration.FFMpegServiceType;

import java.io.IOException;

public class Example {
    public static void main(String... args) throws IOException {
        FFMpegClient ffMpegClient = new FFMpegClient();
        ffMpegClient.makeVideoShot("resources/video.mp4", "resources/client_image.png", "00:00:01.100");
        ffMpegClient.makeAudioFromVideo("resources/video.mp4", "resources/client_audio.mp3");

        FFMpegClient operationClient = new FFMpegClient(FFMpegServiceType.OPERATION);
        operationClient.makeVideoShot("resources/video.mp4", "resources/operation_image.png", "00:00:01.100");
        operationClient.makeAudioFromVideo("resources/video.mp4", "resources/operation_audio.mp3");
    }
}

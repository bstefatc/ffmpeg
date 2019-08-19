##FFMpeg custom implementation

###Usage:
 ***
    FFMpegService ffMpegClientService = new FFMpegClientServiceImpl();
    ffMpegClientService.makeVideoShot("resources/video.mp4", "resources/client_image.png", "00:00:01.100");
    ffMpegClientService.makeAudioFromVideo("resources/video.mp4", "resources/client_audio.mp3");

    FFMpegService ffMpegOperationService = new FFMpegOperationServiceImpl();
    ffMpegOperationService.makeVideoShot("resources/video.mp4", "resources/operation_image.png", "00:00:01.100");
    ffMpegOperationService.makeAudioFromVideo("resources/video.mp4", "resources/operation_audio.mp3");


We support 2 different types of usage of this FFMpeg service. You can use already created client wrapper using client implementation:
    
    FFMpegService ffMpegClientService = new FFMpegClientServiceImpl();

or native Linux commands behaviour using operation implementation

    FFMpegService ffMpegOperationService = new FFMpegOperationServiceImpl();

There are provided 2 methods to make a video shot

    ffMpegService.makeVideoShot(filePath, time);
    ffMpegService.makeVideoShot(filePath, resultFilePath, time)
    
And 2 methods to read audio voice from the video

    ffMpegService.makeAudioFromVideo(filePath);
    makeAudioFromVideo(filePath, resultFilePath)
 
 Please note that in both cases this service references 'ffmpeg' application that is locally installed on Linux (or other OS) so this usage doesn't seem to violate GPL licensing, because it doesn't need ffmpeg to be packaged inside jar.

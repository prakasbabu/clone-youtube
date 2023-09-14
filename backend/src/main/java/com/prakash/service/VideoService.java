package com.prakash.service;

import com.prakash.entity.Video;
import com.prakash.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class VideoService {
    private final S3Service s3service;
    private final VideoRepository videoRepository;
    public void uploadVideo( MultipartFile file){
       String videoUrl = s3service.uploadFile(file);
        Video video = new Video();
        video.setVideoUrl(videoUrl);
        videoRepository.save(video);

    }
}

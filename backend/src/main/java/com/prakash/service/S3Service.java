package com.prakash.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Service implements FileService {

    public static final String BUCKET_NAME = "ambesfirsts3bucket";
    private final AmazonS3Client amazonS3Client;

    @Override
    public String uploadFile(MultipartFile file) {

        //prepare a key - a unique key for a file
         String fileNameExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());
         String key = UUID.randomUUID().toString() +"."+fileNameExtension;
         var metaData = new ObjectMetadata();// a class from amazon s3 module
         metaData.setContentLength(file.getSize());// file size
         metaData.setContentType(file.getContentType());//content type

          //upload file to aws s3 bucket

          try {
              amazonS3Client.putObject(BUCKET_NAME, key, file.getInputStream(),metaData);
          } catch (IOException e) {
              throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An internal error occurred while uploading the video");
          }
            //access control, to make video upload from angular
          amazonS3Client.setObjectAcl(BUCKET_NAME, key, CannedAccessControlList.PublicRead );

          // get the video url from s3 bucket
          return amazonS3Client.getResourceUrl(BUCKET_NAME, key);
    }
}

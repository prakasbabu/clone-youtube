import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class VideoService {

  constructor(httpClient:HttpClient) { }

  uploadVideo(fileEntry: FileSystemFileEntry){

    const formData = new FormData()
    formData.append('logo', file, relativePath)
    this.httpClient.post("http://localhost:9090/api/videos/upload")
    return;
  }
}

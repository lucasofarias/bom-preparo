import { Injectable } from "@angular/core";
import { ImageRepository } from "src/app/data/repositories/image.repository";
import { Image } from "../models";
import { Observable, map } from "rxjs";

@Injectable({ providedIn: 'root' })
export class ImageService {

  constructor(private imageRepository: ImageRepository) { }

  viewImage(imageId: number): Observable<any> {
    return this.imageRepository.viewImage(imageId).pipe(
      map((data) => {
        return data;
      })
    );
  }

}

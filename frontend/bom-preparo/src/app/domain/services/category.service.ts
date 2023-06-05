import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { CategoryRepository } from 'src/app/data/repositories/category.repository';
import { CategoryDTO } from '../models/dtos/category.dto';

@Injectable({ providedIn: 'root' })
export class CategoryService {

  constructor(private categoryRepository: CategoryRepository) { }

  listCategories(): Observable<CategoryDTO[]> {
    return this.categoryRepository.listCategories().pipe(
      map((data) => {
        return data;
      })
    );
  }

}

import { User, Category, Ingredient, Image } from "../models";

export class Recipe {

  id: number = 0;
  name: string = "";
  description: string = "";
  preparation: string = "";

  isPrivate: boolean = false;

  categories: Category[] = [];
  ingredients: Ingredient[] = [];

  image: Image = new Image();

  difficulty: string = "";

  creatorUser: User = new User();

}

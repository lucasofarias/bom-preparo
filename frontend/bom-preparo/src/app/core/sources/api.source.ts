export default {
  auth: {
    login: "/login"
  },
  user: {
    signUp: "/user/sign-up",
    deleteAccount: "/user/delete-account",
    updateAccount: "/user/update-account",
    getUser: "/user/get-user",
  },
  recipe: {
    createRecipe: "/recipe/create-recipe",
    deleteRecipe: "/recipe/delete-recipe",
    getRecipe: "/recipe/get-recipe",
    listRecipes: "/recipe/list-recipes",
    listRecipesByCategories: "/recipe/list-recipes-by-categories",
    listRecipesByIngredients: "/recipe/list-recipes-by-ingredients",
    listRecipesByUser: "/recipe/list-recipes-by-user",
    updateRecipe: "/recipe/update-recipe"
  },
  ingredient: {
    createIngredient: "/ingredient/create-ingredient",
    addIngredientFromPantry: "/ingredient/add-ingredient-to-pantry",
    removeIngredientFromPantry: "/ingredient/remove-ingredient-from-pantry",
    getIngredient: "/ingredient/get-ingredient",
    listIngredients: "/ingredient/list-ingredients",
    listIngredientsByCurrentUser: "/ingredient/list-ingredients-by-current-user",
  }
}

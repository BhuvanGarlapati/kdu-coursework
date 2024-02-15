export {}
interface Recipe {
    id: number;
    name: string;
    image: string;
    rating: number;
    cuisine: string;
    ingredients: string[];
    difficulty: string;
    timeTaken: number;
    caloriesPerServing: number;
  }

  interface FullResponse {
    recipes: {
      id: number;
      name: string;
      image: string;
      rating: number;
      cuisine: string;
      ingredients: string[];
      difficulty: string;
      prepTimeMinutes: number;
      cookTimeMinutes: number;
      caloriesPerServing: number;
      tags: string[];
      userId: number;
      reviewCount: number;
      mealType: string[];
    }[];
  }


async function fetchRecipesFromAPI(): Promise<Recipe[]> {
    try {
      const response = await fetch("https://dummyjson.com/recipes");
      const fullResponse: FullResponse = await response.json();
      const simplifiedRecipes: Recipe[] = fullResponse.recipes.map((recipe) => ({
        id: recipe.id,
        name: recipe.name,
        image: recipe.image,
        rating: recipe.rating,
        cuisine: recipe.cuisine,
        ingredients: recipe.ingredients,
        difficulty: recipe.difficulty,
        timeTaken: recipe.prepTimeMinutes + recipe.cookTimeMinutes,
        caloriesPerServing: recipe.caloriesPerServing,
      }));
  
      return simplifiedRecipes;
  }catch (error) {
    console.error('Error fetching recipes:', error);
    return [];
  }
}
async function printAllRecipes(): Promise<void> {
    const recipes = await fetchRecipesFromAPI();
    console.log(recipes);
  
}

// printAllRecipes();
const API_URL = 'https://dummyjson.com/recipes';

async function fetchRecipes(query?: string): Promise<Recipe[]> {
  try {
    const searchUrl = query ? `${API_URL}/search?q=${encodeURIComponent(query)}` : API_URL;
    const response = await fetch(searchUrl);

    if (!response.ok) {
      throw new Error(`HTTP error! Status: ${response.status}`);
    }

    const data = await response.json();
    return data.recipes; // Assuming the recipes are under the 'recipes' property
  } catch (error) {
    console.error('Error fetching recipes:', error);
    return [];
  }
}

// Example usage
async function searchRecipes(query: string): Promise<void> {
  try {
    const result = await fetchRecipes(query);
    console.log('Raw JSON data for recipes matching the search query:', result);
  } catch (error) {
    console.error('Error searching recipes:', error);
  }
}
searchRecipes("pizza");

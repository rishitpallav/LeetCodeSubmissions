class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        List<String> result = new ArrayList<>();

        Map<String, Boolean> canMake = new HashMap<>();
        Map<String, Integer> recipeIndex = new HashMap<>();

        for (String s : supplies) {
            canMake.put(s, true);
        }

        for (int i = 0; i < recipes.length; i++ ) {
            recipeIndex.put(recipes[i], i);
        }

        for (String recipe : recipes) {
            if (checkRecipe(recipe, ingredients, canMake, new HashSet<String>(), recipeIndex)) {
                result.add(recipe);
            }
        }

        return result;
    }

    boolean checkRecipe(String recipe, List<List<String>> ingredients, Map<String, Boolean> canMake, Set<String> visited, Map<String, Integer> recipeIndex) {
        if (canMake.containsKey(recipe)) {
            return canMake.get(recipe);
        }

        if (visited.contains(recipe) || !recipeIndex.containsKey(recipe)) return false;

        visited.add(recipe);

        for (String i : ingredients.get(recipeIndex.get(recipe))) {
            if (!checkRecipe(i, ingredients, canMake, visited, recipeIndex)) {
                canMake.put(recipe, false);
                return false;
            }
        }

        canMake.put(recipe, true);
        return true;
    }
}
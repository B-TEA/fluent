package recipe;

import recipe.enums.Heat;
import recipe.enums.TimeUnit;
import recipe.enums.Unit;

import java.util.ArrayList;
import java.util.HashMap;


public class RecipeBuilder {

    private static final double DEFAULT_PREP_TIME_MINUTES = 0.25;

    private String recipeName;
    private int personCount;

    private double cookTime = 0;
    private double preparationTime = 0;

    private final HashMap<Integer, String> tools;
    private final ArrayList<String> instructions;
    private final ArrayList<String> ingredients;

    private int step = 0;


    RecipeBuilder (String recipeName, int personCount) {
        this.recipeName  = recipeName;
        this.personCount = personCount;

        this.instructions = new ArrayList<>();
        this.ingredients = new ArrayList<>();
        this.tools = new HashMap<>();
    }

    void newline () {
        this.instructions.add("\n");
    }

    void newStep () {
        newline();
        newline();
        this.step += 1;
        this.instructions.add("Step. " + step);
        newline();
    }

    void newInstruction (String s) {
        this.instructions.add(s);
    }

    void newIngredient (String s) {
        this.ingredients.add(s);
    }

    void addCookingTime (double minutes) {
        this.cookTime += minutes;
    }

    void addPrepTime (double minutes) {
        this.preparationTime += minutes;
    }

    RecipeBuilder takeTool (String toolName, int id) {
        this.tools.put(id, toolName);

        newStep();
        newInstruction("Get a " +  toolName + ".");
        addPrepTime(DEFAULT_PREP_TIME_MINUTES);
        return this;
    }

    RecipeBuilder startAddingStuff() {
        newline();
        newInstruction("Now add ");
        return this;
    }

    RecipeBuilder stopAddingStuff() {

        int lastPosition = this.instructions.size()-1;
        String newInstruction = this.instructions.get(lastPosition).replace(", ", ".");
        this.instructions.remove(lastPosition);

        newInstruction(newInstruction);

        return this;
    }

    RecipeBuilder apply (String ingredient, double  count) {
        newInstruction(count + " " + ingredient + ", ");
        newIngredient(count + " " + ingredient);
        addPrepTime(DEFAULT_PREP_TIME_MINUTES);
        return this;
    }

    RecipeBuilder apply (String ingredient, double count, Unit unit) {
        newInstruction(count + " " + unit.toVal(count) + " of " + ingredient + ", ");
        newIngredient(count + " " + unit.toVal(count) + " of " + ingredient);
        addPrepTime(DEFAULT_PREP_TIME_MINUTES);
        return this;
    }

    RecipeBuilder cookFor (int time, TimeUnit timeUnit, Heat heat) {
        addCookingTime(time);
        newline();
        newInstruction("Cook everything on " + heat.toVal() + " for " + time + " " + timeUnit.toVal(time) + ".");
        return this;
    }

    RecipeBuilder blendUntil (int time, TimeUnit timeUnit, String condition) {
        newline();
        newInstruction("Now blend for " + time + " " + timeUnit.toVal(time) + " until " + condition + ".");

        addPrepTime(time);
        return this;
    }

    RecipeBuilder transfer(int toolID1, int toolID2) {
        newline();
        newInstruction("Transfer the Contents of the " + tools.get(toolID1) + " into the " + tools.get(toolID2) + ".");
        return this;
    }

    String etVoila() {

        StringBuilder recipe = new StringBuilder();

        recipe.append("Recipe: " + this.recipeName + "\n");
        recipe.append("For " + this.personCount + " persons.\n\n");

        recipe.append("cooking time: " + this.cookTime + " minutes\n");
        recipe.append("preparation time: " + this.preparationTime + " minutes\n");
        recipe.append("total time: " + (this.cookTime + this.preparationTime) + "minutes\n");
        recipe.append("\n\n");

        recipe.append("--- Ingredients ---");
        recipe.append("\n\n");

        for (String ingredient: ingredients) {
            recipe.append(ingredient);
            recipe.append("\n");
        }

        recipe.append("\n\n");
        recipe.append("--- Instructions ---");


        for (String instruction: instructions) {
            recipe.append(instruction);
        }

        recipe.append("\n\n");
        recipe.append("Enjoy!");


        return recipe.toString();
    }


}

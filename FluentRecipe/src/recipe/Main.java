package recipe;

import recipe.enums.Heat;
import recipe.enums.TimeUnit;
import recipe.enums.Unit;


public class Main {

    public static void main(String[] args) {

        String recipe = new RecipeBuilder("Mushroom Soup", 4)
                .takeTool ("Large Pot", 1)
                .startAddingStuff()
                .apply("oil", 2, Unit.TABLESPOON)
                .apply("medium leeks", 2)
                .apply("celery stalks", 2)
                .apply("salt", 0.25, Unit.TABLESPOON)
                .stopAddingStuff()
                .cookFor(5, TimeUnit.MINUTE, Heat.MEDIUM)
                .startAddingStuff()
                .apply("mushrooms", 16, Unit.OUNCE)
                .stopAddingStuff()
                .cookFor(9, TimeUnit.MINUTE, Heat.MEDIUM)
                .startAddingStuff()
                .apply("tamari", 2, Unit.TABLESPOON)
                .apply("wine", 0.25, Unit.CUP)
                .apply("garlic cloves", 2)
                .apply("fresh thyme leaves", 2, Unit.TABLESPOON)
                .stopAddingStuff()
                .cookFor(5, TimeUnit.MINUTE, Heat.HIGH)
                .startAddingStuff()
                .apply("broth", 4, Unit.CUP)
                .apply("cauliflower", 1, Unit.POUND)
                .stopAddingStuff()
                .cookFor(20, TimeUnit.MINUTE, Heat.LOW)
                .takeTool ("Blender", 2)
                .transfer (1,2)
                .startAddingStuff()
                .apply("dijon mustard", 1, Unit.TEASPOON)
                .apply("balsamic vinegar", 1, Unit.TEASPOON)
                .stopAddingStuff()
                .blendUntil(3, TimeUnit.MINUTE, "everything is smooth")
                .takeTool("Soup Plate", 3)
                .transfer (2,3)
                .etVoila();

        System.out.println(recipe);

    }
}

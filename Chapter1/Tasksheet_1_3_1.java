package Chapter1;


class Recipe {
    String[] ingredients;

    void showIngredients() {
        System.out.print("Ingredients: ");
        for (String i : ingredients) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

class Afritada extends Recipe {
    Afritada() {
        ingredients = new String[] {
            "Tomato Sauce", "Meat", "Potatoes & Carrots", "Tomato Paste"
        };
    }
}

class Mechado extends Recipe {
    Mechado() {
        ingredients = new String[] {
            "Tomato Sauce", "Meat", "Potatoes & Carrots", "Liver Spread"
        };
    }
}

class Menudo extends Recipe {
    Menudo() {
        ingredients = new String[] {
            "Tomato Sauce", "Meat", "Potatoes & Carrots", "Raisins", "Hotdog"
        };
    }
}

class Caldereta extends Recipe {
    Caldereta() {
        ingredients = new String[] {
            "Tomato Sauce", "Meat", "Potatoes & Carrots", "Tomato Paste", "Cheese"
        };
    }
}

public class Tasksheet_1_3_1 {
    public static void main(String[] args) {
        Recipe meal1 = new Afritada();
        Recipe meal2 = new Mechado();
        Recipe meal3 = new Menudo();
        Recipe meal4 = new Caldereta();

        meal1.showIngredients();
        meal2.showIngredients();
        meal3.showIngredients();
        meal4.showIngredients();
    }
}

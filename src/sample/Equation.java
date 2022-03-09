package sample;

import java.util.ArrayList;

public class Equation {

    // Equation divided by modules
    // Ex: [3, +, 4.5, *, 6, -]
    private ArrayList<Module> equation;

    // Indices of only operation symbols in "ArrayList<Module> equation"
    // Ex: [1, 3, 5]
    private ArrayList<Integer> operationIndices;

    public Equation()
    {
        equation = new ArrayList<>();
        operationIndices = new ArrayList<>();
    }

    /*
        function: add
        purpose : add a new number or an operation to the equation
     */
    public void add(Module m)
    {
        equation.add(m);

        // if it is an operation, add it to the "special" list -> operationIndices
        if(!m.isNumber())
            operationIndices.add(equation.size()-1);
    }

    /*
        function: find
        purpose : find the LEFT-MOST index of a certain operation in (ArrayList<Module> equation)
     */
    public int find(String operation) {

        for (int m : operationIndices )
        {
            if(operation.contentEquals(equation.get(m).toString()))
            {
                return m;
            }
        }
        return -1;
    }

    @Override
    public String toString()
    {
        return equation.toString();
    }


    /*
        function: solve
        purpose : Solve the equation
     */
    public void solve() {

        // To Multiply

        int x = this.find("x");
        int x_index = operationIndices.indexOf(Integer.valueOf(x));

        while(x !=-1)
        {
            double product = equation.get(x-1).toNumber() * equation.get(x+1).toNumber();

            equation.set(x, new Module(String.valueOf(product), true));
            equation.remove(x+1);
            equation.remove(x-1);

            for(int i = operationIndices.indexOf(Integer.valueOf(x))+1; i < operationIndices.size(); i++)
            {
                operationIndices.set(i, Integer.valueOf(operationIndices.get(i)-2));
            }

            operationIndices.remove(x_index);


            x = this.find("x");
        }

        // To Divide

        // 3 + 1.5 * 9 + 1
        // - -  -  - - - -
        // 0 1  2  3 4 5 6

        //[1,3,5]

        // 3 + 13.5 + 1
        // - -  -   - -
        // 0 1  2   3 4

        //[1,3,3]

        // Multiply the equation[x-1] and equation[x+1]
        // Replace the product with equation[x-1] and remove equation[x] and remove equation[x]
        // Remove operation from the found index
    }

    public String result()
    {
        return equation.get(0).toString();
    }

    public void clear()
    {
        equation.clear();
        operationIndices.clear();
    }

}

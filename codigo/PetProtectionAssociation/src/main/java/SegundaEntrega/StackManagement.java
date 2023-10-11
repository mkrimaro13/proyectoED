package SegundaEntrega;

import javax.swing.JOptionPane;

import PrimeraEntrega.Vaccine;

public class StackManagement {
    public Stack enterData(Stack stack) {
        Vaccine vaccine = new Vaccine();
        int resp = JOptionPane.showConfirmDialog(null, "¿Ingresar Vacuna?", "Encolando datos",
                JOptionPane.YES_NO_OPTION);
        while (resp == JOptionPane.YES_OPTION) {
            vaccine = vaccine.vaccineRegistry();
            stack.Push(vaccine);
            resp = JOptionPane.showConfirmDialog(null, "¿Ingresar otra vacuna?", "encolando datos",
                    JOptionPane.YES_NO_OPTION);
        }
        return stack;
    }

    public void stackMovement(Stack a, Stack b) {
        while (a.isEmpty() == false) {
            b.Push(a.Pop());
        }
    }

    public String print(Stack stack, Stack auxStack) {
        String text = "";
        Object data;
        while (stack.isEmpty() == false) {
            data = stack.Pop();
            text = text + data.toString() + "\n";
            auxStack.Push(data);
        }
        stackMovement(auxStack, stack);
        return text;
    }

    // public Stack higherStatStack(Stack stack, String stat) {
    //     Object higherStatElement = stack.Pop();
    //     while(stack.isEmpty() == false){
    //         Object actualElement = stack.Pop();
    //         if(actualElement.)
    //     }
    //}
}
